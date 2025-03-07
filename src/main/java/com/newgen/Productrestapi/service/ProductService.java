package com.newgen.Productrestapi.service;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.exception.InvalidProductCategoryException;
import com.newgen.Productrestapi.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.newgen.Productrestapi.Model.Category.*;

@Service
public class ProductService {

    private final Map<Long, Product> products;
    private Long id;

    final String INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE = "Invalid product identifier is provided Product not found";

    public ProductService() {

        this.products = new HashMap<>();
        this.id = 1l;

        initializeProducts();
    }
    private void initializeProducts() {
        try {
            add(new Product("Laptop", 20093.2d, Category.ELECTRONICS));
            add(new Product("Table", 203.2d, Category.FURNITURE));
            add(new Product("tshirt", 22d, Category.CLOTHING));
            add(new Product(" Galaxy book", 233.2d, Category.BOOKS));
            add(new Product("Smartphone", 999.99d, Category.ELECTRONICS));
            add(new Product("Headphones", 149.99d, Category.ELECTRONICS));
            add(new Product("Refrigerator", 1200.50d, Category.ELECTRONICS));
            add(new Product("Smartwatch", 299.99d, Category.ELECTRONICS));
            add(new Product("Sofa", 899.99d, Category.FURNITURE));
            add(new Product("Dining Table", 599.99d, Category.FURNITURE));
            add(new Product("Chair", 79.99d, Category.FURNITURE));
            add(new Product("Wardrobe", 699.99d, Category.FURNITURE));
            add(new Product("Jeans", 39.99d, Category.CLOTHING));
            add(new Product("Jacket", 89.99d, Category.CLOTHING));
            add(new Product("Shoes", 59.99d, Category.CLOTHING));
            add(new Product("Sweater", 49.99d, Category.CLOTHING));
            add(new Product("Science Fiction Novel", 19.99d, Category.BOOKS));
            add(new Product("Self-Help Book", 14.99d, Category.BOOKS));
            add(new Product("Cookbook", 24.99d, Category.BOOKS));
            add(new Product("Biography", 29.99d, Category.BOOKS));
            add(new Product("Microwave Oven", 249.99d, Category.ELECTRONICS));
            add(new Product("Gaming Console", 499.99d, Category.ELECTRONICS));
            add(new Product("Backpack", 34.99d, Category.CLOTHING));
            add(new Product("Coffee Table", 149.99d, Category.FURNITURE));
        }
        catch (InvalidProductCategoryException e) {
            System.err.println(e.getMessage());
        }
    }

    public void add(Product product) throws InvalidProductCategoryException {

            if(product.getCategory() == null){
                throw new InvalidProductCategoryException("invalid product category");
            }

            product.setId(id);
            products.put(product.getId(), product);
            id++;

    }

    public Product getById(Long id) throws ProductNotFoundException {
        Product prod = products.get(id);
        if (prod == null) {
            throw new ProductNotFoundException(INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE);
        }
        return prod;
    }
    public List<Product> getAll() {

        System.out.println("getAll productService called");

        return new ArrayList<>(products.values());
    }


    public void delete(Long id) throws ProductNotFoundException {
        Product prod = products.remove(id);
        if (prod == null) {
            throw new ProductNotFoundException(INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE);
        }
    }

    public void updateProduct(Product newProduct)throws ProductNotFoundException {

        Product oldProduct = products.get(newProduct.getId());

        if (oldProduct == null) {
            throw new ProductNotFoundException(INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE);
        }

        if(oldProduct!= null) {
            oldProduct.setName(newProduct.getName());
            oldProduct.setPrice(newProduct.getPrice());
            oldProduct.setCategory(newProduct.getCategory());

        }

    }

    public List<Product> searchByCategory(Category category) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getCategory().equals(category)) {
                matchingProducts.add(product);
            }
            }
            return matchingProducts;
        }

        public List<Product> searchByName(String name) {
        return products.values().stream().filter(p -> isNameMatching(p, name))
                .collect(Collectors.toList());
        }

        private boolean isNameMatching(Product product, String name) {
            return product.getName().toLowerCase().contains(name.toLowerCase());
        }

        public List<Product> searchByPriceRange(Double lowerPrice, Double higherPrice) {

        return products.values().stream().
                filter(p -> isPriceRangeValid(lowerPrice,higherPrice,p))
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        }

        private boolean isPriceRangeValid(Double lowerPrice, Double higherPrice,Product product) {
        return product.getPrice()>=lowerPrice && product.getPrice()<=higherPrice;
        }
    }




