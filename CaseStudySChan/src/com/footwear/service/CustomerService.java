package com.footwear.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.footwear.model.Customer;
import com.footwear.repository.CustomerRepository;

@Transactional
@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	//Get all customer from DB
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}


	//Add a new customer or update existing one
	public boolean addCustomer(Customer customer) {
		 return customerRepository.save(customer) != null;
	
	}
	
	//Find customer by customer code
	public Customer getCustomer(Integer custcode) {
		return customerRepository.findById(custcode).get();
	}
	
	//Delete customer
	public void deleteCustomer(Customer customer) {
		 customerRepository.delete(customer);
	
	}
}

