package com.footwear.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CREDITCARD_INFO")
public class CreditCardInfo {
	@Id
	private int id;
	@Column (name ="CUSTOMER_CODE", nullable = false)
	private int custcode;
	@Column (name ="CARDHOLDER_NAME", nullable = false)
	private String name;
	@Column (name ="CREDITCARD_NO", nullable = false)
	private String cardno;
	@Column (name ="EXPIRY_DATE", nullable = false)
	private Date expirydate;
	@Column (name ="CVV_CODE", nullable = false)
	private String cardcode;
	@Column (name ="CARD_TYPE", nullable = false)
	private String cardtype;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="CUSTCODE_FK")
	private Customer customer;

	public CreditCardInfo() {
		
	}

	public CreditCardInfo(int custcode, String name, String cardno, Date expirydate, String cardcode, String cardtype,
			Customer customer) {
		super();
		this.custcode = custcode;
		this.name = name;
		this.cardno = cardno;
		this.expirydate = expirydate;
		this.cardcode = cardcode;
		this.cardtype = cardtype;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustcode() {
		return custcode;
	}

	public void setCustcode(int custcode) {
		this.custcode = custcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
