package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emailtypelookup")
//@Where(clause="status=true")
public class EmailTypeLookup  extends AbstractLookupType{

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final EmailTypeLookup P = createConstant("P", "Personal", EmailTypeLookup.class);
	public static final EmailTypeLookup O = createConstant("O", "Other", EmailTypeLookup.class);
	public static final EmailTypeLookup N = createConstant("N", "None", EmailTypeLookup.class);
	public static final EmailTypeLookup W = createConstant("W", "Work", EmailTypeLookup.class);

	
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
