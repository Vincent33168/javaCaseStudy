package com.footwear.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footwear.dao.CustomerServiceI;
import com.footwear.model.Customer;


@Controller
public class CustomerController {
	@Autowired
	CustomerServiceI customerService;
	
	ModelAndView mav;
	
	//Show customer list
	@RequestMapping(value="/customer")
	public ModelAndView getCustomerList() {
		//get customer list from DB
		mav = new ModelAndView("customer_list");
		mav.addObject("CUSTOMERLIST",customerService.getAllCustomer());
		return mav;
	}
	
	//Show the customer form for new customer creation
	@RequestMapping(value="/addcustomer",  method = RequestMethod.GET)
	public ModelAndView addCustomer() {
		mav = new ModelAndView("customer_form");
		mav.addObject("customerObj",new Customer());
		mav.addObject("message","Add New Customer");
		return mav;
	}
	
	//Process the Customer Form
	@RequestMapping(value="/processCustomerForm", params="confirm", method=RequestMethod.POST)
	public ModelAndView processCustomerForm( @Valid @ModelAttribute("customerObj") 
	Customer customer, BindingResult br, 
	RedirectAttributes redirect) {
		ModelAndView mav =new ModelAndView("customer_form");

		//if there is any error return to customer form, otherwise save the customer to DB
		if (br.hasErrors()) {
			br.getAllErrors().forEach(System.out::println);
			mav = new ModelAndView("customer_form");
		} else {
			if (customer.getCustcode()== 0) {
				redirect.addFlashAttribute("message","New customer successfully created!");
			}else {
				redirect.addFlashAttribute("message","Customer successfully updated!");
			}
			customerService.addCustomer(customer);
			mav = new ModelAndView("redirect:/customer");
					
		}
		return mav;
	}

	//Process the Customer Form, if cancel edit return to customer list
		@RequestMapping(value="/processCustomerForm", params="cancel", method=RequestMethod.POST)
		public ModelAndView cancelEditCustomer(RedirectAttributes redirect) {
			redirect.addFlashAttribute("message","Cancel Editing!");
			mav = new ModelAndView("redirect:/customer");
			return mav;
		}
				
				
	//Edit Customer
    @RequestMapping(value = "/editcustomer/{custcode}", method = RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable int custcode) {
    	ModelAndView mav = new ModelAndView("customer_form");
        Customer customer = customerService.getCustomer(custcode);
        mav.addObject("customerObj", customer);
        mav.addObject("action","Edit Customer");
        return mav;
    }

  	//Remove Customer from DB
    @RequestMapping(value = "/deletecustomer/{custcode}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable int custcode,
    		RedirectAttributes redirect) {
        customerService.deleteCustomer(customerService.getCustomer(custcode));
        redirect.addFlashAttribute("message", "Customer successfully removed!");
        return new ModelAndView("redirect:/customer");
    }
    
}
