package com.project.license.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.license.models.Person;
import com.project.license.repositories.Repo;

@Service
public class PService {
	
	private Repo repo;
	
	public PService(Repo repo) {
		this.repo = repo;
	}
	
	public List<Person> getAll() {
		return repo.findAll();
	}
	
	public Person getPerson(Long id) {
		return repo.findOne(id);
	}
	
	@Transactional
	public void addPerson(Person person) {
		repo.save(person);
	}

}
