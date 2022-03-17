package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan(basePackages="com.example.entity")
public class OrderHistoryApplication /* implements CommandLineRunner*/{

	/*@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;*/
	
	public static void main(String[] args) {		
		SpringApplication.run(OrderHistoryApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*@Override
	public void run(String... args) throws Exception {
		
		//Customer cus = new Customer("1", "test@test.com", "John", "password");
		
		Order ord1 = new Order(1, "1", 13.48f, 1647349415);
		//Product pr1 = new Product(0,1, 1, "Book", 5.99f, 1, 1);
		//Product pr2 = new Product(0, 2, 1, "CD", 7.49f, 1, 2);
		
		Order ord2 = new Order(2, "1", 8.99f, 1644930199);
		//Product pr3 = new Product(0, 3, 2, "Magazine", 7.49f, 1, 3);
		
		//customerDao.save(cus);
		
		orderDao.save(ord1);
		//productDao.save(pr1);
		//productDao.save(pr2);
		
		orderDao.save(ord2);
		//productDao.save(pr3);
	}*/

}
