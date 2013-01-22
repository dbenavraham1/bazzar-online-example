package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHOPPINGCART_STATUS_TYPE_LOOKUP")
public class ShoppingCartTypeLookup extends AbstractLookupType  {

private static final long serialVersionUID = 3212625355790851086L;
	
	public static final ShoppingCartTypeLookup CR = createConstant("CR", "CREATED", ShoppingCartTypeLookup.class);
	public static final ShoppingCartTypeLookup SV = createConstant("SV", "SAVED", ShoppingCartTypeLookup.class);
	public static final ShoppingCartTypeLookup CP = createConstant("CP", "COMPLETED", ShoppingCartTypeLookup.class);
	public static final ShoppingCartTypeLookup SN = createConstant("SN", "SAND TO ORDER", ShoppingCartTypeLookup.class);
	
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
