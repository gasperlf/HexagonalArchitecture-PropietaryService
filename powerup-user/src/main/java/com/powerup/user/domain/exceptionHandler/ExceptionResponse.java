package com.powerup.user.domain.exceptionHandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data found for the requested petition");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}