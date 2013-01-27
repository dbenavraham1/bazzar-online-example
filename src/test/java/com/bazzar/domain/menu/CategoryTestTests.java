package com.bazzar.domain.menu;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bazzar.domain.JpaRepositoryConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaRepositoryConfig.class)
public class CategoryTestTests {

	private static final Logger LOG = LoggerFactory
			.getLogger(CategoryTestTests.class);

	@Inject
	private CategoryTestRepository categoryTests;

	@Before
	public void afterPropertiesSet() throws Exception {
		for (CategoryTest categoryTest : categoryTests.findRoots()) {
			categoryTests.delete(categoryTest);
		}
		LOG.info("  **** Deleted Existing CategoryTests: ");

		CategoryTest categoryTest = getCategoryTests("Root");
		for (int i = 0; i < 3; i++) {
			categoryTest.getChildren()
					.add(getCategoryTests("child " + (i + 1)));
		}
		categoryTests.save(categoryTest);
		LOG.info("  **** Saved CategoryTests: " + categoryTest);
	}

	private CategoryTest getCategoryTests(String name) {
		CategoryTest categoryTest = new CategoryTest();
		categoryTest.setName(name);
		categoryTest.setActive(true);
		categoryTest.setCPD(new Date());
		categoryTest.setUPD(new Date());
		return categoryTest;
	}

	@Test
	public void shouldProvideResourceMappingForConfiguredRepository()
			throws Exception {
		List<CategoryTest> roots = categoryTests.findRoots();

		assertThat("List should not be null.", roots, notNullValue());
		assertThat("There should be 1 root.", roots.size(), is(1));
		CategoryTest root = roots.get(0);
		assertThat("There should be three children.",
				root.getChildren().size(), is(3));
	}

	@Test
	public void buildCategoriesFromJson() {
		ObjectMapper mapper = new ObjectMapper();
		 
		  String categories = "[{\"name\":\"Appliances\",\"children\":[{\"name\":\"Kitchen\",\"children\":[{\"name\":\"Appliance Packages\"},{\"name\":\"Cooking Products\"},{\"name\":\"Dishwashers\"},{\"name\":\"Garbage Disposals\"}]},{\"name\":\"Laundry\",\"children\":[{\"name\":\"Laundry Packages\"},{\"name\":\"Washers\"},{\"name\":\"Dryers\"},{\"name\":\"Stack Washers and Dryers\"}]},{\"name\":\"Home Comfort\",\"children\":[{\"name\":\"Air Conditioners\"},{\"name\":\"Air Purifiers\"},{\"name\":\"Dehumidifiers\"},{\"name\":\"Fans And Space Heaters\"}]},{\"name\":\"Accessories\",\"children\":[{\"name\":\"Appliance Accessories\"}]}]},{\"name\":\"TV & Video\",\"children\":[{\"name\":\"Televisions\",\"children\":[{\"name\":\"LED TV\"},{\"name\":\"LCD TV\"},{\"name\":\"Plasma TV\"},{\"name\":\"Projectors\"}]},{\"name\":\"Video Players\",\"children\":[{\"name\":\"Blu-ray & DVD Players\"},{\"name\":\"Digital Media Devices\"},{\"name\":\"DVD/VCR Combos\"},{\"name\":\"DVD Recorders\"}]},{\"name\":\"DVR / Tivo\",\"children\":[{\"name\":\"Digital Video (DVR) Recorders\"}]},{\"name\":\"Satellite / HDTV Receivers\",\"children\":[{\"name\":\"Satellite Receivers\"},{\"name\":\"Digital Converters\"}]}]},{\"name\":\"Communications\",\"children\":[{\"name\":\"Phones\",\"children\":[{\"name\":\"Phones\"},{\"name\":\"Cellular Phones\"}]},{\"name\":\"Accessories\",\"children\":[{\"name\":\"Communication Accessories\"},{\"name\":\"Cellular Accessories\"},{\"name\":\"Cordless Phone Accessories\"},{\"name\":\"Fax Accessories\"},{\"name\":\"Batteries\"}]},{\"name\":\"Buying Guides\",\"children\":[{\"name\":\"Bluetooth\"},{\"name\":\"Cell Phones\"},{\"name\":\"Telephones (Land lines)\"}]},{\"name\":\"Trade In Your Gear\",\"children\":[{\"name\":\"Trade-In Program\"}]}]}]";

		  try {
	 
			// read from file, convert it to user class
			List<CategoryTest> categoryTests = mapper.readValue(categories, new TypeReference<List<CategoryTest>>(){});
			// display to console
			for (CategoryTest categoryTest : categoryTests) {
				LOG.info(categoryTest.getName());
				for (CategoryTest childLevel1CategoryTest : categoryTest.getChildren()) {
					LOG.info(childLevel1CategoryTest.getName());
					for (CategoryTest childLevel2CategoryTest : categoryTest.getChildren()) {
						LOG.info(childLevel2CategoryTest.getName());
					}
				}
			}
	 
		} catch (JsonGenerationException e) {
	 
			e.printStackTrace();
	 
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
	 
		} catch (IOException e) {
	 
			e.printStackTrace();
	 
		}
	}
}
