package com.softeck.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

    public String getDetails() {
        return details;
    }
}
