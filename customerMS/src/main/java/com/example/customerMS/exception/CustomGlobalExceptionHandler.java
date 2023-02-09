package com.example.customerMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomGlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public String handler1(Exception ex) {
//        return ex.getMessage();
//    }

    @ExceptionHandler(SimAlreadyActiveException.class)
    public ResponseEntity<ErrorMessage> handler2(SimAlreadyActiveException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchServiceNumberOrSimNumberException.class)
    public  ResponseEntity<ErrorMessage> handler3(NoSuchServiceNumberOrSimNumberException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handler4(MethodArgumentNotValidException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchCustomerException.class)
    public ResponseEntity<ErrorMessage> handler5(NoSuchCustomerException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorMessage> handler5(InvalidCredentialsException ex){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorMessage,HttpStatus.OK);
    }
}
