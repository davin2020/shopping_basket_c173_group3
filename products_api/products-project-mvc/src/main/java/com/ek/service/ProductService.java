package com.ek.service;

import java.util.List;

import com.ek.entity.*;

public interface ProductService {
	
	public Product getProductById(int id);
	public List<Product> getAllProducts();
	public boolean saveProduct(Product product);
	public boolean deleteProductById(int id);

}
