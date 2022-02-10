package com.ceyloneagro.ceyloneagrobackendservice.enumeration;

import lombok.Getter;

@Getter
public enum ApplicationStatus {


    TOKEN_GENERATION_SUCCESS("S-000", "New user token generated."),
    TOKEN_GENERATION_FAILED("F-000", "User token generation failed."),
    USER_REGISTRATION_SUCCESS("S-001", "New user has been successfully created."),
    USER_REGISTRATION_FAILED("F-001", "User registration failed.");


    private String code;
    private String message;

    private ApplicationStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
