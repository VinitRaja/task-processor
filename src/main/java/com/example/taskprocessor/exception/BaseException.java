package com.example.taskprocessor.exception;


// Base class for all your domain exceptions
public abstract class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}

