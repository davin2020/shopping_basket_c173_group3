package com.ek.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ek.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	List <Product> findAll();
	
	@Query("from Product where typeId=:tId")
	public List <Product> getProdByTypeId(@Param("tId") int typeId);

}
