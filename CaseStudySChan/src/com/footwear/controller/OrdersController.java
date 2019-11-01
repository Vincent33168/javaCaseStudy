package com.footwear.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.footwear.service.OrdersService;



@Controller
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	ModelAndView mav;
	
	@RequestMapping(value="cartlist")
	public ModelAndView getCartList() {
		//get order from DB
		//ordersService.findByStatus("unConfirm");
		mav = new ModelAndView("viewCart");
		mav.addObject("myCartObj",ordersService.findByStatus("unConfirm"));
		
		//add order list to the view
		return mav;
		
	}
	
	
}
