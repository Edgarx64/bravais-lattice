package com.web.controller;

public class InvalidTokenException extends RuntimeException {
    InvalidTokenException(String message){
        super(message);
    }

    InvalidTokenException(){
        this("Invalid token");
    }
}
