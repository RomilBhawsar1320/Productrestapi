package com.newgen.Productrestapi.service;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;

import java.util.List;

public interface IProductService {

    void addProduct(Product product);
    Product getById(Long id);
    List<Product> getAll();
    void delete(Long id);
    List<Product> searchByCategory(Category category);
    List<Product> searchByProductName(String name);
    void updateProduct(Product newProduct);
    List<Product> searchByPriceRange(Double lowerPrice, Double higherPrice);



}
