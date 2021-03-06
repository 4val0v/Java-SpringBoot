package com.project.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.auth.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	User findByUsername(String username);
	User findByEmail(String email);
	User findById(Long id);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
	List<User> findByLevel(int level);
	List<User> findByLevelNotIn(int level);
	User findFirstByOrderByIdAsc();
	List<User> findByUsernameContaining(String username);
}
