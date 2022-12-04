package com.school.pfe.Exception;

public enum ErrorCodes {

    FACULTY_NOT_FOUND(1000),
    FACULTY_NOT_VALID(1001),
    LEVEL_NOT_FOUND(2000),
    LEVEL_NOT_VALID(2001),
    LEVEL_ID_IS_NULL(2002),
    ;
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
