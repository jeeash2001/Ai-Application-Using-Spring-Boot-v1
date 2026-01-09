package com.ai_demo_app.AiApplicationVersion.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AiResponse {

    private String result;
    String errorCode;
    LocalDateTime timestamp;
    public AiResponse(String result) {
        this.result = result;
        //this.errorCode = null;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getResult() {
        return result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
