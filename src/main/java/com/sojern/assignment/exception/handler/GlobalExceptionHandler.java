package com.sojern.assignment.exception.handler;

import com.sojern.assignment.exception.InvalidMinRequestException;
import com.sojern.assignment.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidMinRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMinRequestException(InvalidMinRequestException invalidMinRequestException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(invalidMinRequestException.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }
}
