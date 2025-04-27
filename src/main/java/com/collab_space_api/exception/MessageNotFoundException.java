package com.collab_space_api.exception;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String message) {
        super(message);
    }

    public MessageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
