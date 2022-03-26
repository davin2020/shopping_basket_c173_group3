package com.xyz.back;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Imports needed to add Cust and Oder Line data to tables
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.xyz.back.Entity.Customer;
import com.xyz.back.Entity.Order;
import com.xyz.back.Entity.OrderLine;

import com.xyz.back.Persistence.CustomerDao;
import com.xyz.back.Persistence.OrderDao;
import com.xyz.back.Persistence.OrderLineDao;
*/

@SpringBootApplication
public class BackApplication /* implements CommandLineRunner */ {
	
	/* Annotations needed to add Cust and Oder Line data to tables
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderLineDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	*/

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

    /*
     * Add some customer and order details to respective Tables in DB
	public void run(String... args) throws Exception {
		
		Customer cus = new Customer("1", "dutch@example.com", "Dutch", "password");
		
		Order ord1 = new Order(1, "1", 13.48f, 1647349415);
		OrderLine pr1 = new OrderLine(0,1, 1, "Book", 5.99f, 1, 1);
		OrderLine pr2 = new OrderLine(0, 2, 1, "CD", 7.49f, 1, 2);
		
		Order ord2 = new Order(2, "1", 8.99f, 1644930199);
		OrderLine pr3 = new OrderLine(0, 3, 2, "Magazine", 7.49f, 1, 3);
		
		customerDao.save(cus);
		
		orderDao.save(ord1);
		productDao.save(pr1);
		productDao.save(pr2);
		
		orderDao.save(ord2);
		productDao.save(pr3);
	}
	*/
}
