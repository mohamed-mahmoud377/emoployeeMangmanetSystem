package com.example.employeemanagement.dtos.v1.request;

import com.example.employeemanagement.utils.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ReqEmployee {

    @NotBlank
    @Pattern(regexp = ValidationConstants.LETTERS_ONLY)
    private String firstName;

    @NotBlank
    @Pattern(regexp = ValidationConstants.LETTERS_ONLY)
    private String lastName;

    @NotBlank
    @Pattern(regexp = ValidationConstants.LETTERS_ONLY)
    private String email;

    @NotBlank
    private String department;

    @NotEmpty
    private double salary;

}
