package com.project.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojoOverflow.models.QT;
import com.project.dojoOverflow.models.Question;
import com.project.dojoOverflow.repositories.QTRepo;

@Service
public class QTService {
	
	private QTRepo qtRepo;
	
	public QTService(QTRepo qt) {
		this.qtRepo = qt;
	}
	
	public List<QT> all() {
		return qtRepo.findAll();
	}
	
	public List<QT> byQuestion(Question question) {
		return qtRepo.findByQuestion(question);
	}
	
	public QT get(Long id) {
		return qtRepo.findOne(id);
	}
	
	public void create(QT qt) {
		qtRepo.save(qt);
	}
	
	public void update(QT qt) {
		qtRepo.save(qt);
	}
	
	public void delete(QT qt) {
		qtRepo.delete(qt);
	}
	
	public boolean exists(Long id) {
		return qtRepo.existsById(id);
	}
	
	public long count() {
		return qtRepo.count();
	}
	
}
