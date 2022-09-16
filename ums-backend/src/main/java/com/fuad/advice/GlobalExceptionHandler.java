package com.fuad.advice;

import com.fuad.exception.DuplicateEntryException;
import com.fuad.exception.ErrorResponse;
import com.fuad.exception.ItemValidationError;
import com.fuad.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String NOT_FOUND = "not_data_found";
    public static final String VALIDATION_ERROR = "validation_error";
    public static final String DUPLICATE_ENTRY = "duplicate_entry";

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(NOT_FOUND, e.getMessage());
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    protected ResponseEntity<?> handleDuplicateEntryException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(DUPLICATE_ENTRY, e.getMessage());
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return getValidationErrorResponse(e, "Enter all required fields");
    }

    @ExceptionHandler(value = {BindException.class})
    protected ResponseEntity<Object> handleBindException(BindException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getValidationErrorResponse(e, "Request is not valid");
    }

    private ResponseEntity<Object> getValidationErrorResponse(BindException e, String message) {
        ErrorResponse response = new ErrorResponse(VALIDATION_ERROR, message);
        List<ItemValidationError> validationErrors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach((v) -> validationErrors.add(new ItemValidationError(v.getObjectName(), v.getField(), v.getRejectedValue(), v.getDefaultMessage())));
        response.setErrorItems(validationErrors);
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private void printStackTrace(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        StringBuilder traceLines = new StringBuilder();
        traceLines.append("Caused By: ").append(e.fillInStackTrace()).append("\n");
        Arrays.stream(trace).filter(f -> f.getClassName().contains("com.fuad")).forEach(f -> traceLines.append("\tat ").append(f).append("\n"));
        log.error(traceLines.toString());
    }
}
