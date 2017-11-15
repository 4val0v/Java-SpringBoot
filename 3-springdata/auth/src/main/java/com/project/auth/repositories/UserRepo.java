package com.project.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.auth.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	User findByUsername(String username);
	User findById(Long id);
	List<User> findByLevel(String level);
}
