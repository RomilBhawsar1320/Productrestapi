package com.newgen.Productrestapi;

import com.newgen.Productrestapi.Model.Product;
import com.newgen.Productrestapi.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductrestapiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductrestapiApplication.class, args);

		ProductService productservice = context.getBean(ProductService.class);

		productservice.getAll().forEach(System.out::println);


	}

}
