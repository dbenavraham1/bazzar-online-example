package com.bazzar.domain.menu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 */
@RestResource(path = "category")
public interface CategoryRepository extends CrudRepository<Category, Long> {

  @RestResource(path = "attribute", rel = "attributes")
  public List<Category> findByAttribute(@Param("attribute") String attribute);

}
