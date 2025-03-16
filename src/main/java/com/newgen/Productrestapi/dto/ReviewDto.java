package com.newgen.Productrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDto {

    private Long productId;
    private int userId;
    private short ratings;
    private String title;
    private String description;


    public ReviewDto() {

    }
}
