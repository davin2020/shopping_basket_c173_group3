package com.ek.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ek.entity.*;
import com.ek.service.*;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String getIndexPageController() {
		return "index";
	}
	
	@RequestMapping("/menu")
	public String getMainPageController() {
		return "index";
	}
	
	@RequestMapping("/searchProductPage")
	public String getSearchProductPage() {
		return "searchProdPage";
	}
	
	@RequestMapping("/searchProduct")
	public ModelAndView searchProductController(@RequestParam("prodId") int id) {
		ModelAndView modelAndView=new ModelAndView();
		Product product=productService.getProductById(id);
		modelAndView.addObject("product", product);
		modelAndView.setViewName("showProduct");
		return modelAndView;
	}
	
	@RequestMapping("/insertProductPage")
	public ModelAndView insertProductPageController() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("prod", new Product());
		modelAndView.setViewName("inputProductDetails");
		
		return modelAndView;
	}
	
	@RequestMapping("/saveProduct")
	public ModelAndView insertProductController(@ModelAttribute("prod") Product product) {
		ModelAndView modelAndView=new ModelAndView();
		
		String message=null;
		if(productService.saveProduct(product))
			message="Product Added Succesfully";
		else
			message="Product Addition Failed";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("output");
		
		return modelAndView;
	}
	
	@RequestMapping("/listAllProducts")
	public ModelAndView getAllProductsController() {
		ModelAndView modelAndView=new ModelAndView();
		
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("products", products);  //request scope
		modelAndView.setViewName("showAllProducts");
		
		return modelAndView;
	}
	
	@RequestMapping("/deleteProductPage")
	public String deleteProductPageController() {
		return "deleteProductPage";
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProductController(@RequestParam("prodId") int id) {
		ModelAndView modelAndView=new ModelAndView();
		
		String message=null;
		if(productService.deleteProductById(id))
			message="Product Deleted Successfully";
		else
			message="Product Deletion Failed";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("output");
		
		return modelAndView;
	}

}
