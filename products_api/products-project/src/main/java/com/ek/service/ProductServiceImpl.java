package com.ek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ek.entity.*;
import com.ek.persistence.*;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private TypeDao typeDao;
	
	@Override
	public Product getProductById(int id) {
		return productDao.getById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product insertProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product deleteProduct(int id) {
		Product product = productDao.getById(id);
		productDao.deleteById(id);
		return product;
	}
	
	@Override 
	public List <Product> getProductByTypeId(int typeId) {
		return productDao.getProdByTypeId(typeId);
	}
	
	@Override
	public Type getTypeById(int typeId) {
		return typeDao.getById(typeId);
	}
	
	@Override
	public List<Type> getAllTypes() {
		return typeDao.findAll();
	}
	
}
