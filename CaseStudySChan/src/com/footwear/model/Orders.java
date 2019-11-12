package com.footwear.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Orders {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private int id;
	@Column (name ="ORDER_DATE")
	private Date odate;
	@Column (name ="CURRENCY")
	private String currency;
	@Column (name ="ORDER_AMOUNT")
	private Double amount;
	@Column (name ="ORDER_STATUS")
	private String status;
	@Column (name ="PAY_DATE")
	private Date paydate;
	@Column (name ="PAY_TYPE")
	private String paycardtype;
	@Column (name ="PAID_AMOUNT")
	private Double paidamount;
	@Column (name ="DELIVERY_DATE")
	private Date deliverydate;
	@Column (name ="SHIP_TO_ADDRESS")
	private int shipToaddressid;
	@Column (name ="SHIPPING_COST")
	private Double shippingcost;
	@Column (name ="TAX")
	private Double tax;
	@Column (name ="ORDER_TOTAL")
	private Double orderTotal;
	
		
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CUSTCODE_FK")
	private Customer customer;
	
	@OneToMany (mappedBy="orders", cascade={CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.LAZY)
	private Set<OrderDetail> odetail = new HashSet<OrderDetail>();
	
	
	public Orders() {
		
	}


	public Orders(Date odate, String currency, Double amount, String status, Date paydate, String paycardtype,
			Double paidamount, Date deliverydate, int shipToaddressid, Double shippingcost, Double tax,
			Double orderTotal, Customer customer, Set<OrderDetail> odetail) {
		super();
		this.odate = odate;
		this.currency = currency;
		this.amount = amount;
		this.status = status;
		this.paydate = paydate;
		this.paycardtype = paycardtype;
		this.paidamount = paidamount;
		this.deliverydate = deliverydate;
		this.shipToaddressid = shipToaddressid;
		this.shippingcost = shippingcost;
		this.tax = tax;
		this.orderTotal = orderTotal;
		this.customer = customer;
		this.odetail = odetail;
	}

	
	public boolean addOrderDetail(OrderDetail od) {
		od.setOrders(this);
		return odetail.add(od);
	}
	
	public boolean removeOrderDetail(OrderDetail od) {
		od.setOrders(null);
		return odetail.remove(od);
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getOdate() {
		return odate;
	}


	public void setOdate(Date odate) {
		this.odate = odate;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getPaydate() {
		return paydate;
	}


	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}


	public String getPaycardtype() {
		return paycardtype;
	}


	public void setPaycardtype(String paycardtype) {
		this.paycardtype = paycardtype;
	}


	public Double getPaidamount() {
		return paidamount;
	}


	public void setPaidamount(Double paidamount) {
		this.paidamount = paidamount;
	}


	public Date getDeliverydate() {
		return deliverydate;
	}


	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}


	public int getShipToaddressid() {
		return shipToaddressid;
	}


	public void setShipToaddressid(int shipToaddressid) {
		this.shipToaddressid = shipToaddressid;
	}


	public Double getShippingcost() {
		return shippingcost;
	}


	public void setShippingcost(Double shippingcost) {
		this.shippingcost = shippingcost;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}


	public Double getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Set<OrderDetail> getOdetail() {
		return odetail;
	}


	public void setOdetail(Set<OrderDetail> odetail) {
		this.odetail = odetail;
	}
	
	
}
