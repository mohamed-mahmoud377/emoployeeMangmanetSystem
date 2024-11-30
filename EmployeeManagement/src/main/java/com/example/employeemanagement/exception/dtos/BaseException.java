package com.example.employeemanagement.exception.dtos;


import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException {

    @Builder.Default
    private HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
    private BaseErrorCode<? extends Enum<?>> errorCode;
    private Object detail;

}
