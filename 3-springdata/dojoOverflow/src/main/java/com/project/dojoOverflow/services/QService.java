package com.project.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojoOverflow.models.Question;
import com.project.dojoOverflow.repositories.QuestionRepo;

@Service
public class QService {
	
	private QuestionRepo qRepo;
	
	public QService(QuestionRepo q) {
		this.qRepo = q;
	}
	
	public List<Question> all() {
		return qRepo.findAll();
	}
	
	public Question get(Long id) {
		return qRepo.findOne(id);
	}
	
	public Question create(Question question) {
		qRepo.save(question);
		return question;
	}
	
	public void update(Question question) {
		qRepo.save(question);
	}
	
	public void delete(Question question) {
		qRepo.delete(question);
	}
	
	public boolean exists(Long id) {
		return qRepo.existsById(id);
	}
	
	public long count() {
		return qRepo.count();
	}
	
}
