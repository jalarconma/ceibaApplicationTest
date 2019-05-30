package com.example.shared.exceptions;

public class ServerException extends CeibaException {

    public ServerException() {
        super();
    }

    public ServerException(final Throwable cause) {
        super(cause);
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
