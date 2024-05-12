package com.example.bankapplication.loans.exception;

import com.example.bankapplication.loans.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleLoanAlreadyExistsException(LoanAlreadyExistsException e, HttpServletRequest request){
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
