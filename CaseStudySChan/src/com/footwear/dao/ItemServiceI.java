package com.footwear.dao;

import java.util.List;

import com.footwear.model.Item;

public interface ItemServiceI {
	List<Item> getAllItem() ;
	List<Item> findByCategoryAndSubcategory(String category, String subcategory);
	boolean addItem(Item item);
	Item getItem(Integer id);
}
