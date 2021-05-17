package com.example.demo.exception;

import java.util.Date;

public class ErrorMessage {
    private final int statusCode;
    private final Date timeStamp;
    private final String message;
    private final String description;

    public ErrorMessage(int statusCode, Date timeStamp, String message, String description) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
