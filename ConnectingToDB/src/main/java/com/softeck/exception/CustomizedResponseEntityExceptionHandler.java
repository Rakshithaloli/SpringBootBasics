package com.softeck.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
      ExceptionDetails exceptionDetails= new ExceptionDetails(new Date(),ex.getMessage(),request.getDescription(false));
      return new ResponseEntity(exceptionDetails, HttpStatus.MULTI_STATUS.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(notFoundException.class)
    public final ResponseEntity<Object> handlernotFoundException(notFoundException ex, WebRequest request) throws Exception {
        ExceptionDetails exceptionDetails= new ExceptionDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);

    }
}
