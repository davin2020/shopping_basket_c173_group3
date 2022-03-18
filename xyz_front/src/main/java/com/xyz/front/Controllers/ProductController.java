package com.xyz.front.Controllers;

import java.util.List;

import com.xyz.front.Entity.Product;
import com.xyz.front.Entity.ProductDetails;
import com.xyz.front.Entity.ProductList;
import com.xyz.front.Entity.Type;
import com.xyz.front.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	/*
	@RequestMapping("/")
	public String getIndexPageController() {
		return "index";
	}
	*/
	@RequestMapping("/menu")
	public String getMainPageController() {
		return "index";
	}
	
//	@RequestMapping("/searchProductPage")
//	public String getSearchProductPage() {
//		return "searchProdPage";
//	}
	
	// this search page will contain a dynamic list of Type links to show the relevant products
	@RequestMapping("/searchProductPage")
	public ModelAndView getSearchProductPage() {
		ModelAndView modelAndView = new ModelAndView();
		
		List <Type> mytypes = productService.getAllTypes();
//		for (Type item : mytypes) {
//		    System.out.println(item.toString());
//		}
		//changes to types and test if still works on searchProductPage.html
		modelAndView.addObject("mytypes", mytypes);
		modelAndView.setViewName("searchProductPage");

		return modelAndView;
	}
		
	@RequestMapping("/searchProduct")
	public ModelAndView searchProductController(@RequestParam("prodId") int id) {
		ModelAndView modelAndView=new ModelAndView();
		Product product=productService.getProductById(id);
		modelAndView.addObject("product", product);
		
		//ProductDetails contains Type Info (TaxAmount, TypeId and TypeName) and Product Info
		ProductDetails prodDetails = productService.getProductDetailsById(id);
		modelAndView.addObject("productDetails", prodDetails);
		
		modelAndView.setViewName("showProduct");
		return modelAndView;
	}
	
	// new method to return multiple products that match a given type id
	@RequestMapping("/searchProductType")
	public ModelAndView searchProductTypeController(@RequestParam("typeId") int typeId) {
		ModelAndView modelAndView = new ModelAndView();
		ProductList myProdList  = productService.getProductDetailsByTypeId(typeId);
		//must turn ProductList into List <Product> so that thymeleaf can iterate over it ok, otherwise generates error 
		List <Product> listOfProds = myProdList.getProdList();
//		for (Product item : listOfProds) {
//		    System.out.println(item.toString());
//		}
		
		modelAndView.addObject("products", listOfProds);
		modelAndView.setViewName("showAllProducts");
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
