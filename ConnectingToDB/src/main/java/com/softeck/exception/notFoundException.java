package com.softeck.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class notFoundException extends RuntimeException {
   public notFoundException(String message) {
      super(message);
   }
}
