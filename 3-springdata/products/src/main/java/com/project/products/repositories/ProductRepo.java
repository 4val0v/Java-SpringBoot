package com.project.products.repositories;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.products.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{

	@JsonProperty("id")
	List<Product> findAll();

	List<Product> findByNameNotIn(List<String> name);
}
