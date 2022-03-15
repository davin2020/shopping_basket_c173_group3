package com.ek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.ek")
@EntityScan(basePackages = "com.ek.entity")
@EnableJpaRepositories(basePackages = "com.ek.persistence")
public class ProductsProjectMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsProjectMvcApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	
	

}
