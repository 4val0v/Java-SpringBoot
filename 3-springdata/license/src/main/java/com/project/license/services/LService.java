package com.project.license.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.license.models.License;
import com.project.license.repositories.Repo2;

@Service
public class LService {
	
	private Repo2 repo;
	
	public LService(Repo2 repo) {
		this.repo = repo;
	}
	
	public List<License> getAll() {
		return repo.findAll();
	}
	
	public License getLicense(Long id) {
		return repo.findOne(id);
	}
	
	@Transactional
	public void addLicense(License license) {
		Long personId = license.getPerson().getId();
		String licNum = String.format("%06d", personId);
		license.setNumber(licNum);
		repo.save(license);
	}

}
