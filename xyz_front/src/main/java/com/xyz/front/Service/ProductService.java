package com.xyz.front.Service;

import com.xyz.front.Entity.Product;
import com.xyz.front.Entity.ProductDetails;
import com.xyz.front.Entity.ProductList;
import com.xyz.front.Entity.Type;

import java.util.List;



public interface ProductService {
	
	public Product getProductById(int id);
	public List<Product> getAllProducts();
	public boolean saveProduct(Product product);
	public boolean deleteProductById(int id);
	
	public ProductDetails getProductDetailsById(int id);
	public ProductList getProductDetailsByTypeId(int typeId);
	
	public List <Type> getAllTypes();
}