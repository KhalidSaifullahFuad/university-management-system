package com.fuad.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ErrorResponse {

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss Z")
    private OffsetDateTime timestamp;
    private String error;
    private String message;
    private List<?> errorItems;

    public ErrorResponse(String error, String message) {
        this.timestamp = OffsetDateTime.now();
        this.error = error;
        this.message = message;
    }

    public void setErrorItems(List<?> errorItems) {
        this.errorItems = errorItems;
    }
}
