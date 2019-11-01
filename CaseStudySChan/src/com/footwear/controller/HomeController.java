package com.footwear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = {"/", "/home"},	method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@RequestMapping(value ="/login",	method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
