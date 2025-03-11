package com.newgen.Productrestapi.Model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;

    }
}
