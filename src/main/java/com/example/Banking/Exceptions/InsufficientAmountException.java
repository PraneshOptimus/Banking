package com.example.Banking.Exceptions;

public class InsufficientAmountException extends RuntimeException{
    public InsufficientAmountException(String msg){
        super(msg);
    }
}
