package com.ceyloneagro.ceyloneagrobackendservice.enumeration;

import lombok.Getter;

@Getter
public enum ApplicationStatus {


    TOKEN_GENERATION_SUCCESS("S-000", "Solution List Fetched Succesfully."),
    TOKEN_GENERATION_FAILED("F-000", "Solution List Fetched Failed.");

    private String code;
    private String message;

    private ApplicationStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
