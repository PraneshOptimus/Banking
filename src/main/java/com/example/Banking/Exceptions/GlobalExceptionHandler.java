package com.example.Banking.Exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> errorDetailsResponseEntity(UserNotFoundException userNotFoundException,
                                                                   WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                userNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "ACCOUNT_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientAmountException.class)
    public ResponseEntity<ErrorDetails> SpecificException(InsufficientAmountException insufficientAmountException,
                                                          WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                insufficientAmountException.getMessage(),
                webRequest.getDescription(false),
                "Insufficient Amount"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> genericExceptions(Exception exception,
                                                          WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                LocalDate.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internel_Server_Error"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
