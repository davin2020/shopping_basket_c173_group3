package com.example.service;

import java.util.List;

import com.example.entity.Order;
import com.example.entity.OrderLine;

public interface OrderService {
	
	public List<Order> getOrderByCustomerId(String cId);
	
	public List<OrderLine> getProductDetails(int oId);
}
