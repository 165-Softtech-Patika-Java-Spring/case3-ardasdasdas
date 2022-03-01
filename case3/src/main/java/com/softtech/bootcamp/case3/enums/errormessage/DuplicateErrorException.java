package com.softtech.bootcamp.case3.enums.errormessage;

public enum DuplicateErrorException {

    USER_DUPLICATE_ERROR_EXCEPTION("User is already exists!"),
    ;

    private String message;

    DuplicateErrorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }
}
