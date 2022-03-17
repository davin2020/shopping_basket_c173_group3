package com.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.OrderLines;
import com.example.entity.Orders;
import com.example.service.OrderService;

@RestController
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(path = "/orders/{cId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders getOrdersByCustomerIdResource(@PathVariable("cId") String cId) {
		
		Orders orders = new Orders();
		orders.setOrderList(orderService.getOrderByCustomerId(cId));
		
		return orders;
	}
	
	@GetMapping(path = "/orderLines/{oId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderLines getOrderLinesByOrderIdResource(@PathVariable("oId") int oId) {
		
		OrderLines orderLines = new OrderLines();
		orderLines.setProductList(orderService.getProductDetails(oId));
		
		return orderLines;
	}
}
