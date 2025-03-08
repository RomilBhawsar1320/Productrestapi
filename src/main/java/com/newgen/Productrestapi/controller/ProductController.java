package com.newgen.Productrestapi.controller;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.exception.InvalidProductCategoryException;
import com.newgen.Productrestapi.exception.ProductNotFoundException;
import com.newgen.Productrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) String category,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(name = "lower-price", required = false) Double lowerPrice,
                                        @RequestParam(name = "higher-price", required = false) Double higherPrice) {

        System.out.println("getAll product controller method  called");
        if (category != null) {
            Category cat = Category.valueOf(category);
            return productService.searchByCategory(cat);
        }
        if (name != null) {
            return productService.searchByName(name);
        }
        if (lowerPrice != null && higherPrice != null) {
            return productService.searchByPriceRange(lowerPrice, higherPrice);
        }
        return productService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {

        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        System.out.println("addProduct method called");
        try {
            productService.add(product);
        } catch (InvalidProductCategoryException e) {

            e.printStackTrace();

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Product added Succesfully ", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductbyID(@PathVariable(name = "id") Long productId) {
        System.out.println("deleteProduct method called");
        productService.delete(productId);
        return new ResponseEntity<>("product deleted successfully", HttpStatus.OK);


    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        System.out.println("updateProduct method called");
        product.setId(id);

        productService.updateProduct(product);
        return new ResponseEntity<>("product updated successfully", HttpStatus.OK);

    }

////    @GetMapping("/api/v1/products/search/{category}")
////    public List<Product> searchByCategory(@PathVariable(name = "category") Category category) {
////        System.out.println("searchByCategory method called");
////        return productService.searchByCategory(category);
//
//    }

}
