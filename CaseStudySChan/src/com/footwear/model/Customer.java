package com.footwear.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int custcode;
	
	@Column (name ="CUSTOMER_NAME", nullable = false)
	@NotEmpty(message = "required, cannot be empty")
	private String custname;
	
	@Column (name ="CUSTOMER_CONTACT", nullable = false)
	@NotEmpty(message = "required, cannot be empty")
	private String contact;
	
	@Column (name ="EMAIL" , nullable = false)
	@NotEmpty(message = "required, cannot be empty")
	private String email;
	
	@Column (name ="PHONE", nullable = false)
	@NotEmpty(message = "required, cannot be empty")
	private String phone;
	
	@OneToOne(mappedBy ="customer" , cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany (mappedBy="customer", cascade = CascadeType.ALL)
	private Set<Orders> orders = new HashSet<Orders>();
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
	private Set<User> user;
	
	@OneToMany(mappedBy="customer" , cascade = CascadeType.ALL)
	private Set<CreditCardInfo> cardinfo;
	
	public Customer() {}

	
	
	




	public Customer(int custcode,  String custname,String contact,String email,String phone, Address address, Set<Orders> orders,
			Set<User> user, Set<CreditCardInfo> cardinfo) {
		super();
		this.custcode = custcode;
		this.custname = custname;
		this.contact = contact;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.orders = orders;
		this.user = user;
		this.cardinfo = cardinfo;
	}


	public boolean addOrders(Orders o) {
		o.setCustomer(this);
		return orders.add(o);
	}

	public int getCustcode() {
		return custcode;
	}


	public void setCustcode(int custcode) {
		this.custcode = custcode;
	}



	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Set<CreditCardInfo> getCardinfo() {
		return cardinfo;
	}

	public void setCardinfo(Set<CreditCardInfo> cardinfo) {
		this.cardinfo = cardinfo;
	}
	
	
}
