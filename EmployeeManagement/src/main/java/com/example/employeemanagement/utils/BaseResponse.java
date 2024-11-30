package com.example.employeemanagement.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class BaseResponse<T> {

    private T response;
    private boolean status = true;

    @JsonFormat(pattern = DateFormat.DATE_FORMAT_CLIENT)
    private Date currentDate;
    private String correlationId;

    public BaseResponse(T response) {
        this.response = response;
        this.currentDate = new Date();
        this.correlationId = UUID.randomUUID().toString();

    }

}