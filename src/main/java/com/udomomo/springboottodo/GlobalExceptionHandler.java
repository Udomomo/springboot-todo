package com.udomomo.springboottodo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({TaskNotExistException.class})
    public ResponseEntity<Object> handleTaskNotExistException(TaskNotExistException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Error body = new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        HttpStatus status = HttpStatus.NOT_FOUND;
        return handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (!(body instanceof Error)) {
            body = new Error(status.value(), status.getReasonPhrase());
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
