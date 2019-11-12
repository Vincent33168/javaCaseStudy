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
@Table(name="ORDER_DETAIL")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_DETAIL_ID")
	private int id;
	@Column (name ="ITEM_NAME")
	private String name;
	@Column (name ="DESCRITPION")
	private String desc;
	@Column (name ="COLOR")
	private String color;
	@Column (name ="SIZE")
	private String size;
	@Column (name ="SKU")
	private String sku;
	@Column (name ="QUANTITY")
	private int quantity;
	@Column (name ="UNITPRICE")
	private Double unitprice;
	@Column (name ="PHOTO")
	private String photo;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID_FK")
	private Orders orders;
	
	
	public OrderDetail() {
		
	}


	public OrderDetail(String name, String desc, String color, String size, String sku, int quantity, Double unitprice,
			String photo, Orders orders) {
		super();
		this.name = name;
		this.desc = desc;
		this.color = color;
		this.size = size;
		this.sku = sku;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.photo = photo;
		this.orders = orders;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
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


	public Double getUnitprice() {
		return unitprice;
	}


	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	
	
	
	
	
	
}
