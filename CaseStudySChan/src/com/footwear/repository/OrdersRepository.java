package com.footwear.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.footwear.model.Customer;
import com.footwear.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

	List<Orders> findByStatusAndCustomer(String status, Customer customer);
	
}
