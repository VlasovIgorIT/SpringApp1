package com.example.springapp1.controllers;

import com.example.springapp1.model.exception.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.server.ResponseStatusException;

import static java.time.LocalDateTime.now;
import static java.util.Optional.of;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        val message = of(e.getBindingResult())
                .map(Errors::getFieldError)
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Invalid argument");
        return handleResponseStatusException(request, new ResponseStatusException(BAD_REQUEST, message));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ApiError> onHandlerMethodValidationException(HttpServletRequest request, HandlerMethodValidationException e) {
        val message = e.getAllErrors()
                .getFirst()
                .getDefaultMessage();
        return handleResponseStatusException(request, new ResponseStatusException(BAD_REQUEST, message));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> handleResponseStatusException(HttpServletRequest request, ResponseStatusException ex) {
        val statusCode = ex.getStatusCode();
        return ResponseEntity.status(statusCode).body(
                ApiError.builder()
                        .path(request.getRequestURI())
                        .timestamp(now())
                        .status(statusCode.value())
                        .message(ex.getMessage())
                        .error(ex.getReason())
                        .build());
    }
}