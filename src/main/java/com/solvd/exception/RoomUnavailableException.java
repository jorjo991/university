package com.solvd.exception;

public class RoomUnavailableException extends RuntimeException {

    public RoomUnavailableException(String message) {
        super(message);
    }

    public RoomUnavailableException() {
    }

    public RoomUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomUnavailableException(Throwable cause) {
        super(cause);
    }

    public RoomUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
