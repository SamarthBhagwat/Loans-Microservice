package com.example.bankapplication.loans.exception;

public class LoanAlreadyExistsException extends RuntimeException{

    public LoanAlreadyExistsException(String message){
        super(message);
    }
}
