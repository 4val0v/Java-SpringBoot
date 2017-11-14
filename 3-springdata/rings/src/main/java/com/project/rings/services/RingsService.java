package com.project.rings.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.rings.models.Guild;
import com.project.rings.models.Ring;
import com.project.rings.models.User;
import com.project.rings.models.UserGuild;
import com.project.rings.repositories.GuildRepo;
import com.project.rings.repositories.RingRepo;
import com.project.rings.repositories.UserGuildRepo;
import com.project.rings.repositories.UserRepo;

@Service
public class RingsService {

	private RingRepo ringRepo;
	private UserRepo userRepo;
	private GuildRepo guildRepo;
	private UserGuildRepo ugRepo;
	
	public RingsService (RingRepo ringRepo, UserRepo userRepo, GuildRepo guildRepo, UserGuildRepo ugRepo) {
		this.ringRepo = ringRepo;
		this.userRepo = userRepo;
		this.guildRepo = guildRepo;
		this.ugRepo = ugRepo;
	}
	
	public void createRing(Ring ring) {
		ring.setUser(userRepo.findByGreatAinur(true));
		ringRepo.save(ring);
	}
	
	public void createGuild(Guild guild) {
		guildRepo.save(guild);
	}
	
	public void findRing(Ring ring, User user) {
		ring.setUser(user);
		ringRepo.save(ring);
		user.setLastFind(new Date());
		userRepo.save(user);
	}
	
	public List<Ring> listRings(User user) {
		return ringRepo.findByUser(user);
	}
	
	public Ring getRingById(Long id) {
		return ringRepo.findById(id);
	}
	
	public List<Guild> listGuilds() {
		return guildRepo.findAll();
	}
	
	public void assignGuild(User user, Guild guild) {
		UserGuild ug = new UserGuild(user, guild);
		ugRepo.save(ug);
	}
	
	public Guild getGuildById(Long id) {
		return guildRepo.findById(id);
	}
	
}
