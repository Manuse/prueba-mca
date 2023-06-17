package com.pruebamca.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsMsApplication.class, args);
	}

}
