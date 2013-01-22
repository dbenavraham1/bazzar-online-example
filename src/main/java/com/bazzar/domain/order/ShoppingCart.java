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

import com.bazzar.domain.DBBase;
import com.bazzar.domain.Note;
import com.bazzar.domain.customer.Customer;
import com.bazzar.domain.item.Item;
import com.bazzar.domain.lookup.ShoppingCartTypeLookup;

@Entity
@Table(name = "SHOPPINGCART")
public class ShoppingCart extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="SHOPPINGCART_CREATED")
	private Date shoppingCartCreated;
	@Column(name="SHOPPINGCART_SEND")
	private Date shoppingCartSendToOrder;
	@Column(name="SHOPPINGCART_CANCELED")
	private Date shoppingCartCanceled;
	@Column(name="SHOPPINGCART_SAVED")
	private Date shoppingCartSaved;
	@Column(name="SHOPPINGCART_SUB_TOTAL")
	private double shoppingCartSubTotal;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="SHOPPINGCART_DETAIL",
	     joinColumns = @JoinColumn( name="SHOPPINGCART_ID"),
	     inverseJoinColumns = @JoinColumn( name="DETAIL_ID")
	)private Set <OrderDetail> detail = new HashSet <OrderDetail> ();
	
	@ManyToOne
	@JoinColumn(name="type")
	private ShoppingCartTypeLookup shoppingCartStatus;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="SHOPPINGCART_ITEM",
	     joinColumns = @JoinColumn( name="SHOPPINGCART_ID"),
	     inverseJoinColumns = @JoinColumn( name="ITEM_ID")
	)
	private Set <Item> item = new HashSet <Item> ();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ORDER_CUSTOMER",
	     joinColumns = @JoinColumn( name="ORDER_ID"),
	     inverseJoinColumns = @JoinColumn( name="CUSTOMER_ID")
	)
	private Set <Customer> customer = new HashSet <Customer> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="SHOPPINGCART_NOTE",
	     joinColumns = @JoinColumn( name="SHOPPINGCART_ID"),
	     inverseJoinColumns = @JoinColumn( name="NOTE_ID")
	)
	private Set <Note> note = new HashSet <Note> ();
	
	public Set<OrderDetail> getDetail() {
		return detail;
	}
	public void setDetail(Set<OrderDetail> detail) {
		this.detail = detail;
	}
	
	public double getShoppingCartSubTotal() {
		return shoppingCartSubTotal;
	}
	public void setShoppingCartSubTotal(double shoppingCartSubTotal) {
		this.shoppingCartSubTotal = shoppingCartSubTotal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getShoppingCartCreated() {
		return shoppingCartCreated;
	}
	public void setShoppingCartCreated(Date shoppingCartCreated) {
		this.shoppingCartCreated = shoppingCartCreated;
	}
	public Date getShoppingCartSendToOrder() {
		return shoppingCartSendToOrder;
	}
	public void setShoppingCartSendToOrder(Date shoppingCartSendToOrder) {
		this.shoppingCartSendToOrder = shoppingCartSendToOrder;
	}
	public Date getShoppingCartCanceled() {
		return shoppingCartCanceled;
	}
	public void setShoppingCartCanceled(Date shoppingCartCanceled) {
		this.shoppingCartCanceled = shoppingCartCanceled;
	}
	public Date getShoppingCartSaved() {
		return shoppingCartSaved;
	}
	public void setShoppingCartSaved(Date shoppingCartSaved) {
		this.shoppingCartSaved = shoppingCartSaved;
	}
	public ShoppingCartTypeLookup getShoppingCartStatus() {
		return shoppingCartStatus;
	}
	public void setShoppingCartStatus(ShoppingCartTypeLookup shoppingCartStatus) {
		this.shoppingCartStatus = shoppingCartStatus;
	}
	public Set<Item> getItem() {
		return item;
	}
	public void setItem(Set<Item> item) {
		this.item = item;
	}
	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
	public Set<Note> getNote() {
		return note;
	}
	public void setNote(Set<Note> note) {
		this.note = note;
	}
	
	
}
