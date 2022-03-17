package com.ek.service;

import java.util.List;

import com.ek.entity.*;

public interface ProductService {
	
	Product getProductById(int id);
	List<Product> getAllProducts();
	Product insertProduct(Product product);
	Product deleteProduct(int id);
	
	List <Product> getProductByTypeId(int typeId);
	
	Type getTypeById(int typeId);
	List<Type> getAllTypes();

}
