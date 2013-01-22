package com.bazzar.domain.lookup;


public class RadiusLookupType extends AbstractLookupType {

	private static final long serialVersionUID = 3501517988801896740L;
	
	public static final RadiusLookupType THREE = createConstant("3", "3 miles", RadiusLookupType.class);
    public static final RadiusLookupType FIVE = createConstant("5", "5 miles", RadiusLookupType.class);
    public static final RadiusLookupType TEN = createConstant("10", "10 miles", RadiusLookupType.class);
    public static final RadiusLookupType FIFTEEN = createConstant("15", "15 miles", RadiusLookupType.class);
    public static final RadiusLookupType THIRTY = createConstant("30", "30 miles", RadiusLookupType.class);
    public static final RadiusLookupType FIFTY = createConstant("50", "50 miles", RadiusLookupType.class);
    
    public String getCode() {    
        return super.getCode();
    }
    public String getDescription() {
        return super.getDescription();
    } 
    public RadiusLookupType() {
        super();
    }
    public RadiusLookupType(int id, String value) {
        setId(id);
        setCode(value);
    }
    public RadiusLookupType (int id) {
        setId(id);
        setCode("" + id);
    }
    public String getString(){
        return super.getCode();
    } 
    
}