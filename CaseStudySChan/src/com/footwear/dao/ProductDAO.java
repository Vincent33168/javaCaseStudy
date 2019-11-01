package com.footwear.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.footwear.model.Item;


public class ProductDAO extends DataSourceDAO {
	
	public static List<Item> getItemsByCategory(String category, String subCategory){
		
		
		//create an empty list
		//List<Item> items = new ArrayList<Item>();
	
		//connect and get data from DB
		//Item item = manager.find(Item.class, 1);
		TypedQuery<Item> sql = manager.createQuery("SELECT i FROM Item i WHERE i.category=:givenCategory and i.subCategory=:givenSubCategory",Item.class);
		sql.setParameter("givenCategory", category);
		sql.setParameter("givenSubCategory", subCategory);

		
		List<Item> items = sql.getResultList();
		//for test
		for (Item item:items) {
			System.out.println(item.getiName());
			System.out.println(item.getUnitPrice());
		} 
	
		
		//return the list
		return items;
	}

}
