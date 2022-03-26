package com.xyz.back.Persistence;

import java.util.List;

import com.xyz.back.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderDao extends JpaRepository <Order, String> {
	
	public List<Order> getOrderByCustomerId(String cId);

}
