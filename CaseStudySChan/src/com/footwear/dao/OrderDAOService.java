package com.footwear.dao;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.footwear.model.Customer;
import com.footwear.model.OrderDetail;
import com.footwear.model.Orders;

public class OrderDAOService {
	//create emf, em
	public  EntityManagerFactory emf;
	public  EntityManager em;
	
	
	///create service constructor
	public OrderDAOService() {
		emf = Persistence.createEntityManagerFactory("pu2");
		em  = emf.createEntityManager();
		
	}
	
	
	//find order by Id
	public Orders findOrderById(int id) {
		return em.find(Orders.class, id);
		
	}
	
	//remove order by Id.
	public boolean removeOrderById(int id) {
		em.getTransaction().begin();
		Orders order = findOrderById(id);
		em.remove(order);
		em.getTransaction().commit();
		
		if (findOrderById(id)==null) {
			return true;
		}
		return false;
	}
	
	//update order quantity by Id
	//order quantity is stored in order detail table
	public Orders updateOrderQtyById(int id, String sku, int newQty) {
		Orders o = findOrderById(id);
		OrderDetail od;
		
		Iterator<OrderDetail> it = o.getOdetail().iterator();
		while (it.hasNext()) {
			od = it.next();
			if (sku.equals(od.getSku())) {
				od.setOrderQuantity(newQty);
				System.out.println("update qty");
				od.setOrder(o);
			}
		}
		//update total amount in Order table as well
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
		Orders updatedOrder = findOrderById(id);
		return updatedOrder;
	}
	
	public Customer findCustomerById(int id) {
		return (em.find(Customer.class, id));
	}

}
