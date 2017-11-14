package com.project.rings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{
	
	List<Role> findAll();
	Role findByName(String name);
	List<Role> findAllByName(String name);
	
}
