package com.example.bankapplication.loans.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource, String key, String value){
        super(String.format("%s resource not found for key %s with value %s" , resource, key, value));
    }
}
