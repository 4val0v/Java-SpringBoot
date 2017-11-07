package com.project.ModelsApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.ModelsApp.models.User;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	
}
