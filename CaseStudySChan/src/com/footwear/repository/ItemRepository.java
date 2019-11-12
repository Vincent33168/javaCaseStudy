package com.footwear.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.footwear.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
	
	List<Item> findByCategoryAndSubcategory(String categroy, String subcategory);
	
}
