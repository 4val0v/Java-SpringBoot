package com.project.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.waterbnb.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	User findByUsername(String username);
	User findByEmail(String email);
	User findById(Long id);
	List<User> findByLevel(int level);
	List<User> findByLevelNotIn(int level);
	User findFirstByOrderByIdAsc();
	List<User> findByUsernameContaining(String username);
}
