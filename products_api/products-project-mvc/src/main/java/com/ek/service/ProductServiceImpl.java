package com.ek.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ek.entity.*;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Product getProductById(int id) {
		return restTemplate.getForObject("http://localhost:8085/products/"+id, Product.class);
	}

	@Override
	public List<Product> getAllProducts() {
		return restTemplate.getForObject("http://localhost:8085/products", ProductList.class).getProdList();		
	}

	@Override
	public boolean saveProduct(Product product) {
		Product prod=restTemplate.postForObject("http://localhost:8085/products", product, Product.class);
		if(prod!=null)
			return true;
		return false;
	}

	@Override
	public boolean deleteProductById(int id) {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<Product> entity=new HttpEntity<Product>(header);
		Product product=restTemplate.exchange("http://localhost:8085/products/"+id,HttpMethod.DELETE, entity, Product.class).getBody();
		if(product!=null)
			return true;
		return false;
	}

	


}
