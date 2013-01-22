package com.bazzar.domain;


import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.domain.lookup.CreditCardTypeLookup;
import com.bazzar.domain.lookup.EntityTypeLookup;

@Entity
@Table(name="CreditCard")
@Where(clause="status<>0")
public class CreditCard  extends DBBase {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private long id;
	@Column(name="parent_Id")
	private long parentId;
	@ManyToOne
	@JoinColumn(name="Global_Type")
	private EntityTypeLookup globalType;
	@ManyToOne
	@JoinColumn(name="Card_Type")
	private CreditCardTypeLookup cardType;
	@Column(name="Number")
	private String number; 
	@Column(name="Display_Number")
	private String displayNumber; 
	@Column(name="Expiration")
	private String expiration; 
	@Column(name="Security_Code")
	private String securityCode; 
	@Column(name="Cardholder_Name")
	private String cardholderName;
	@Column(name="Nickname")
	private String nickname;
	@Column(name="Status")
	private Boolean isActive;

	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@ManyToMany(cascade = ALL,fetch=FetchType.LAZY)
	@JoinTable(name = "CreditCardAddress", 
		joinColumns = { @JoinColumn(name = "CreditCard_Id") }, 
		inverseJoinColumns = { @JoinColumn(name = "Address_Id") })
	private Set<Address> cardAddress = new HashSet<Address>();
	
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getParentId() {
			return parentId;
		}
		public void setParentId(long parentId) {
			this.parentId = parentId;
		}
		public CreditCardTypeLookup getCardType() {
			return cardType;
		}
		public void setCardType(CreditCardTypeLookup cardType) {
			this.cardType = cardType;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getDisplayNumber() {
			return displayNumber;
		}
		public void setDisplayNumber(String displayNumber) {
			this.displayNumber = displayNumber;
		}
		public String getExpiration() {
			return expiration;
		}
		public void setExpiration(String expiration) {
			this.expiration = expiration;
		}
		public String getSecurityCode() {
			return securityCode;
		}
		public void setSecurityCode(String securityCode) {
			this.securityCode = securityCode;
		}
		public String getCardholderName() {
			return cardholderName;
		}
		public void setCardholderName(String cardholderName) {
			this.cardholderName = cardholderName;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public EntityTypeLookup getGlobalType() {
			return globalType;
		}
		public void setGlobalType(EntityTypeLookup globalType) {
			this.globalType = globalType;
		}
	
		public Set<Address> getCardAddress() {
			return cardAddress;
		}
		public void setCardAddress(Set<Address> cardAddress) {
			this.cardAddress = cardAddress;
		}

}
