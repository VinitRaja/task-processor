package com.example.taskprocessor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Base class for all your domain exceptions
public abstract class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}

