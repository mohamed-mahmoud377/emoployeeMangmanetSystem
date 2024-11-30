package com.example.employeemanagement.exception.dtos;

public interface BaseErrorCode<E extends Enum<E>> {

    String getMessageCode();

    String getDescription();

}
