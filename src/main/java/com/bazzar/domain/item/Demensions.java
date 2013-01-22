package com.bazzar.domain.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.domain.DBBase;

@Entity
@Table(name = "DEMENSIONS")
@Where(clause="status=1")
public class Demensions  extends DBBase {

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "CATEGORY_GROUP")
	private long categoryGroup;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "ATTRIBUTE")
	private String attribute;
	@Column(name = "VALUE")
	private String value;
	@Column(name = "DISPLAY_OPTION")
	private String displayOption;
	@Column(name="Status")
	private boolean isActive;
 	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getCategoryGroup() {
		return categoryGroup;
	}
	public void setCategoryGroup(long categoryGroup) {
		this.categoryGroup = categoryGroup;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDisplayOption() {
		return displayOption;
	}
	public void setDisplayOption(String displayOption) {
		this.displayOption = displayOption;
	}

}
