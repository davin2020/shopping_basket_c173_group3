package com.xyz.back.Persistence;

import java.util.List;

import com.xyz.back.Entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TypeDao extends JpaRepository<Type, Integer> {
	List <Type> findAll();

}
