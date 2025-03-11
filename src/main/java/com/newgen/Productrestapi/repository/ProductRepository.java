package com.newgen.Productrestapi.repository;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

//    List<Product> findByPriceRange(Double lowerPrice, Double higherPrice);

    List<Product> findByCategory(Category category);

//    @Query
//    public List<Product> findAll();


}
