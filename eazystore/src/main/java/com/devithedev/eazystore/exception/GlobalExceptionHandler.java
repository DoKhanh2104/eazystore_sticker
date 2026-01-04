package com.devithedev.eazystore.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.devithedev.eazystore.dto.ErrorResponseDto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
                        WebRequest webRequest) {
                ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
                                HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), LocalDateTime.now());
                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(errorResponseDto);
                // option 2
                // return new ResponseEntity<>(errorResponseDto,
                // HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(
                        MethodArgumentNotValidException exception) {
                Map<String, String> errors = new HashMap<>();
                List<FieldError> fileldErrorList = exception.getBindingResult().getFieldErrors();
                fileldErrorList.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(errors);
        }

        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<Map<String, String>> handleConstraintViolationExceptions(
                        ConstraintViolationException exception) {
                Map<String, String> errors = new HashMap<>();
                Set<ConstraintViolation<?>> constraintViolationSet = exception.getConstraintViolations();
                constraintViolationSet.forEach(constraintViolation -> errors.put(
                                constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
                return ResponseEntity.badRequest().body(errors);
        }
}
