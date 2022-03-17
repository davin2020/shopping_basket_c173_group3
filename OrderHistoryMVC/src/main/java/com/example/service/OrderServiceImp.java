package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.example.entity.OrderLines;
import com.example.entity.Orders;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Orders getOrderByCustomerId(String cId) {
		
		return restTemplate.getForObject("http://localhost:8080/orders/" + cId, Orders.class);
	}
	
	@Override
	public OrderLines getProductDetails(int oId) {
		
		return restTemplate.getForObject("http://localhost:8080/orderLines/" + oId, OrderLines.class);
	}

}
