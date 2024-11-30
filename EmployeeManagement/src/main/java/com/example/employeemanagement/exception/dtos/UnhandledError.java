package com.example.employeemanagement.exception.dtos;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UnhandledError {

    private String msg;
    private String spanId;
    private String traceId;


    public UnhandledError() {
    }

    public UnhandledError(String msg, String spanId, String traceId) {
        super();
        this.msg = msg;
        this.spanId = spanId;
        this.traceId = traceId;

    }

}
