package com.newgen.Productrestapi.listener;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.exception.InvalidProductCategoryException;
import com.newgen.Productrestapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

    @Autowired
    private IProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void handleEvent(ApplicationEvent event) {

        System.out.println("ApplicationEventListener called"+event);
        initializeProducts();
    }
    private void initializeProducts() {
        try {
            productService.addProduct(new Product("Laptop", 20093.2d, Category.ELECTRONICS));
            productService.addProduct(new Product("Table", 203.2d, Category.FURNITURE));
            productService.addProduct(new Product("tshirt", 22d, Category.CLOTHING));
            productService.addProduct(new Product(" Galaxy book", 233.2d, Category.BOOKS));
            productService.addProduct(new Product("Smartphone", 999.99d, Category.ELECTRONICS));
            productService.addProduct(new Product("Headphones", 149.99d, Category.ELECTRONICS));
            productService.addProduct(new Product("Refrigerator", 1200.50d, Category.ELECTRONICS));
            productService.addProduct(new Product("Smartwatch", 299.99d, Category.ELECTRONICS));
            productService.addProduct(new Product("Sofa", 899.99d, Category.FURNITURE));
            productService.addProduct(new Product("Dining Table", 599.99d, Category.FURNITURE));
            productService.addProduct(new Product("Chair", 79.99d, Category.FURNITURE));
            productService.addProduct(new Product("Wardrobe", 699.99d, Category.FURNITURE));
            productService.addProduct(new Product("Jeans", 39.99d, Category.CLOTHING));
            productService.addProduct(new Product("Jacket", 89.99d, Category.CLOTHING));
            productService.addProduct(new Product("Shoes", 59.99d, Category.CLOTHING));
            productService.addProduct(new Product("Sweater", 49.99d, Category.CLOTHING));
            productService.addProduct(new Product("Science Fiction Novel", 19.99d, Category.BOOKS));
            productService.addProduct(new Product("Self-Help Book", 14.99d, Category.BOOKS));
            productService.addProduct(new Product("Cookbook", 24.99d, Category.BOOKS));
            productService.addProduct(new Product("Biography", 29.99d, Category.BOOKS));
            productService.addProduct(new Product("Microwave Oven", 249.99d, Category.ELECTRONICS));
            productService.addProduct(new Product("Gaming Console", 499.99d, Category.ELECTRONICS));
            productService.addProduct(new Product("Backpack", 34.99d, Category.CLOTHING));
            productService.addProduct(new Product("Coffee Table", 149.99d, Category.FURNITURE));
        } catch (InvalidProductCategoryException e) {
            System.err.println(e.getMessage());
        }
    }
    }

