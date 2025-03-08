package com.newgen.Productrestapi.exception;

public class ProductNotFoundException extends   RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
