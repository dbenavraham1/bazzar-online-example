package com.bazzar.domain.menu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
import javax.persistence.OrderColumn;

import com.bazzar.domain.DBBase;

@Entity
// @Table(name = "CATEGORY")
// @Where(clause="status=1")
public class CategoryTest extends DBBase implements Serializable {

	private static final long serialVersionUID = 4693155674165499037L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", insertable = false, updatable = false)
	private CategoryTest parent;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
	@JoinColumn(name = "parent_id")
	@OrderColumn
	private List<CategoryTest> children = new LinkedList<CategoryTest>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public CategoryTest getParent() {
		return parent;
	}

	public void setParent(CategoryTest parent) {
		this.parent = parent;
	}

	public List<CategoryTest> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryTest> children) {
		this.children = children;
	}

}
