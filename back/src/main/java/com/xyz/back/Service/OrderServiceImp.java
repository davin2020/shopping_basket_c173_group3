package com.xyz.back.Service;

import java.util.List;

import com.xyz.back.Entity.Order;
import com.xyz.back.Entity.OrderLine;
import com.xyz.back.Persistence.OrderDao;
import com.xyz.back.Persistence.OrderLineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
