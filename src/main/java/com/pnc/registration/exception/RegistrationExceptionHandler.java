package com.pnc.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RegistrationExceptionHandler {
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "User is located outside Canada so cannot register")
    @ExceptionHandler(UserOutsideCanadaException.class)
    public ResponseEntity<Error> handleException(UserOutsideCanadaException e) {
        Error error = new Error(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "Password is either greater than 8 chars or does not contain at least 1 number, 1 capitalized letter, and 1 special character in this set: _#$%.")
    @ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity<Error> handleException(PasswordInvalidException e) {
        Error error = new Error(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "One or more of  the input parameters is null or empty")
    @ExceptionHandler(InputIsNullOrEmptyException.class)
    public ResponseEntity<Error> handleException(InputIsNullOrEmptyException e) {
        Error error = new Error(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
