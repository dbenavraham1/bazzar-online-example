package com.bazzar.domain.menu;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 */
@RestResource(path = "categorytest")
public interface CategoryTestRepository extends CrudRepository<CategoryTest, Long> {

  @RestResource(path = "attribute", rel = "attributes")
  public List<CategoryTest> findByAttribute(@Param("attribute") String attribute);

  @RestResource(path = "getRoots")
  @Query("select ct from CategoryTest ct left join fetch ct.children")
  public List<CategoryTest> findRoots();

}
