package com.bazzar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

//import org.hibernate.validator.NotEmpty;
//import org.hibernate.validator.Email;

import com.bazzar.domain.lookup.EmailTypeLookup;

@Entity
@Table(name="Email")
@Where(clause="status<>0")
public class Email  extends DBBase {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@ManyToOne
	@JoinColumn(name="type")
	private EmailTypeLookup emailType;
	@Column(name="Email")
	private String email;
	@Column(name="status")
	private Boolean isActuve;

	
		public Boolean getIsActuve() {
		return isActuve;
	}
	public void setIsActuve(Boolean isActuve) {
		this.isActuve = isActuve;
	}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public void setEmailType(EmailTypeLookup emailType) {
			this.emailType = emailType;
		}
		public EmailTypeLookup getEmailType() {
			return emailType;
		}
}
