package com.project.rings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.rings.models.Guild;
import com.project.rings.models.UserGuild;

@Repository
public interface UserGuildRepo extends CrudRepository<UserGuild, Long> {

	List<UserGuild> findByGuild(List<Guild> guilds);
	
}
