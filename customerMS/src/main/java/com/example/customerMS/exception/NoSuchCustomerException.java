package com.example.customerMS.exception;

public class NoSuchCustomerException extends Exception{
    private static final long serialVersionUID = 1L;

    public NoSuchCustomerException() {
        super();
    }

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
