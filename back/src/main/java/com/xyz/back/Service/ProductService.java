package com.xyz.back.Service;

import com.xyz.back.Entity.Product;
import com.xyz.back.Entity.Type;

import java.util.List;



public interface ProductService {
	
	Product getProductById(int id);
	List<Product> getAllProducts();
	Product insertProduct(Product product);
	Product deleteProduct(int id);
	
	List <Product> getProductByTypeId(int typeId);
	
	Type getTypeById(int typeId);
	List<Type> getAllTypes();

}
