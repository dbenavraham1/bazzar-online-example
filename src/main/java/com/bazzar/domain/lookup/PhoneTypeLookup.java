package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonetypelookup")
//@Where(clause="status=1")
public class PhoneTypeLookup  extends AbstractLookupType{

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final PhoneTypeLookup H = createConstant("H", "Home", PhoneTypeLookup.class);
	public static final PhoneTypeLookup M = createConstant("M", "Mobile", PhoneTypeLookup.class);
	public static final PhoneTypeLookup O = createConstant("O", "Other", PhoneTypeLookup.class);
	public static final PhoneTypeLookup N = createConstant("N", "None", PhoneTypeLookup.class);
	public static final PhoneTypeLookup W = createConstant("W", "Work", PhoneTypeLookup.class);

	
 	@Id
    @Column(name="Code")
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
