package com.example.shared.exceptions;

public class CeibaException extends Exception {

    public CeibaException() {
        super();
    }

    public CeibaException(final Throwable cause) {
        super(cause);
    }

    public CeibaException(String message) {
        super(message);
    }

    public CeibaException(String message, Throwable cause) {
        super(message, cause);
    }
}
