package com.sojern.assignment.exception.handler;

import com.sojern.assignment.exception.InvalidRequestException;
import com.sojern.assignment.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMinRequestException(InvalidRequestException invalidRequestException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(invalidRequestException.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }
}
