package com.example.shared.exceptions;

public class NetworkException extends CeibaException {

    public NetworkException() {
        super();
    }

    public NetworkException(final Throwable cause) {
        super(cause);
    }

    public NetworkException(String message) {
        super(message);
    }

    public NetworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
