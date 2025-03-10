package com.newgen.Productrestapi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductSearchCriteria {

    private String name;
    private Category category;
    private Double LowerPrice;
    private Double HigherPrice;
    private String description;


}
