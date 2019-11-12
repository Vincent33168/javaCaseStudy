package com.footwear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="ADDRESS" , nullable = false)
	private String address;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="COUNTRY" , nullable = false)
	private String country;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="STATE" , nullable = false)
	private String state;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="ZIPCODE" , nullable = false)
	private String zipcode;
	
	@Column (name ="SHIP_TO_ADDRESS")
	private boolean shipaddress;
	
	@OneToOne
	@JoinColumn(name="CUSTCODE_FK")
	private Customer customer;

	public Address() {
		
	}

	public Address(String address,String country,String state,String zipcode, boolean shipaddress, Customer customer) {
		super();
		this.address = address;
		this.country = country;
		this.state = state;
		this.zipcode = zipcode;
		this.shipaddress = shipaddress;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public boolean isShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(boolean shipaddress) {
		this.shipaddress = shipaddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
