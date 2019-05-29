package com.example.shared.exceptions;

public class DBNoSuchElementException extends CeibaException {

    public DBNoSuchElementException() {
        super();
    }

    public DBNoSuchElementException(final Throwable cause) {
        super(cause);
    }

    public DBNoSuchElementException(String message) {
        super(message);
    }

    public DBNoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
