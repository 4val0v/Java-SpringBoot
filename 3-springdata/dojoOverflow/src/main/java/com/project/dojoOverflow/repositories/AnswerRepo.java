package com.project.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojoOverflow.models.Answer;
import com.project.dojoOverflow.models.Question;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
	boolean existsById(Long id);
	List<Answer> findByQuestion(Question question);
}
