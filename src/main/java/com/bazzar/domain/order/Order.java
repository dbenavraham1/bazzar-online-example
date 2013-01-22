package com.bazzar.domain.order;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bazzar.domain.Address;
import com.bazzar.domain.DBBase;
import com.bazzar.domain.Note;
import com.bazzar.domain.customer.Customer;
import com.bazzar.domain.item.Item;
import com.bazzar.domain.lookup.OrderTypeLookup;

//@Entity
//@Table(name = "ORDER")
public class Order extends DBBase implements Serializable{

//	private static final long serialVersionUID = -5527566248002296042L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//	@Column(name="INVOICE_NUMBER")
//	private String invoiceNumber;
//	@Column(name="TRACKING_NUMBER")
//	private String trackingNumber;
//	@Column(name="PURCHASE_DATE")
//	private Date purchaseDate;
//	@Column(name="CANCELED_DATE")
//	private Date canceledDate;
//	@Column(name="REFUNDED_DATE")
//	private Date refundedDate;
//	@Column(name="SHIPPED_DATE")
//	private Date shippedDate;
//	@Column(name="BEFORE_TAX_TOTAL")
//	private double totalBeforeTax;
//	@Column(name="SHIPPING_TOTAL")
//	private double shippingHandling;
//	@Column(name="REFUNDABLE_TOTAL")
//	private double refundableTotal;
//	@Column(name="ORDER_TOTAL")
//	private double orderTotal;
//	@Column(name="ORDER_TAX")
//	private double orderTax;
//	
//	
//	@ManyToOne
//	@JoinColumn(name="type")
//	private OrderTypeLookup orderStatus;
//	
//	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//	     name="ORDER_ITEM",
//	     joinColumns = @JoinColumn( name="ORDER_ID"),
//	     inverseJoinColumns = @JoinColumn( name="ITEM_ID")
//	)
//	private Set <Item> item = new HashSet <Item> ();
//	
//	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//	     name="ORDER_CUSTOMER",
//	     joinColumns = @JoinColumn( name="ORDER_ID"),
//	     inverseJoinColumns = @JoinColumn( name="CUSTOMER_ID")
//	)
//	private Set <Customer> customer = new HashSet <Customer> ();
//	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//	     name="ORDER_SHIPPING",
//	     joinColumns = @JoinColumn( name="ORDER_ID"),
//	     inverseJoinColumns = @JoinColumn( name="SHIPPING_ID")
//	)
//	private Set <Shipping> shipping = new HashSet <Shipping> ();
//	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//	     name="ORDER_ADDRESS",
//	     joinColumns = @JoinColumn( name="ORDER_ID"),
//	     inverseJoinColumns = @JoinColumn( name="ADDRESS_ID")
//	)
//	private Set <Address> address = new HashSet <Address> ();
//	// TODO create payment
//	//@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	//@JoinTable(
//	//     name="ORDER_PAYMENT",
//	//     joinColumns = @JoinColumn( name="ORDER_ID"),
//	//    inverseJoinColumns = @JoinColumn( name="PAYMENT_ID")
//	//)
//	//private Set <Payment> payment = new HashSet <Payment> ();
//	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//	     name="ORDERS_DETAIL",
//	     joinColumns = @JoinColumn( name="ORDER_ID"),
//	     inverseJoinColumns = @JoinColumn( name="DETAIL_ID")
//	)
//	private Set <OrderDetail> detail = new HashSet <OrderDetail> ();
//	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(
//	     name="ORDER_NOTE",
//	     joinColumns = @JoinColumn( name="ORDER_ID"),
//	     inverseJoinColumns = @JoinColumn( name="NOTE_ID")
//	)
//	private Set <Note> note = new HashSet <Note> ();
//	
//	
//	public Date getCanceledDate() {
//		return canceledDate;
//	}
//
//	public void setCanceledDate(Date canceledDate) {
//		this.canceledDate = canceledDate;
//	}
//
//	public Date getRefundedDate() {
//		return refundedDate;
//	}
//
//	public void setRefundedDate(Date refundedDate) {
//		this.refundedDate = refundedDate;
//	}
//
//	public Set<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(Set<Address> address) {
//		this.address = address;
//	}
//
//	public Set<OrderDetail> getDetail() {
//		return detail;
//	}
//
//	public void setDetail(Set<OrderDetail> detail) {
//		this.detail = detail;
//	}
//
//	public Set<Note> getNote() {
//		return note;
//	}
//
//	public void setNote(Set<Note> note) {
//		this.note = note;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getInvoiceNumber() {
//		return invoiceNumber;
//	}
//
//	public void setInvoiceNumber(String invoiceNumber) {
//		this.invoiceNumber = invoiceNumber;
//	}
//
//	public String getTrackingNumber() {
//		return trackingNumber;
//	}
//
//	public void setTrackingNumber(String trackingNumber) {
//		this.trackingNumber = trackingNumber;
//	}
//
//	public Date getPurchaseDate() {
//		return purchaseDate;
//	}
//
//	public void setPurchaseDate(Date purchaseDate) {
//		this.purchaseDate = purchaseDate;
//	}
//
//	public Date getShippedDate() {
//		return shippedDate;
//	}
//
//	public void setShippedDate(Date shippedDate) {
//		this.shippedDate = shippedDate;
//	}
//
//	public double getTotalBeforeTax() {
//		return totalBeforeTax;
//	}
//
//	public void setTotalBeforeTax(double totalBeforeTax) {
//		this.totalBeforeTax = totalBeforeTax;
//	}
//
//	public double getShippingHandling() {
//		return shippingHandling;
//	}
//
//	public void setShippingHandling(double shippingHandling) {
//		this.shippingHandling = shippingHandling;
//	}
//
//	public double getRefundableTotal() {
//		return refundableTotal;
//	}
//
//	public void setRefundableTotal(double refundableTotal) {
//		this.refundableTotal = refundableTotal;
//	}
//
//	public double getOrderTotal() {
//		return orderTotal;
//	}
//
//	public void setOrderTotal(double orderTotal) {
//		this.orderTotal = orderTotal;
//	}
//
//	public double getOrderTax() {
//		return orderTax;
//	}
//
//	public void setOrderTax(double orderTax) {
//		this.orderTax = orderTax;
//	}
//
//	public OrderTypeLookup getOrderStatus() {
//		return orderStatus;
//	}
//
//	public void setOrderStatus(OrderTypeLookup orderStatus) {
//		this.orderStatus = orderStatus;
//	}
//
//	public Set<Item> getItem() {
//		return item;
//	}
//
//	public void setItem(Set<Item> item) {
//		this.item = item;
//	}
//
//	public Set<Customer> getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Set<Customer> customer) {
//		this.customer = customer;
//	}
//
//	public Set<Shipping> getShipping() {
//		return shipping;
//	}
//
//	public void setShipping(Set<Shipping> shipping) {
//		this.shipping = shipping;
//	}
	
}
