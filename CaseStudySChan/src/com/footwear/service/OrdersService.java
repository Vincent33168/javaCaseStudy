package com.footwear.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.OrdersServiceI;
import com.footwear.model.Customer;
import com.footwear.model.Orders;
import com.footwear.repository.OrdersRepository;

@Service("ordersService")
public class OrdersService implements OrdersServiceI {
	@Autowired
	OrdersRepository ordersRepository;

	// add customer order to DB
	@Override
	public boolean addOrders(Orders order) {

		return ordersRepository.save(order) != null;

	}

	// Delete order
	@Override
	public void deleteOrders(Orders order) {
		ordersRepository.delete(order);

	}

	// find order by order status and customer
	@Override
	public Set<Orders> findByStatusAndCustomer(String status, Customer customer) {
		Set<Orders> orderlist = new HashSet<>();
		ordersRepository.findByStatusAndCustomer(status, customer).forEach(orderlist::add);
		return orderlist;

	}

	//find order by order #
	@Override
	public Orders getOrder(Integer id) {
		return ordersRepository.findById(id).get();
	}

}
