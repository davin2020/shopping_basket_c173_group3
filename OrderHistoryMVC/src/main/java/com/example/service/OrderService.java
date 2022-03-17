package com.example.service;

import com.example.entity.OrderLines;
import com.example.entity.Orders;

public interface OrderService {
	
	public Orders getOrderByCustomerId(String cId);
	
	public OrderLines getProductDetails(int oId);
}
