package com.example.employeemanagement.enums;

import lombok.Getter;

@Getter
public enum Language {
    AR("ar", "002", "Arabic"),
    EN("en", "001", "English");

    private final String code;
    private final String langCode;
    private final String eFormName;

    // Constructor
    Language(String code, String langCode, String eFormName) {
        this.code = code;
        this.langCode = langCode;
        this.eFormName = eFormName;
    }
}