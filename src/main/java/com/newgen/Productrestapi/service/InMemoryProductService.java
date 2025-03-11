package com.newgen.Productrestapi.service;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.exception.InvalidArgumentException;
import com.newgen.Productrestapi.exception.InvalidProductCategoryException;
import com.newgen.Productrestapi.exception.ProductNotFoundException;
import com.newgen.Productrestapi.utils.Constant;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class InMemoryProductService implements IProductService {


    private final Map<Long, Product> products;
    private Long id;

    final String INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE = "Invalid product identifier is provided Product not found";
    final String INVALID_CATEGORY_ERROR_MESSAGE = "Invalid category is provided Product not found";
    final String INVALID_PRODUCT_NAME_ERROR_MESSAGE = "Invalid product name is provided Product not found";

    public InMemoryProductService() {


        System.out.println("InMemoryProductService called ");
        this.products = new HashMap<>();
        this.id = 1l;



        initializeProducts();
    }

    private void initializeProducts() {
        try {
            addProduct(new Product("Laptop", 20093.2d, Category.ELECTRONICS));
            addProduct(new Product("Table", 203.2d, Category.FURNITURE));
            addProduct(new Product("tshirt", 22d, Category.CLOTHING));
            addProduct(new Product(" Galaxy book", 233.2d, Category.BOOKS));
            addProduct(new Product("Smartphone", 999.99d, Category.ELECTRONICS));
            addProduct(new Product("Headphones", 149.99d, Category.ELECTRONICS));
            addProduct(new Product("Refrigerator", 1200.50d, Category.ELECTRONICS));
            addProduct(new Product("Smartwatch", 299.99d, Category.ELECTRONICS));
            addProduct(new Product("Sofa", 899.99d, Category.FURNITURE));
            addProduct(new Product("Dining Table", 599.99d, Category.FURNITURE));
            addProduct(new Product("Chair", 79.99d, Category.FURNITURE));
            addProduct(new Product("Wardrobe", 699.99d, Category.FURNITURE));
            addProduct(new Product("Jeans", 39.99d, Category.CLOTHING));
            addProduct(new Product("Jacket", 89.99d, Category.CLOTHING));
            addProduct(new Product("Shoes", 59.99d, Category.CLOTHING));
            addProduct(new Product("Sweater", 49.99d, Category.CLOTHING));
            addProduct(new Product("Science Fiction Novel", 19.99d, Category.BOOKS));
            addProduct(new Product("Self-Help Book", 14.99d, Category.BOOKS));
            addProduct(new Product("Cookbook", 24.99d, Category.BOOKS));
            addProduct(new Product("Biography", 29.99d, Category.BOOKS));
            addProduct(new Product("Microwave Oven", 249.99d, Category.ELECTRONICS));
            addProduct(new Product("Gaming Console", 499.99d, Category.ELECTRONICS));
            addProduct(new Product("Backpack", 34.99d, Category.CLOTHING));
            addProduct(new Product("Coffee Table", 149.99d, Category.FURNITURE));
        } catch (InvalidProductCategoryException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addProduct(Product product) {

        if (product.getCategory() == null) {
            throw new InvalidProductCategoryException(INVALID_CATEGORY_ERROR_MESSAGE);
        }

        product.setId(id);
        products.put(product.getId(), product);
        id++;

    }

    public Product getById(Long id) {
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


    public void delete(Long id) {
        Product prod = products.remove(id);
        if (prod == null) {
            throw new ProductNotFoundException(INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE);
        }
    }



    public void updateProduct(Product newProduct) throws ProductNotFoundException {

        Product oldProduct = products.get(newProduct.getId());

        if (oldProduct == null) {
            throw new ProductNotFoundException(INVALID_PRODUCT_IDENTIFIER_ERROR_MESSAGE);
        }

        if(oldProduct.getCategory() == null) {
            throw new InvalidProductCategoryException(INVALID_CATEGORY_ERROR_MESSAGE);
        }

        if (oldProduct != null) {
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

    public List<Product> searchByProductName(String name) {
        if (name.isEmpty()) {
            throw new InvalidArgumentException(INVALID_PRODUCT_NAME_ERROR_MESSAGE);
        }
        return products.values().stream().filter(p -> isNameMatching(p, name))
                .collect(Collectors.toList());
    }

    private boolean isNameMatching(Product product, String name) {
        return product.getName().toLowerCase().contains(name.toLowerCase());
    }

    public List<Product> searchByPriceRange(Double lowerPrice, Double higherPrice) {

        return products.values().stream().
                filter(p -> isPriceRangeValid(lowerPrice, higherPrice, p))
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

    }

    private boolean isPriceRangeValid(Double lowerPrice, Double higherPrice, Product product) {
        return product.getPrice() >= lowerPrice && product.getPrice() <= higherPrice;
    }
}




