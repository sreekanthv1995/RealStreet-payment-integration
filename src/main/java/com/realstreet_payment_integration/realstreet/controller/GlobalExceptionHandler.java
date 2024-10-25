package com.realstreet_payment_integration.realstreet.controller;

import com.realstreet_payment_integration.realstreet.dto.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?>handleUserNotFound(UsernameNotFoundException exception){
        ErrorResponse userNotFound = new ErrorResponse(LocalDateTime.now(),
                exception.getMessage(),"UserNotFound");
        return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?>handleIllegalArgumentException(IllegalArgumentException exception){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),
                exception.getMessage(),"Something Wrong");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?>handleEntityNotFoundException(EntityNotFoundException exception){
        ErrorResponse entityNotFound = new ErrorResponse(LocalDateTime.now(),
                exception.getMessage(),"Not found");
        return new ResponseEntity<>(entityNotFound, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?>handleBadCredentialException(BadCredentialsException exception){
        ErrorResponse badRequest = new ErrorResponse(LocalDateTime.now(),
                exception.getMessage(),"Username or Password incorrect");
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<?>handleBadCredentialException(InternalAuthenticationServiceException exception){
        ErrorResponse badRequest = new ErrorResponse(LocalDateTime.now(),
                exception.getMessage(),"Internal Server error");
        return new ResponseEntity<>(badRequest, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

