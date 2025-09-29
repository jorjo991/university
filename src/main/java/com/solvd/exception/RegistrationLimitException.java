package com.solvd.exception;

public class RegistrationLimitException extends Exception {

    public RegistrationLimitException(String message) {
        super(message);
    }

    public RegistrationLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
