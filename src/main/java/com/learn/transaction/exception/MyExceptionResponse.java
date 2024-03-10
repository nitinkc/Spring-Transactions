package com.learn.transaction.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MyExceptionResponse {
    private String from;
    private String errorCode;
    private String errorMessage;
    private String methodName;
    private String requestedURI;
    private String thrownByMethod;
    private String thrownByClass;
    private String exceptionType;
    private String requestPayload;
    private String stackTrace;
    private String timestamp;
    private String environmentInfo;
}
