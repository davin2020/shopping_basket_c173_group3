package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderLine;

public interface OrderLineDao extends JpaRepository<OrderLine, Integer> {
	
	public List<OrderLine> getProductsByOrderId (int oId);

}
