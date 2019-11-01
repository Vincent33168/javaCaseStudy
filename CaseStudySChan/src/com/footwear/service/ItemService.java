package com.footwear.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.footwear.model.Item;
import com.footwear.repository.ItemRepository;


@Transactional
@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getAllItem() {
		List<Item> itemList = new ArrayList<>();
		itemRepository.findAll().forEach(itemList::add);
		return itemList;

	}

	public List<Item> findByCategoryAndSubcategory(String category, String subcategory) {
		List<Item> itemList = new ArrayList<>();
		itemRepository.findByCategoryAndSubcategory(category, subcategory).forEach(itemList::add);;
		return itemList;
	}

	public boolean addItem(Item item) {
		
		 return itemRepository.save(item) != null;
	
	}
	
	public Item getItem(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	
}

