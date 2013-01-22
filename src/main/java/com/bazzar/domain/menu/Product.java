package com.bazzar.domain.menu;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.domain.DBBase;
import com.bazzar.domain.Picture;
import com.bazzar.domain.item.Item;


@Entity
@Table(name = "PRODUCT")
@Where(clause="status=1")
public class Product extends DBBase implements Serializable {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 

	@Column(name="ATTRIBUTE") 
 	private String attribute;
 	@Column(name="DISPLAY_OPTION")
 	private String displayOption;
	@Column(name="Status")
	private boolean isActive;
 	
 	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PRODUCT_PICTURE",
	     joinColumns = @JoinColumn( name="PRODUCT_ID"),
	     inverseJoinColumns = @JoinColumn( name="PICTURE_ID")
	)
	private Set <Picture> picture = new HashSet <Picture> ();

 	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PRODUCT_ITEM",
	     joinColumns = @JoinColumn( name="PRODUCT_ID"),
	     inverseJoinColumns = @JoinColumn( name="ITEM_ID")
	)
	private Set <Item> item = new HashSet <Item> ();
 	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getDisplayOption() {
		return displayOption;
	}

	public void setDisplayOption(String displayOption) {
		this.displayOption = displayOption;
	}

	public Set<Picture> getPicture() {
		return picture;
	}

	
	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	public void setPicture(Set<Picture> picture) {
		this.picture = picture;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
