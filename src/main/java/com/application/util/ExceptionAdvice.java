package com.application.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<CustomErrorResponse> handle(RuntimeException e) {
        CustomErrorResponse error = new CustomErrorResponse("RUNTIME_EXCEPTION", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
