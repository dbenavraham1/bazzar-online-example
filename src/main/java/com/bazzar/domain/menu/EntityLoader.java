package com.bazzar.domain.menu;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
@Named("entityLoader")
public class EntityLoader {

  private static final Logger LOG = LoggerFactory.getLogger(EntityLoader.class);

  @Inject
  private CategoryRepository categories;

  @PostConstruct
  private void load() {

	Category category = categories.save(getCategory());
    LOG.info("  **** Saved Categories: " + category);
  }

	private Category getCategory (){
		Set <Product> products = new HashSet <Product> ();
		products.add( setProduct ("Trash Compactors") );
		products.add( setProduct ("Small Appliances") );
		products.add( setProduct ("Refrigerators & Freezers") );
		products.add( setProduct ("Microwaves & Microwave Ovens") );
		products.add( setProduct ("Ice Makers") );
		products.add( setProduct ("Hoods") );
		products.add( setProduct ("Garbage Disposals") );
		products.add( setProduct ("Dishwashers") );
		products.add( setProduct ("Cooking Products") );
		products.add( setProduct ("Appliance Packages") );
		Set <SubCategory> subCategories = new HashSet <SubCategory> ();
		subCategories.add ( setSubCategory ("Kitchen", products));
		return setCategory ( "Appliances", subCategories);
	}
	
	private Product setProduct ( String attribute ){
		Product product = new Product ();
		product.setAttribute(attribute);
		product.setActive(true);
		product.setCPD( new Date () );
		product.setUPD( new Date () );

		return product;
	}
	
	private SubCategory setSubCategory (String attribute, Set <Product> products){
		SubCategory subCategory = new SubCategory ();
		subCategory.setAttribute(attribute);
		subCategory.setProduct(products);
		subCategory.setActive(true);
		subCategory.setCPD( new Date () );
		subCategory.setUPD( new Date () );
		return subCategory;
	}
	
	private Category setCategory (String attribute, Set <SubCategory> subCategories) {
		Category category = new Category ();
		category.setAttribute(attribute);
		category.setSubCategory(subCategories);
		category.setActive(true);
		category.setCPD( new Date () );
		category.setUPD( new Date () );

		return category;
	}
}
