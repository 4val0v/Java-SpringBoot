package com.project.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.auth.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{
	
	Role findByName(String name);
	List<Role> findAllByName(String name);
	
}
