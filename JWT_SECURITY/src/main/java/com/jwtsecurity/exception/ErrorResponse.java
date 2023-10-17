package com.jwtsecurity.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private Integer errorCode;
    private Long timestamp;
}
