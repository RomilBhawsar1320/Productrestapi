package com.newgen.Productrestapi.service;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.exception.ProductNotFoundException;
import com.newgen.Productrestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DatabaseProductService implements IProductService {

    private ProductRepository productRepository;

    @Autowired
    public DatabaseProductService( ProductRepository productRepository) {

        System.out.println("DatabaseProductService called ");
        this.productRepository = productRepository;
    }
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public Product getById(Long id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        else {
            throw new ProductNotFoundException("INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE");

        }

    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> searchByCategory(Category category) {
        return List.of();
    }

    @Override
    public List<Product> searchByProductName(String name) {
        return List.of();
    }

    @Override
    public void updateProduct(Product newProduct) {

    }

    @Override
    public List<Product> searchByPriceRange(Double lowerPrice, Double higherPrice) {
        return List.of();
    }
}
