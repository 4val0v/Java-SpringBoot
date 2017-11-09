package com.project.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojoOverflow.models.Answer;
import com.project.dojoOverflow.models.Question;
import com.project.dojoOverflow.repositories.AnswerRepo;

@Service
public class AService {
	
	private AnswerRepo aRepo;
	
	public AService(AnswerRepo a) {
		this.aRepo = a;
	}
	
	public List<Answer> all() {
		return aRepo.findAll();
	}
	
	public List<Answer> byQuestion(Question question) {
		return aRepo.findByQuestion(question);
	}
	
	public Answer get(Long id) {
		return aRepo.findOne(id);
	}
	
	public Answer create(Answer answer) {
		return aRepo.save(answer);
	}
	
	public void update(Answer answer) {
		aRepo.save(answer);
	}
	
	public void delete(Answer answer) {
		aRepo.delete(answer);
	}
	
	public boolean exists(Long id) {
		return aRepo.existsById(id);
	}
	
	public long count() {
		return aRepo.count();
	}
	
}
