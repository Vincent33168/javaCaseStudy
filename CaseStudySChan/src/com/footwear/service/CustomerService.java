package com.footwear.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.CustomerServiceI;
import com.footwear.model.Customer;
import com.footwear.repository.CustomerRepository;

@Service("customerService")
public class CustomerService implements CustomerServiceI{

	@Autowired
	CustomerRepository customerRepository;

	//Get all customer from DB
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}


	//Add a new customer or update existing one
	@Override
	public boolean addCustomer(Customer customer) {
		 return customerRepository.save(customer) != null;
	
	}
	
	//Find customer by customer code
	@Override
	public Customer getCustomer(Integer custcode) {
		return customerRepository.findById(custcode).get();
	}
	
	
	//Find customer by customer name
	@Override
	public Customer getCustomerByName(String custname) {
		return customerRepository.findByCustname(custname);
	}
	
	//Delete customer
	@Override
	public void deleteCustomer(Customer customer) {
		 customerRepository.delete(customer);
	
	}

}

