package com.footwear.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.footwear.model.Customer;
import com.footwear.model.Item;
import com.footwear.model.ItemDetail;

public abstract class DataSourceDAO {

	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu2");
	protected static EntityManager manager = factory.createEntityManager();
	
	public static void initTestData() {
		
		Item item1 = new Item();
		item1.setiName("ANCHOR_02");
		item1.setiDesc("MEN CASUAL");
		item1.setCategory("MEN");
		item1.setSubCategory("CASUAL");
		item1.setPhoto("photo/ANCHOR02.jpg");
		item1.setCurrency("USD");
		item1.setUnitPrice(15.0);

		
		Item item2 = new Item();
		item2.setiName("BAREA_01");
		item2.setiDesc("MEN CASUAL");
		item2.setCategory("MEN");
		item2.setSubCategory("CASUAL");
		item2.setPhoto("photo/BAREA01.jpg");
		item2.setCurrency("USD");
		item2.setUnitPrice(14.0);
		
		Item item3 = new Item();
		item3.setiName("BLACKSTONE_01");
		item3.setiDesc("MEN CASUAL");
		item3.setCategory("MEN");
		item3.setSubCategory("CASUAL");
		item3.setPhoto("photo/BLACKSTONE01.jpg");
		item3.setCurrency("USD");
		item3.setUnitPrice(16.0);
		
		
		Item item4 = new Item();
		item4.setiName("BYNUM_01");
		item4.setiDesc("MEN CASUAL");
		item4.setCategory("MEN");
		item4.setSubCategory("CASUAL");
		item4.setPhoto("photo/BYNUM01.jpg");
		item4.setCurrency("USD");
		item4.setUnitPrice(14.0);
		
		ItemDetail itemdetail11 =  new ItemDetail();
		itemdetail11.setColor("Black");
		itemdetail11.setSize("A");
		itemdetail11.setQuantity(100);
		itemdetail11.setSku("1001");
		itemdetail11.setItem(item1);
		
		ItemDetail itemdetail12 =  new ItemDetail();
		itemdetail12.setColor("Brown");
		itemdetail12.setSize("B");
		itemdetail12.setQuantity(200);
		itemdetail12.setSku("1002");
		itemdetail12.setItem(item1);
		
		ItemDetail itemdetail13 =  new ItemDetail();
		itemdetail13.setColor("Dark Brown");
		itemdetail13.setSize("C");
		itemdetail13.setQuantity(300);
		itemdetail13.setSku("1003");
		itemdetail13.setItem(item1);
		

		ItemDetail itemdetail21 =  new ItemDetail();
		itemdetail21.setColor("Black");
		itemdetail21.setSize("A");
		itemdetail21.setQuantity(100);
		itemdetail21.setSku("2001");
		itemdetail21.setItem(item2);
		
		ItemDetail itemdetail22 =  new ItemDetail();
		itemdetail22.setColor("Brown");
		itemdetail22.setSize("B");
		itemdetail22.setQuantity(200);
		itemdetail22.setSku("2002");
		itemdetail22.setItem(item2);
		
		ItemDetail itemdetail23 =  new ItemDetail();
		itemdetail23.setColor("Dark Brown");
		itemdetail23.setSize("C");
		itemdetail23.setQuantity(300);
		itemdetail23.setSku("2003");
		itemdetail23.setItem(item2);

		ItemDetail itemdetail31 =  new ItemDetail();
		itemdetail31.setColor("Black");
		itemdetail31.setSize("A");
		itemdetail31.setQuantity(100);
		itemdetail31.setSku("3001");
		itemdetail31.setItem(item3);
		
		ItemDetail itemdetail32 =  new ItemDetail();
		itemdetail32.setColor("Brown");
		itemdetail32.setSize("B");
		itemdetail32.setQuantity(200);
		itemdetail32.setSku("3002");
		itemdetail32.setItem(item3);
		
		ItemDetail itemdetail33 =  new ItemDetail();
		itemdetail33.setColor("Dark Brown");
		itemdetail33.setSize("C");
		itemdetail33.setQuantity(300);
		itemdetail33.setSku("3003");
		itemdetail33.setItem(item3);
		
		
		ItemDetail itemdetail41 =  new ItemDetail();
		itemdetail41.setColor("Black");
		itemdetail41.setSize("A");
		itemdetail41.setQuantity(100);
		itemdetail41.setSku("4001");
		itemdetail41.setItem(item4);
		
		ItemDetail itemdetail42 =  new ItemDetail();
		itemdetail42.setColor("Brown");
		itemdetail42.setSize("B");
		itemdetail42.setQuantity(200);
		itemdetail42.setSku("4002");
		itemdetail42.setItem(item4);
		
		ItemDetail itemdetail43 =  new ItemDetail();
		itemdetail43.setColor("Dark Brown");
		itemdetail43.setSize("C");
		itemdetail43.setQuantity(300);
		itemdetail43.setSku("4003");
		itemdetail43.setItem(item4);
		
		
		
		List<ItemDetail> itemDetail1 = new ArrayList<ItemDetail>();
		itemDetail1.add(itemdetail11);
		itemDetail1.add(itemdetail12);
		itemDetail1.add(itemdetail13);
		item1.setItemDetail(itemDetail1);
		

		List<ItemDetail> itemDetail2 = new ArrayList<ItemDetail>();
		itemDetail2.add(itemdetail21);
		itemDetail2.add(itemdetail22);
		itemDetail2.add(itemdetail23);
		item2.setItemDetail(itemDetail2);
		
		
		List<ItemDetail> itemDetail3 = new ArrayList<ItemDetail>();
		itemDetail3.add(itemdetail31);
		itemDetail3.add(itemdetail32);
		itemDetail3.add(itemdetail33);
		item3.setItemDetail(itemDetail3);
		
		List<ItemDetail> itemDetail4 = new ArrayList<ItemDetail>();
		itemDetail4.add(itemdetail41);
		itemDetail4.add(itemdetail42);
		itemDetail4.add(itemdetail43);
		item4.setItemDetail(itemDetail4);
		
		
		manager.getTransaction().begin();
		manager.persist(item1);
		manager.persist(item2);
		manager.persist(item3);
		manager.persist(item4);
		manager.getTransaction().commit();
		
	}
	
	public static void initCustomer() {
		Customer c1 = new Customer();
		c1.setCustName("Macy");
		c1.setEmail("info@macy.com");
		c1.setPhone("212-1234-567");
		c1.setContact("Max");
		
		Customer c2 = new Customer();
		c2.setCustName("Target");
		c2.setEmail("info@target.com");
		c2.setPhone("212-1234-568");
		c2.setContact("Lucy");
		
		manager.getTransaction().begin();
		manager.persist(c1);
		manager.persist(c2);
		manager.getTransaction().commit();
	}
	
	public static void closeDAO() {
		manager.close();
		factory.close();
	}

}
