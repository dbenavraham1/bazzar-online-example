package com.bazzar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

//import org.hibernate.annotations.Where;

import com.bazzar.domain.lookup.PhoneTypeLookup;

@Entity
@Table(name="Phone")
// TODO inactivate records instead of delete
@Where(clause="status<>1")
public class Phone  extends DBBase {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private long id;
	@ManyToOne
    @JoinColumn(name="Type")
	private PhoneTypeLookup phoneType;
	@Column(name="Area_Code")
	private String areaCode;
	@Column(name="Phone")
	private String phone;
	@Column(name="Ext")
	private String ext;
	@Column(name="Status")
	private Boolean isActive;

	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	public PhoneTypeLookup getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(PhoneTypeLookup phoneType) {
		this.phoneType = phoneType;
	}
}
