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

import com.bazzar.domain.DBBase;

@Entity
//@Table(name = "CATEGORY") 
//@Where(clause="status=1")
public class CategoryTest extends DBBase implements Serializable{
	
	private static final long serialVersionUID = 4693155674165499037L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 

	@Column(name="ATTRIBUTE") 
 	private String attribute;
 	@Column(name="DISPLAY_OPTION")
 	private String displayOption;
	@Column(name="Status")
	private boolean isActive;
 	
 	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
 	@JoinTable(
	     name="CATEGORYTEST_SUBCATEGORY",
	     joinColumns = @JoinColumn( name="CATEGORY_ID"),
	     inverseJoinColumns = @JoinColumn( name="SUBCATEGORY_ID")
	)
	private Set<CategoryTest> children = new HashSet <CategoryTest> ();

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<CategoryTest> getChildren() {
		return children;
	}

	public void setChildren(Set<CategoryTest> children) {
		this.children = children;
	}

}
