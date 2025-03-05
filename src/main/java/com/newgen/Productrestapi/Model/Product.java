package com.newgen.Productrestapi.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private long id;
    private String name;
    private double price;
    private Category category;
}
