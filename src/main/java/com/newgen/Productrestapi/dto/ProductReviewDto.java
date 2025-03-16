package com.newgen.Productrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductReviewDto {
    private ProductDto productDetails;
    private ReviewDetails reviewDetails;
}
