package com.example.customerMS.exception;

public class NoSuchServiceNumberOrSimNumberException extends Exception{
    private static final long serialVersionUID = 1L;

    public NoSuchServiceNumberOrSimNumberException() {
        super();
    }

    public NoSuchServiceNumberOrSimNumberException(String message) {
        super(message);
    }
}
