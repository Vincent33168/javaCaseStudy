package com.footwear.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.ItemServiceI;
import com.footwear.model.Item;
import com.footwear.repository.ItemRepository;


@Service("itemService")
public class ItemService implements ItemServiceI {

	@Autowired
	ItemRepository itemRepository;
	
	//get all Items
	@Override
	public List<Item> getAllItem() {
		List<Item> itemList = new ArrayList<>();
		itemRepository.findAll().forEach(itemList::add);
		return itemList;

	}

	//find products by category and sub-category
	@Override
	public List<Item> findByCategoryAndSubcategory(String category, String subcategory) {
		List<Item> itemList = new ArrayList<>();
		itemRepository.findByCategoryAndSubcategory(category, subcategory).forEach(itemList::add);;
		return itemList;
	}

	//add item
	@Override
	public boolean addItem(Item item) {
		 return itemRepository.save(item) != null;
	}
	
	//find item by item id
	@Override
	public Item getItem(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	
}

