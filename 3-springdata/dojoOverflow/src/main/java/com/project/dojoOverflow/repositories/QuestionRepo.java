package com.project.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojoOverflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{
	List<Question> findAll();
	boolean existsById(Long id);
	
}
