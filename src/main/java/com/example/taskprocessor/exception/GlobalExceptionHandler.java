package com.example.taskprocessor.exception;

import com.example.taskprocessor.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Handle specific TaskNotFoundException (High specificity)
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(TaskNotFoundException ex, HttpServletRequest request) {
        return buildResponse(HttpStatus.NOT_FOUND, "Task Not Found", ex.getMessage(), request);
    }

    // 2. Handle any other BaseException (Medium specificity)
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleAppExceptions(BaseException ex, HttpServletRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Application Error", ex.getMessage(), request);
    }

    // 3. Fallback for all other Exceptions (Low specificity / Catch-all)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralExceptions(Exception ex, HttpServletRequest request) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", "An unexpected error occurred", request);
    }

    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String error, String message, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(error)
                .message(message)
                .path(request.getRequestURI())
                .build();
        
        return new ResponseEntity<>(body, status);
    }
}
