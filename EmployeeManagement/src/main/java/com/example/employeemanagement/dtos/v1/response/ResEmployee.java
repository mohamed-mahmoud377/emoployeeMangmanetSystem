package com.example.employeemanagement.dtos.v1.response;

import lombok.Data;

@Data
public class ResEmployee {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String department;

    private double salary;

}
