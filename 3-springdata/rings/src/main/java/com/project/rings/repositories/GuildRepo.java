package com.project.rings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Guild;

@Repository
public interface GuildRepo extends CrudRepository<Guild, Long>{
	List<Guild> findAll();
	Guild findById(Long id);
}
