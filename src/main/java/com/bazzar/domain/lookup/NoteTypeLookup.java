package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTE_TYPE_LOOKUP")
public class NoteTypeLookup extends AbstractLookupType  {

private static final long serialVersionUID = 3212625355790851086L;
	
	public static final NoteTypeLookup OR = createConstant("OR", "ORDER NOTE", NoteTypeLookup.class);
	public static final NoteTypeLookup OCL = createConstant("OCL", "ORDER CANCEL NOTE", NoteTypeLookup.class);
	
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
