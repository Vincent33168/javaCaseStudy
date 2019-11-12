package com.footwear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.footwear.dao.CustomerServiceI;
import com.footwear.model.Authorities;
import com.footwear.model.Customer;
import com.footwear.model.User;
import com.footwear.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;

	@Autowired
	CustomerServiceI customerService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		// Init First Admin User
		// initAdmin();

		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	// Contact Us
	@RequestMapping(value = { "/contactUs" }, method = RequestMethod.GET)
	public ModelAndView contactUs() {
		ModelAndView mav = new ModelAndView("contactUs");
		return mav;
	}

	// About Us
	@RequestMapping(value = { "/aboutUs" }, method = RequestMethod.GET)
	public ModelAndView aboutUs() {
		ModelAndView mav = new ModelAndView("aboutUs");
		return mav;
	}

	@RequestMapping(value = { "/processContactUsForm" }, method = RequestMethod.POST)
	public ModelAndView processContactUs() {
		ModelAndView mav = new ModelAndView("contactUsMessage");
		return mav;
	}

	// First Admin User Setup for test purpose
	public void initAdmin() {
		User user = userService.getUserByUsername("kun@gamil.com");
		if (user == null) {
			System.out.println("Creating admin...");
			User adminUser = new User();
			adminUser.setFname("kun");
			adminUser.setLname("Kun");
			adminUser.setUsername("kun@gmail.com");
			String encoded = new BCryptPasswordEncoder().encode("123456");
			adminUser.setPassword(encoded);
			adminUser.setEnabled(true);

			Authorities role = new Authorities();
			role.setUser(adminUser);
			role.setAuthority("ROLE_ADMIN");

			adminUser.getAuthorities().add(role);

			// if customer is not exists, create one for test
			Customer customer;
			// customer = customerService.getCustomerByName("Target");
			customer = customerService.getCustomerByName("Target");

			if (customer == null) {
				customer = new Customer();
				customer.setCustname("Target");
				customer.setEmail("max@target.com");
				customer.setPhone("123-456-789");
				customer.setContact("Max");
				customerService.addCustomer(customer);
			}

			adminUser.setCustomer(customer);
			userService.addUser(adminUser);

		}
	}

}
