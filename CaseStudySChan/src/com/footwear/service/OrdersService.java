package com.footwear.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.footwear.model.Orders;
import com.footwear.repository.OrdersRepository;

@Transactional
@Service
public class OrdersService {
	@Autowired
	OrdersRepository ordersRepository;
	
	public boolean addOrders(Orders order) {
		return ordersRepository.save(order) !=null;
	}
	
	//find order by order status and customer code
	public Set<Orders> findByStatus(String status) {
		Set<Orders>orderlist = new HashSet<>();
		
		ordersRepository.findByStatus(status).forEach(orderlist::add); 
		return orderlist;
		
	}
	
}
