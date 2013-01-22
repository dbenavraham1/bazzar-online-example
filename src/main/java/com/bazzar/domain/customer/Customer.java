package com.bazzar.domain.customer;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.domain.Address;
import com.bazzar.domain.CreditCard;
import com.bazzar.domain.DBBase;
import com.bazzar.domain.Email;
import com.bazzar.domain.Phone;
import com.bazzar.domain.QA;
import com.bazzar.domain.Review;

@Entity
@Table(name = "CUSTOMER")
@Where(clause="status<>1")
public class Customer  extends DBBase implements Serializable{
// TODO add user
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "TYPE")
	private String type;
	@Column(name = "PREFIX")
	private String prefix;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "SUFFIX")
	private String suffix;
	@Column(name = "DOB")
	private Date dob;
	@Column(name="Status")
	private boolean isActive;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_ADDRESS",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="ADDRESS_ID")
	)
	private Set<Address> address = new HashSet <Address> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_PHONE",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="PHONE_ID")
	)
	private Set<Phone> phone = new HashSet <Phone> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_SUBSCRIPTION",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="SUBSCRIPTION_ID")
	)
	private Set<Subscription> subscription = new HashSet <Subscription> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_CREDITCARD",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="CREDITCARD_ID")
	)
	private Set<CreditCard> creditcard = new HashSet <CreditCard> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_REVIEW",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="REVIEW_ID")
	)
	private Set<Review> review = new HashSet <Review> ();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_QA",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="QA_ID")
	)
	private Set<QA> qa = new HashSet <QA> ();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="PERSON_EMAIL",
	     joinColumns = @JoinColumn( name="PERSON_ID"),
	     inverseJoinColumns = @JoinColumn( name="EMAIL_ID")
	)
	private Set<Email> email = new HashSet <Email> ();
	
	
	public Set<Subscription> getSubscription() {
		return subscription;
	}
	public void setSubscription(Set<Subscription> subscription) {
		this.subscription = subscription;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public Set<Phone> getPhone() {
		return phone;
	}
	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}
	public Set<CreditCard> getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(Set<CreditCard> creditcard) {
		this.creditcard = creditcard;
	}
	public Set<Review> getReview() {
		return review;
	}
	public void setReview(Set<Review> review) {
		this.review = review;
	}
	public Set<QA> getQa() {
		return qa;
	}
	public void setQa(Set<QA> qa) {
		this.qa = qa;
	}
	public Set<Email> getEmail() {
		return email;
	}
	public void setEmail(Set<Email> email) {
		this.email = email;
	}	
	
}
