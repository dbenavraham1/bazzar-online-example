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

  @RestResource(path = "name", rel = "names")
  public List<CategoryTest> findByName(@Param("name") String name);

  @RestResource(path = "getRoots")
  @Query("select distinct ct from CategoryTest ct left join fetch ct.children where ct.parent is null")
  public List<CategoryTest> findRoots();

}
