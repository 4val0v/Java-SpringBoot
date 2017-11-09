package com.project.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dojoOverflow.models.QT;
import com.project.dojoOverflow.models.Question;

@Repository
public interface QTRepo extends CrudRepository<QT, Long>{
	List<QT> findAll();
	boolean existsById(Long id);
	List<QT> findByQuestion(Question question);
}
