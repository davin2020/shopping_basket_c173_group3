package com.ek.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ek.entity.Product;

@SpringBootApplication(scanBasePackages = "com.ek")
@EntityScan(basePackages = "com.ek.entity")
@EnableJpaRepositories(basePackages = "com.ek.persistence")
public class ProductsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsProjectApplication.class, args);
	}

	//data that can be added to Product table - need to implemenet cmd line runner first 
//	Product p1 = new Product(101, "Harry Potter 1", 10.90, 10, 111, "harry potter and philosphers stone");
//	Product p9 = new Product(103, "Harry Potter 2 ", 12.90, 15, 111, "harry potter and the chameber of secrets");
//	Product p10 = new Product(104, "Harry Potter 3 ", 14.90, 22, 111, "harry potter and the prisoner of azkaban");
//	Product p2 = new Product(102, "Dragos vollume 1", 20.0, 12, 111, "mother of dragos");
//	Product p3 = new Product(201, "Hogwarts CD", 20.0, 20, 222, "Harrys adventures at Hogwarts");
//	Product p4 = new Product(202, "Dragon Music", 25.0, 25, 222, "Listen to the latest Dragon music hits");
//	Product p7 = new Product(203, "Songs of Fire and Ice", 35.0, 20, 222, "Listen to the latest songs about fire and ice");
//	Product p8 = new Product(204, "Songs of Fire and Ice", 35.0, 20, 222, "Listen to the latest songs about fire and ice");
//	Product p5 = new Product(301, "Lipstick", 12.0, 50, 333, "magical lipstick");
//	Product p6 = new Product(302, "Dragon Eye liner", 27.0, 8, 333, "Dragon inspired eye liner");
//	
//	productDao.save(p1);
//	productDao.save(p2);
//	productDao.save(p3);
//	productDao.save(p4);
//	productDao.save(p5);
//	productDao.save(p6);
//	productDao.save(p7);
//	productDao.save(p8);
//	productDao.save(p9);
//	productDao.save(p10);

	//data that can be added to Type table
//	Type t1 = new Type(111, "Books", 0.0);
//	Type t2 = new Type(222, "CDs", 10.0);
//	Type t3 = new Type(333, "Cosmetics", 12.0);
//	Type t4 = new Type(444, "DVDs", 20.0);
//	productDao.save(t1);
//	productDao.save(t2);
//	productDao.save(t3);
//	productDao.save(t4);

}
