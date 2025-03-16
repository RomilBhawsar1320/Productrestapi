package com.newgen.Productrestapi.dto;

import com.newgen.Productrestapi.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private Category category;
}
