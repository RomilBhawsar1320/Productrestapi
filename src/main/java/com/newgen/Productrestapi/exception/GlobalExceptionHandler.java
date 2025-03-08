package com.newgen.Productrestapi.exception;

import com.newgen.Productrestapi.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException e) {
        System.err.println(e);
        ErrorDetails errorDetail = new ErrorDetails(HttpStatus.NOT_FOUND.value(),e.getMessage(),"Product Not Found");
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidProductCategoryException.class)
    public ResponseEntity<ErrorDetails> handleInvalidProductCategoryException(InvalidProductCategoryException e) {
        System.err.println(e);
        ErrorDetails errorDetail = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),"WRONG INPUT");
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ErrorDetails> handleInvalidArgumentException(InvalidArgumentException e) {
        System.err.println(e);
        ErrorDetails errorDetail = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),e.getMessage(),"WRONG INPUT");
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception e) {
        System.err.println(e);
        ErrorDetails errorDetail = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),"INTERNAL SERVER ERROR");
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
