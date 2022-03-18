package com.xyz.back.Service;

import java.util.List;


import com.xyz.back.Entity.Order;
import com.xyz.back.Entity.OrderLine;

public interface OrderService {
	
	public List<Order> getOrderByCustomerId(String cId);
	
	public List<OrderLine> getProductDetails(int oId);
}
