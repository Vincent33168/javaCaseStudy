package com.footwear.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.OrderDetailServiceI;
import com.footwear.repository.OrderDetailRepository;

@Service("orderDetailService")
public class OrderDetailService implements OrderDetailServiceI{
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	
	//remove order detail from DB
	public void removeOrderDetail(int id) {
		orderDetailRepository.deleteById(id);
	}
	
	
}
