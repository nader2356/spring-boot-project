package com.school.pfe.Exception;

public enum ErrorCodes {

    FACULTY_NOT_FOUND(1000),
    FACULTY_NOT_VALID(1001),
    FACULTY_ID_IS_NULL(1002),
    FACULTY_CODE_IS_NULL(1003),
    FACULTY_ALREADY_IN_USE(1004)

    ;
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
