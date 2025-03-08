package com.newgen.Productrestapi.exception;

public class InvalidProductCategoryException extends RuntimeException{
    public InvalidProductCategoryException(String message) {
        super(message);
    }
}
