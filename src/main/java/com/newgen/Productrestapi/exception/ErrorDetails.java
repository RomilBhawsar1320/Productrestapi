package com.newgen.Productrestapi.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    private int status;
    private String message;
    private String name;


}
