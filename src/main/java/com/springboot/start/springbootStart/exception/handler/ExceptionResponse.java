package com.springboot.start.springbootStart.exception.handler;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/**
 * Format Response
 */
@Data
public class ExceptionResponse {

    /**
     * exception code
     */
    private String errorCode;
    /**
     * exception message
     */
    private String errorMessage;
    /**
     * random number
     */
    private String incidentId;
    private List<String> errors;

 
    private String timeStamp;

    public ExceptionResponse(String errorCode, String errorMessage, String incidentId) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.incidentId = incidentId;
        this.timeStamp = new Timestamp(System.currentTimeMillis()).toString().substring(0, 19);
    }

    public ExceptionResponse(String errorCode, List<String> errors) {
        super();
        this.errorCode = errorCode;
        this.errors = errors;
        this.timeStamp = new Timestamp(System.currentTimeMillis()).toString().substring(0, 19);
    }
}