package com.project.ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ninjas.models.Dojo;
import com.project.ninjas.models.Ninja;
import com.project.ninjas.repositories.DojoRepo;
import com.project.ninjas.repositories.NinjaRepo;

@Service
public class CDService {

	private DojoRepo dojoRepo;
	private NinjaRepo ninjaRepo;
	
	public CDService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> getDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo getDojo(Long id) {
		return dojoRepo.findOne(id);
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public List<Ninja> getNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja getNinja(Long id) {
		return ninjaRepo.findOne(id);
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
}
