package com.footwear.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_DETAIL")
public class ItemDetail {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_DETAIL_ID")
	private int id;
	private String color;
	private String size;
	private String sku;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID_FK")
	private Item item;
	
	
	public ItemDetail() {
		
	}


	public ItemDetail(String color, String size, String sku, int quantity, Item item) {
		super();
		this.color = color;
		this.size = size;
		this.sku = sku;
		this.quantity = quantity;
		this.item = item;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
	
}
