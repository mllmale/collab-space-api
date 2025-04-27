package com.collab_space_api.exception;

public class TeamUserNotFoundException extends RuntimeException {

    public TeamUserNotFoundException(String message) {
        super(message);
    }

    public TeamUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
