package com.xyz.back.Persistence;

import java.util.List;

import javax.transaction.Transactional;

import com.xyz.back.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	List <Product> findAll();
	
	@Query("from Product where typeId=:tId")
	public List <Product> getProdByTypeId(@Param("tId") int typeId);

}
