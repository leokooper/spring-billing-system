package ru.leonchenko.springbilling.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@ControllerAdvice
class TransactionRestExceptionHandler{

    @ExceptionHandler
    public ResponseEntity<TransactionExceptionResponse> handleException(Exception e) {

        TransactionExceptionResponse customerErrorResponse = new TransactionExceptionResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
