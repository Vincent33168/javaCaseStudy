package com.footwear.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int custcode;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="CUSTOMER_NAME", nullable = false)
	private String custName;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="CUSTOMER_CONTACT", nullable = false)
	private String contact;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="EMAIL" , nullable = false)
	private String email;
	
	@NotEmpty(message = "required, cannot be empty")
	@Column (name ="PHONE", nullable = false)
	private String phone;
	
	@OneToMany(mappedBy ="customer")
	private Set<Address> address;
	
	@OneToMany (mappedBy="customer")
	private Set<Orders> order;
	
	@OneToMany(mappedBy="customer")
	private Set<User> user;
	
	@OneToMany(mappedBy="customer")
	private Set<CreditCardInfo> cardinfo;
	
	public Customer() {}
	
	public Customer( String custName, String contact, String email, String phone, Set<Address> address,
			Set<Orders> order, Set<User> user, Set<CreditCardInfo> cardinfo) {
		super();
	//	this.custCode = custCode;
		this.custName = custName;
		this.contact = contact;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.order = order;
		this.user = user;
		this.cardinfo = cardinfo;
	}

	public int getCustcode() {
		return custcode;
	}

	public void setCustcode(int custcode) {
		this.custcode = custcode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Orders> getOrder() {
		return order;
	}

	public void setOrder(Set<Orders> order) {
		this.order = order;
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
