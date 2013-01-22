package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_TYPE")
public class EntityTypeLookup extends AbstractLookupType {

	public static final EntityTypeLookup BUYER = createConstant("B", "BUYER", EntityTypeLookup.class);
	public static final EntityTypeLookup SELLER = createConstant("S", "SELLER",EntityTypeLookup.class);
	public static final EntityTypeLookup CONTACTPERSON = createConstant("CP", "CONTACTPERSON", EntityTypeLookup.class);
		
	 private static final long serialVersionUID = 3212625355790851086L;
	   
	    @Id
	    @Column(name="code")
	    @Override
	    public String getCode() {
	        return super.getCode();
	    }

	    @Column(name="description")
	    @Override
	    public String getDescription() {
	        return super.getDescription();
	    }
}
