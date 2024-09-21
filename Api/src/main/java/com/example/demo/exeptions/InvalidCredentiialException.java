package com.example.demo.exeptions;

public class InvalidCredentiialException extends RuntimeException{
    public InvalidCredentiialException(String message){
        super(message);
    }
}
