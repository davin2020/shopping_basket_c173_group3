package com.xyz.back.Persistence;

import java.util.List;

import com.xyz.back.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderLineDao extends JpaRepository<OrderLine, Integer> {
	
	public List<OrderLine> getProductsByOrderId(int oId);

}
