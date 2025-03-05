package com.newgen.Productrestapi.Model;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private long id;
    private String name;
    private double price;
    private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;

    }
}
