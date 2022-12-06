package com.school.pfe.Exception;

public enum ErrorCodes {

    FACULTY_NOT_FOUND(1000),
    FACULTY_NOT_VALID(1001),
    FACULTY_ID_IS_NULL(1002),
    FACULTY_CODE_IS_NULL(1003),
    FACULTY_ALREADY_IN_USE(1004),

    ABSENCE_NOT_FOUND(2000),
    ABSENCE_NOT_VALID(2001),

    LEVEL_NOT_FOUND(3000),
    LEVEL_NOT_VALID(3001),
    LEVEL_ID_IS_NULL(3002),
    LEVEL_CODE_IS_NULL(3003),
    LEVEL_ALREADY_IN_USE(3004)

    ;
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
