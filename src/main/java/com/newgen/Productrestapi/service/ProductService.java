package com.newgen.Productrestapi.service;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.newgen.Productrestapi.Model.Category.*;

@Service
public class ProductService {

    private final Map<Long, Product> products;


    private Long id;

    public ProductService() {

        this.products = new HashMap<>();
        this.id = 1l;

        initializeProducts();
    }
    private void initializeProducts() {
        add(new  Product("Laptop",20093.2d,Category.ELECTRONICS));
       add(new Product("Table",203.2d,Category.FURNITURE));
       add(new Product("tshirt",22d,Category.CLOTHING));
       add(new Product(" Galaxy book",233.2d,Category.BOOKS));



    }

    public void add(Product product) {
        product.setId(id);
        products.put(product.getId(), product);
        id++;

    }

    public Product getById(Long id) {

        return products.get(id);
    }
    public List<Product> getAll() {

        System.out.println("getAll productService called");

        return new ArrayList<>(products.values());
    }


    public boolean delete(Long id) {

        return products.remove(id) != null;
    }

    public boolean updateProduct(Product newProduct) {

        Product oldProduct = products.get(newProduct.getId());

        if(oldProduct!= null) {
            oldProduct.setName(newProduct.getName());
            oldProduct.setPrice(newProduct.getPrice());
            oldProduct.setCategory(newProduct.getCategory());
            return true;

        }
        return false;
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
    }




