package com.bazzar.domain.menu;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
@Named("entityLoader")
public class EntityLoader {

  private static final Logger LOG = LoggerFactory.getLogger(EntityLoader.class);

  @Inject
  private CategoryRepository categories;

  @Inject
  private CategoryTestRepository categoryTests;

  @PostConstruct
  private void load() {
//	Category category = categories.save(getCategory());
//    LOG.info("  **** Saved Categories: " + category);
    
	for (CategoryTest categoryTest: categoryTests.findRoots()) {
		categoryTests.delete(categoryTest);
	}
    LOG.info("  **** Deleted Existing CategoryTests: ");
	
    List<CategoryTest> categories = getCategoryTests("Root");
    for (CategoryTest categoryTest : categories) {
    	categoryTests.save(categoryTest);
    }
    LOG.info("  **** Saved categories: ");
  }

	private List<CategoryTest> getCategoryTests(String name) {
		ObjectMapper mapper = new ObjectMapper();
		 
		  String categories = "[{\"name\":\"Appliances\",\"children\":[{\"name\":\"Kitchen\",\"children\":[{\"name\":\"Appliance Packages\"},{\"name\":\"Cooking Products\"},{\"name\":\"Dishwashers\"},{\"name\":\"Garbage Disposals\"}]},{\"name\":\"Laundry\",\"children\":[{\"name\":\"Laundry Packages\"},{\"name\":\"Washers\"},{\"name\":\"Dryers\"},{\"name\":\"Stack Washers and Dryers\"}]},{\"name\":\"Home Comfort\",\"children\":[{\"name\":\"Air Conditioners\"},{\"name\":\"Air Purifiers\"},{\"name\":\"Dehumidifiers\"},{\"name\":\"Fans And Space Heaters\"}]},{\"name\":\"Accessories\",\"children\":[{\"name\":\"Appliance Accessories\"}]}]},{\"name\":\"TV & Video\",\"children\":[{\"name\":\"Televisions\",\"children\":[{\"name\":\"LED TV\"},{\"name\":\"LCD TV\"},{\"name\":\"Plasma TV\"},{\"name\":\"Projectors\"}]},{\"name\":\"Video Players\",\"children\":[{\"name\":\"Blu-ray & DVD Players\"},{\"name\":\"Digital Media Devices\"},{\"name\":\"DVD/VCR Combos\"},{\"name\":\"DVD Recorders\"}]},{\"name\":\"DVR / Tivo\",\"children\":[{\"name\":\"Digital Video (DVR) Recorders\"}]},{\"name\":\"Satellite / HDTV Receivers\",\"children\":[{\"name\":\"Satellite Receivers\"},{\"name\":\"Digital Converters\"}]}]},{\"name\":\"Communications\",\"children\":[{\"name\":\"Phones\",\"children\":[{\"name\":\"Phones\"},{\"name\":\"Cellular Phones\"}]},{\"name\":\"Accessories\",\"children\":[{\"name\":\"Communication Accessories\"},{\"name\":\"Cellular Accessories\"},{\"name\":\"Cordless Phone Accessories\"},{\"name\":\"Fax Accessories\"},{\"name\":\"Batteries\"}]},{\"name\":\"Buying Guides\",\"children\":[{\"name\":\"Bluetooth\"},{\"name\":\"Cell Phones\"},{\"name\":\"Telephones (Land lines)\"}]},{\"name\":\"Trade In Your Gear\",\"children\":[{\"name\":\"Trade-In Program\"}]}]}]";

		  try {
	 
			// read from file, convert it to user class
			return mapper.readValue(categories, new TypeReference<List<CategoryTest>>(){});
	 
		} catch (JsonGenerationException e) {
	 
			e.printStackTrace();
	 
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
	 
		} catch (IOException e) {
	 
			e.printStackTrace();
	 
		}
		return null;
	}

//	private Category getCategory (){
//		Set <Product> products = new HashSet <Product> ();
//		products.add( setProduct ("Trash Compactors") );
//		products.add( setProduct ("Small Appliances") );
//		products.add( setProduct ("Refrigerators & Freezers") );
//		products.add( setProduct ("Microwaves & Microwave Ovens") );
//		products.add( setProduct ("Ice Makers") );
//		products.add( setProduct ("Hoods") );
//		products.add( setProduct ("Garbage Disposals") );
//		products.add( setProduct ("Dishwashers") );
//		products.add( setProduct ("Cooking Products") );
//		products.add( setProduct ("Appliance Packages") );
//		Set <SubCategory> subCategories = new HashSet <SubCategory> ();
//		subCategories.add ( setSubCategory ("Kitchen", products));
//		return setCategory ( "Appliances", subCategories);
//	}
//	
//	private Product setProduct ( String attribute ){
//		Product product = new Product ();
//		product.setAttribute(attribute);
//		product.setActive(true);
//		product.setCPD( new Date () );
//		product.setUPD( new Date () );
//
//		return product;
//	}
//	
//	private SubCategory setSubCategory (String attribute, Set <Product> products){
//		SubCategory subCategory = new SubCategory ();
//		subCategory.setAttribute(attribute);
//		subCategory.setProduct(products);
//		subCategory.setActive(true);
//		subCategory.setCPD( new Date () );
//		subCategory.setUPD( new Date () );
//		return subCategory;
//	}
//	
//	private Category setCategory (String attribute, Set <SubCategory> subCategories) {
//		Category category = new Category ();
//		category.setAttribute(attribute);
//		category.setSubCategory(subCategories);
//		category.setActive(true);
//		category.setCPD( new Date () );
//		category.setUPD( new Date () );
//
//		return category;
//	}
}
