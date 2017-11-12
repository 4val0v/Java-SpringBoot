package com.project.auth.services;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.auth.models.User;
import com.project.auth.repositories.RoleRepo;
import com.project.auth.repositories.UserRepo;

@Service
public class UserService {
	
	private UserRepo userRepo;
	private RoleRepo roleRepo;
	private BCryptPasswordEncoder bCrypt;
	
	public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCrypt) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.bCrypt = bCrypt;
	}
	
	public void createUser(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepo.save(user);
	}
	
	public void createAdmin(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		userRepo.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public void recordLogin(User user) {
		user.setLastLogin(new Date());
		userRepo.save(user);
	}
	
}
