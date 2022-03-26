package com.xyz.front.Service;

import com.xyz.front.Entity.OrderLines;
import com.xyz.front.Entity.Orders;

public interface OrderService {
	
	public Orders getOrderByCustomerId(String cId);
	
	public OrderLines getProductDetails(int oId);
}
