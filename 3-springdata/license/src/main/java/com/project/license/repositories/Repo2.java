package com.project.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.license.models.License;

public interface Repo2 extends CrudRepository<License, Long>{
	List<License> findAll();
}
