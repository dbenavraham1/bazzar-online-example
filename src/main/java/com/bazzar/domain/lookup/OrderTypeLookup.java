package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_STATUS_TYPE_LOOKUP")
public class OrderTypeLookup extends AbstractLookupType  {

private static final long serialVersionUID = 3212625355790851086L;
	
	public static final OrderTypeLookup CR = createConstant("CR", "CREATED", OrderTypeLookup.class);
	public static final OrderTypeLookup PK = createConstant("PK", "PACKED", OrderTypeLookup.class);
	public static final OrderTypeLookup SH = createConstant("SH", "SHIPPED", OrderTypeLookup.class);
	public static final OrderTypeLookup PR = createConstant("PR", "PROCESSED", OrderTypeLookup.class);
	
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
