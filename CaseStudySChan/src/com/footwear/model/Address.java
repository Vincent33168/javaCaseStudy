package com.footwear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="ADDRESS_TYPE" , nullable = false)
	private String type;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="ADDRESS" , nullable = false)
	private String address;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="ZIPCODE" , nullable = false)
	private String zipcode;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="COUNTRY" , nullable = false)
	private String country;
	
	@ManyToOne
	@JoinColumn(name="CUSTCODE_FK")
	private Customer customer;

	public Address() {
		
	}
	public Address(int id, String type, String address, String zipcode, String country, Customer customer) {
		super();
		this.id = id;
		this.type = type;
		this.address = address;
		this.zipcode = zipcode;
		this.country = country;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
