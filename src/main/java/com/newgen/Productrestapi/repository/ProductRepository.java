package com.newgen.Productrestapi.repository;

import com.newgen.Productrestapi.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query
//    public List<Product> findAll();


}
