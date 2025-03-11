package com.newgen.Productrestapi;

import com.newgen.Productrestapi.Model.Category;
import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductrestapiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductrestapiApplication.class, args);

//		ProductRepository repository = context.getBean(ProductRepository.class);
//
//		repository.save(new Product("novel20",200.00, Category.BOOKS));
//		System.out.println("ProductrestapiApplication started");

//		ProductService productservice = context.getBean(ProductService.class);
//
//		productservice.getAll().forEach(System.out::println);


	}

}
