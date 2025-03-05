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
      add(new Product(1l,"Laptop",20093.2d,Category.ELECTRONICS));
       add(new Product(2l,"Table",203.2d,Category.FURNITURE));
       add(new Product(3l,"tshirt",22d,Category.CLOTHING));
       add(new Product(4l," Galaxy book",233.2d,Category.BOOKS));



    }

    public void add(Product product) {

        products.put(product.getId(), product);
        id++;

    }

    public Product getById(Long id) {

        return products.get(id);
    }
    public List<Product> getAll() {

        return new ArrayList<>(products.values());
    }

    public boolean delete(Product product) {

        return products.remove(product.getId()) != null;
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




