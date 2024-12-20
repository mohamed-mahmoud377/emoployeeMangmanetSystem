package com.example.employeemanagement.exception.enums;

import com.example.employeemanagement.exception.dtos.BaseErrorCode;
import lombok.Getter;

@Getter
public enum ErrorCode implements BaseErrorCode<ErrorCode> {

    // NOT_FOUND
    NOT_FOUND_EMPLOYEE("not.found.employee", "Not Found employee"),
    NOT_VALID_INPUT("not.valid.input", "Not Valid Input"),
    SOMETHING_WENT_WRONG("something.went.wrong", "Something went Wrong!"),
    FEIGN_CLIENT_EXPECTATION("something.went.wrong", "feign client exception happened");

    private final String messageCode;
    private final String description;

    ErrorCode(String messageCode, String description) {
        this.messageCode = messageCode;
        this.description = description;
    }

}
