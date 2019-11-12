package com.footwear.repository;


import org.springframework.data.repository.CrudRepository;

import com.footwear.model.OrderDetail;


public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {

	
}
