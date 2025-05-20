package com.frukas.warehouse.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotSaved.class)
    public ResponseEntity<String> resourceNotSavedExceptionHandler(RuntimeException e, WebRequest request){

        log.error("Resource not saved error: {}" , e.getMessage(), e);

        return ResponseEntity.badRequest().body("Resource not saved");
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> resourceNotFoundExceptionHandler(RuntimeException e, WebRequest request){

        log.error("Resource not found error: {}" , e.getMessage(), e);

        return ResponseEntity.badRequest().body("Resource not found");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> genericExceptionHandler(RuntimeException e, WebRequest request){

        log.error("Generic Error: {}" , e.getMessage(), e);

        return ResponseEntity.internalServerError().body("Unhandled internal exception");
    }
}
