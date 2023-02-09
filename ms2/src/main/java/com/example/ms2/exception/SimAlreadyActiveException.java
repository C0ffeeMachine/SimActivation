package com.example.ms2.exception;

public class SimAlreadyActiveException extends Exception{
    private static final long serialVersionUID = 1L;

    public SimAlreadyActiveException() {
        super();
    }

    public SimAlreadyActiveException(String message) {
        super(message);
    }
}
