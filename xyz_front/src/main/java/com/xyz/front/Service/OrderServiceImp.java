package com.xyz.front.Service;

import com.xyz.front.Entity.OrderLines;
import com.xyz.front.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;



@Service
public class OrderServiceImp implements OrderService {
	//get the value of the relevant backend api from the app.properties file
	@Value("${app.backend.urlport}") 
	private String BACKEND_URL_PORT;
	//private static final String BACKEND_URL_PORT = "http://localhost:8083";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Orders getOrderByCustomerId(String cId) {
		
		return restTemplate.getForObject(BACKEND_URL_PORT + "/orders/" + cId, Orders.class);
	}
	
	@Override
	public OrderLines getProductDetails(int oId) {
		
		return restTemplate.getForObject(BACKEND_URL_PORT + "/orderLines/" + oId, OrderLines.class);
	}

}
