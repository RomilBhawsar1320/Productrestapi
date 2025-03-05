package com.newgen.Productrestapi.controller;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/api/v1/products")
    public List<Product> getAllProducts() {

        System.out.println("getAll product controller method  called");

        return productService.getAll();

    }
    @GetMapping("/api/v1/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        System.out.println("getProductById method called");
        return productService.getById(id);
    }
    @PostMapping("/api/v1/products")
    public String addProduct(@RequestBody Product product) {
        productService.add(product);
        System.out.println("addProduct method called");
        return "product added successfully";
    }

    @DeleteMapping("/api/v1/products/{id}")
    public String deleteProductbyID(@PathVariable(name = "id") Long productId) {
        System.out.println("deleteProduct method called");
        boolean status = productService.delete(productId);
        if (status) {
            return "product deleted successfully";
        } else {
            return "product not deleted";
        }
    }

    @PutMapping("/api/v1/products/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable Long id) {
        System.out.println("updateProduct method called");
        product.setId(id);
        boolean status = productService.updateProduct(product);

        if (status) {
            return "product updated successfully";
        }
        return "product not found or not updated";
    }

    @GetMapping("/api/v1/products/search/{category}")
    public List<Product> searchByCategory(@PathVariable(name = "category") Category category) {
        System.out.println("searchByCategory method called");
        return productService.searchByCategory(category);

    }

}
