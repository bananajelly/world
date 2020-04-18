package com.application.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomErrorResponse {
    private String errorCode;
    private String errorMsg;
    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    public CustomErrorResponse(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
