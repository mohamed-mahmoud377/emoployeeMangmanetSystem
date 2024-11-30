package com.example.employeemanagement.utils;

public interface ValidationConstants {

    String EMAIL_REGEX_PATTERN_OR_EMPTY = "^$|^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$";

    String LETTERS_ONLY = "^[a-zA-Z\\u0621-\\u064a\\ufb50-\\ufdff\\ufe70-\\ufefc ]*$";


}