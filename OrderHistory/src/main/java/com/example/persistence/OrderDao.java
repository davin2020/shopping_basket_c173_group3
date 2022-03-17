package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Order;

@Repository
public interface OrderDao extends JpaRepository <Order, String> {
	
	public List<Order> getOrderByCustomerId(String cId);

}
