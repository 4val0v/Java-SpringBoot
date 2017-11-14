package com.project.rings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Role;
import com.project.rings.models.UserRole;

@Repository
public interface UserRoleRepo extends CrudRepository<UserRole, Long> {

	List<UserRole> findByRole(List<Role> roles);
	
}
