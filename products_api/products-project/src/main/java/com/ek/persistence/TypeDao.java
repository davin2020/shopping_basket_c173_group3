package com.ek.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ek.entity.Product;
import com.ek.entity.Type;

public interface TypeDao extends JpaRepository<Type, Integer> {
	List <Type> findAll();

}
