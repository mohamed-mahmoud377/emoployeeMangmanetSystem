package com.example.employeemanagement.exception.handler;

import brave.Span;
import brave.Tracer;
import com.example.employeemanagement.exception.dtos.ApiFieldError;
import com.example.employeemanagement.exception.dtos.BaseError;
import com.example.employeemanagement.exception.dtos.BaseException;
import com.example.employeemanagement.exception.dtos.UnhandledError;
import com.example.employeemanagement.exception.enums.ErrorCode;
import com.example.employeemanagement.exception.exceptions.EmployeeNotFoundException;
import com.example.employeemanagement.exception.exceptions.InvalidInputException;
import com.example.employeemanagement.utils.ExceptionHandlerUtil;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {


    private final  Environment environment;

    private final ExceptionHandlerUtil exceptionHandlerUtil;

    private final Tracer tracer;

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public
    ResponseEntity<String> handleInvalidInput(InvalidInputException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseError>  handleGeneralException(Exception exception) {
        log.error("Unhandled error happened with message: {} and class: {}", exception.getMessage(),exception.getClass());
        exception.printStackTrace();

        if (environment.acceptsProfiles(Profiles.of("dev","test","local"))){

            Span span = tracer.currentSpan();

            return exceptionHandlerUtil
                    .commonReturn(BaseException.builder()
                            .errorCode(ErrorCode.SOMETHING_WENT_WRONG)
                            .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                            .detail(new UnhandledError(exception.toString(),
                                    span != null ?span.context().spanIdString(): null,
                                    span !=null ? span.context().traceIdString(): null))
                            .build());
        }else {
            return exceptionHandlerUtil
                    .commonReturn(BaseException
                            .builder()
                            .errorCode(ErrorCode.SOMETHING_WENT_WRONG)
                            .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                            .detail("oops! something went wrong please try again later")
                            .build());
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiFieldError handleHttpMessageNotReadableException(HttpServletRequest req, HttpMessageNotReadableException e) {

        Throwable cause = e.getCause();
        if (cause instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) cause;
            String rejectedValue = invalidFormatException.getValue().toString();
            String name = invalidFormatException.getPath().get(0).getFieldName();
            return new ApiFieldError(name, "NotReadable", rejectedValue);
        }
        return null;
    }

    @ExceptionHandler(SizeLimitExceededException.class)
    @ResponseBody
    public ResponseEntity<BaseError> handleSizeLimitExceededException(HttpServletRequest req, SizeLimitExceededException e) {
        return exceptionHandlerUtil
                .commonReturn(BaseException
                        .builder()
                        .errorCode(ErrorCode.EXCEED_LIMIT_FILE_SIZE)
                        .httpStatus(HttpStatus.TOO_MANY_REQUESTS)
                        .detail(e.getMessage())
                        .build());
    }

}
