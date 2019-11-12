package com.footwear.dao;

import java.util.List;

import com.footwear.model.Customer;

public interface CustomerServiceI {
	
	List<Customer> getAllCustomer();
	boolean addCustomer(Customer customer);
	Customer getCustomer(Integer custcode);
	void deleteCustomer(Customer customer);
	Customer getCustomerByName(String custname);
	
}
