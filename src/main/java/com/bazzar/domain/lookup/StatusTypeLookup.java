package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "StatusType")
public class StatusTypeLookup extends AbstractLookupType {

	public static final StatusTypeLookup A = createConstant("A", "Active", StatusTypeLookup.class);
    public static final StatusTypeLookup I = createConstant("I", "Inactive", StatusTypeLookup.class);
	
	 private static final long serialVersionUID = 3212625355790851086L;
	
	 	@Id
	    @Column(name="Type")
	    @Override
	    public String getCode() {
	        return super.getCode();
	    }

	    @Column(name="Description")
	    @Override
	    public String getDescription() {
	        return super.getDescription();
	    }
}
