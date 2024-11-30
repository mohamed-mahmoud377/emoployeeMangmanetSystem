package com.example.employeemanagement.utils;


import com.example.employeemanagement.enums.Language;
import com.example.employeemanagement.exception.dtos.BaseError;
import com.example.employeemanagement.exception.dtos.BaseErrorCode;
import com.example.employeemanagement.exception.dtos.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExceptionHandlerUtil {

    private final MessageSource messageSource;

    public ResponseEntity<BaseError> commonReturn(BaseException e) {
        BaseErrorCode<?> errorCode = e.getErrorCode();
        BaseError errorInfo = new BaseError(errorCode,
                getTranslatedMessage(errorCode.getMessageCode(), Language.AR),
                getTranslatedMessage(errorCode.getMessageCode(), Language.EN),
                e.getDetail());

        return new ResponseEntity<>(errorInfo, e.getHttpStatus());
    }

    public String getTranslatedMessage(String message, Language language) {
        return !Strings.isEmpty(message)
                ? messageSource.getMessage(message, null, new Locale(language.getCode()))
                : "";
    }

}