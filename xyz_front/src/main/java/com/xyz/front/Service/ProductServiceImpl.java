package com.xyz.front.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.xyz.front.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {
//	@Value("${server.port}") 
//	private  String localPort;
	//these cannot be static else t  hey wont work!
	
//	@Value("${app.title}")
//	private String appTitle;
	
//	spring.server.localurl
//	@Value("${spring.server.localurl}") 
//	private   String localUrl;
	
	//this is null despite  indiv values not being null
	//private  String BACKEND_URL_PORT = localUrl + ":" + localPort;
//	private static final String BACKEND_URL_PORT = "http://localhost:8083";
	
	//get the value of the relevant backend api from the app.properties file
	@Value("${app.backend.urlport}") 
	private String BACKEND_URL_PORT;
	
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Product getProductById(int id) {
		
		return restTemplate.getForObject(BACKEND_URL_PORT + "/products/" + id, Product.class);
	}

	@Override
	public List<Product> getAllProducts() {
		//THIS WORKS OK
//		System.out.println("__ Applicatoin TITLE = " + appTitle);
//		System.out.println("__ getAllProducts " +  localUrl);
//		System.out.println("__ Applicatoin PORT = " + localPort);
		//System.out.println("__ BACKEND_URL_PORT  = " + BACKEND_URL_PORT);
		System.out.println("__ BACKEND_URL_PORT  = " + BACKEND_URL_PORT);
		return restTemplate.getForObject(BACKEND_URL_PORT + "/products", ProductList.class).getProdList();
	}

	@Override
	public boolean saveProduct(Product product) {
		Product prod = restTemplate.postForObject(BACKEND_URL_PORT + "/products", product, Product.class);
		if (prod != null)
			return true;
		return false;
	}

	@Override
	public boolean deleteProductById(int id) {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Product> entity = new HttpEntity<Product>(header);
		Product product = restTemplate
				.exchange(BACKEND_URL_PORT + "/products/" + id, HttpMethod.DELETE, entity, Product.class)
				.getBody();
		if (product != null)
			return true;
		return false;
	}

	@Override
	public ProductDetails getProductDetailsById(int id) {
		Product prod = restTemplate.getForObject(BACKEND_URL_PORT + "/products/" + id, Product.class);
		int typeId = prod.getTypeId();
		Type type = restTemplate.getForObject(BACKEND_URL_PORT + "/types/" + typeId, Type.class);
		ProductDetails prodDetails = new ProductDetails(prod, type);
		// how to add type info to product? eg in new object ProductDetails or ?
		return prodDetails;
	}

	// this Returns Products by matching Type Id - but should it return Product
	// or ProductDetails?
	@Override
	public ProductList getProductDetailsByTypeId(int typeId) {
		ProductList prodList = restTemplate.getForObject(BACKEND_URL_PORT + "/products/type/" + typeId, ProductList.class);
		return prodList;
	}

	@Override
	public List<Type> getAllTypes() {
		return restTemplate.getForObject(BACKEND_URL_PORT + "/types", TypeList.class).getTypeList();
	}

}
