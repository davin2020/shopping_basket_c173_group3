package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Order;
import com.example.entity.OrderLine;
import com.example.persistence.OrderDao;
import com.example.persistence.OrderLineDao;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderLineDao orderLineDao;

	@Override
	public List<Order> getOrderByCustomerId(String cId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByCustomerId(cId);
	}
	
	public List<OrderLine> getProductDetails(int oId) {
		
		return orderLineDao.getProductsByOrderId(oId);
	}

}
