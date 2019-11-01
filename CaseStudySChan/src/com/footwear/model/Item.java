package com.footwear.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name ="ITEM_ID")
	private int id;
	@Column (name ="ITEM_NAME")
	private String name;
	@Column (name ="DESCRITPION")
	private String desc;
	@Column (name ="CURRENCY")
	private String currency;
	@Column (name ="UNIT_PRICE")
	private Double unitprice;
	@Column (name ="CATEGORY")
	private String category;
	@Column (name ="SUB_CATEGORY")
	private String subcategory;
	@Column (name ="PHOTO")
	private String photo;
	
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ItemDetail> itemdetail = new ArrayList<ItemDetail>();
	
	public Item() {
		
	}
	
	

	public Item(String name, String desc, String currency, Double unitprice, String category, String subcategory,
			String photo, List<ItemDetail> itemdetail) {
		super();
		this.name = name;
		this.desc = desc;
		this.currency = currency;
		this.unitprice = unitprice;
		this.category = category;
		this.subcategory = subcategory;
		this.photo = photo;
		this.itemdetail = itemdetail;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<ItemDetail> getItemdetail() {
		return itemdetail;
	}

	public void setItemdetail(List<ItemDetail> itemdetail) {
		this.itemdetail = itemdetail;
	}
	
	
	
	
}
