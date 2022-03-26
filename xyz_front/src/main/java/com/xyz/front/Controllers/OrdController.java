package com.xyz.front.Controllers;

import com.xyz.front.Entity.OrderLines;
import com.xyz.front.Entity.Orders;
import com.xyz.front.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class OrdController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/showOrder")
	public ModelAndView showOrders() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Orders orders = orderService.getOrderByCustomerId("1");
		modelAndView.addObject("orders", orders.getOrderList());
		modelAndView.setViewName("showOrders");
		
		return modelAndView;
	}
	
	@RequestMapping("/showOrderDetail")
	public ModelAndView showOrderDetails(@RequestParam("id") int id) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		OrderLines orderLines = orderService.getProductDetails(id);
		modelAndView.addObject("products", orderLines.getProductList());
		modelAndView.setViewName("showOrdersDetails");
		
		return modelAndView;
	}
}
