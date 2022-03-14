package com.ek.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ek.entity.*;
import com.ek.service.*;

@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/products/{id}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public Product getProductByIdResource(@PathVariable("id") int prodId) {
		return productService.getProductById(prodId);
	}
	
	
	@GetMapping(path = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductList getAllProductResource(){
		ProductList productList=new ProductList();
		productList.setProdList(productService.getAllProducts());
		return productList ;
	}
	
	@PostMapping(path = "/products",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProductResource(@RequestBody Product product) {
		return productService.insertProduct(product);
	}
	
	@DeleteMapping(path = "/products/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Product deleteProductResource(@PathVariable int id) {
		return productService.deleteProduct(id);
	}

}
