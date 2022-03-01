package com.softtech.bootcamp.case3.enums.errormessage;

public enum NotFoundErrorMessage {

    PRODUCT_NOT_FOUND_ERROR_MESSAGE("Product Not Found"),
    USER_NOT_FOUND_BY_ID_ERROR_MESSAGE("User Not Found By Id"),
    USER_NOT_FOUND_BY_USERNAME_ERROR_MESSAGE("User Not Found By Username"),
    COMMENT_NOT_FOUND_BY_ID_ERROR_MESSAGE("Comment Not Found By Id"),
    ;

    private String message;

    NotFoundErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }
}
