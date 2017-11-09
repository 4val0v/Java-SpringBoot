package com.project.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dojoOverflow.models.Tag;
import com.project.dojoOverflow.repositories.TagRepo;

@Service
public class TService {
	
	private TagRepo tRepo;
	
	public TService(TagRepo t) {
		this.tRepo = t;
	}
	
	public List<Tag> all() {
		return tRepo.findAll();
	}
	
	public Tag get(Long id) {
		return tRepo.findOne(id);
	}
	
	public Tag create(Tag tag) {
		return tRepo.save(tag);
	}
	
	public void update(Tag tag) {
		tRepo.save(tag);
	}
	
	public void delete(Tag tag) {
		tRepo.delete(tag);
	}
	
	public boolean exists(String subject) {
		return tRepo.existsBySubject(subject);
	}
	
	public Tag findOrCreate(String subject) {
		Tag findtag = tRepo.findBySubject(subject); 
		if(findtag == null) {
			Tag tag = new Tag();
			tag.setSubject(subject);
			return tRepo.save(tag);
		} else {
			return findtag;
		}
	}
	
	public long count() {
		return tRepo.count();
	}
	
}
