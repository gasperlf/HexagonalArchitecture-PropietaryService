package com.powerup.user.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodesEnum {

    NOT_FOUND("0000",404, "Not found"),
    USER_NOT_FOUND("0001",404, "User not Found"),
    ROL_NOT_FOUND("0016",404, "Rol not Found"),
    USER_EMAIL_ALREADY_REGISTERED("0002",409, "User's email is already registered"),
    USER_IDENTIFICATION_ALREADY_REGISTERED("0003", 409, "User's identification is already registered"),
    INVALID_CREDENTIALS("0004", 401, "User doesn't have permissions to do this action"),
    USER_DEACTIVATED("0005", 412, "User is deactivated"),
    USER_ALREADY_DEACTIVATED("0006", 412, "User is already deactivated"),
    USER_ALREADY_ACTIVATED("0007", 412, "User is already activated"),
    CITY_NOT_FOUND("0008", 404, "City not found"),
    IDENTIFICATION_TYPE_NOT_FOUND("0009", 404, "Identification type not found"),

    CONSTRAINT_VIOLATION("0010", 400, "The following parameters are invalid: "),
    IMAGE_UNEXPECTED_EXCEPTION("0011", 412, "Something go wrong with the image"),
    IMAGE_FAILED_CONNECTION("0012", 502, "Impossible to establish connection with the image service"),
    IMAGE_TIMEOUT_CONNECTION("0013", 504, "Image connection timeout"),
    IMAGE_NOT_FOUND("0014", 404, "Image Not Found"),
    ILLEGAL_STATEMENT("0015", 405, "Method Invoke Wrong"),
    METHOD_NOT_ALLOWED("0015", 405, "Request method is not supported"),
    MISSING_REQUEST_PART("0015", 400, "Missing required request part"),
    USER_NO_PERMISSIONS("0016", 404, "User doesn't have registered permissions"),

    LOGIN_MISSING_PARAMETERS("0017", 400, "Missing parameters to login"),
    AUTHENTICATION_ERROR("0018", 401, "Authentication Error: Wrong email or password");


    private String code;

    private int status;

    private String message;
}
