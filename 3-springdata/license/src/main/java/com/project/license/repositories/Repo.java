package com.project.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.license.models.Person;

public interface Repo extends CrudRepository<Person, Long>{
	List<Person> findAll();
}
