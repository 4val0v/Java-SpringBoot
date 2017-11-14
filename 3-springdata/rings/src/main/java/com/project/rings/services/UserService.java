package com.project.rings.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.rings.models.Role;
import com.project.rings.models.User;
import com.project.rings.models.UserRole;
import com.project.rings.repositories.RoleRepo;
import com.project.rings.repositories.UserRepo;
import com.project.rings.repositories.UserRoleRepo;

@Service
public class UserService {
	
	private UserRepo userRepo;
	private RoleRepo roleRepo;
	private UserRoleRepo urRepo;
	private BCryptPasswordEncoder bCrypt;
	
	public UserService(UserRepo userRepo, RoleRepo roleRepo, UserRoleRepo urRepo, BCryptPasswordEncoder bCrypt) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.urRepo = urRepo;
		this.bCrypt = bCrypt;
	}
	
	public void createAdmin(User user) {
		if (roleRepo.findAll().isEmpty()) {
			roleRepo.save(new Role("ROLE_USER"));
			roleRepo.save(new Role("ROLE_ADMIN"));
		}
		user.setPassword(bCrypt.encode(user.getPassword()));
		List<Role> useradmin = new ArrayList<Role>();
		useradmin.add(roleRepo.findByName("ROLE_USER"));
		useradmin.add(roleRepo.findByName("ROLE_ADMIN"));
		user.setRoles(useradmin);
		user.setLevel("Admin");
		user.setGreatAinur(true);
		userRepo.save(user);
	}
	
	public void createUser(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRoles(roleRepo.findAllByName("ROLE_USER"));
		user.setLevel("User");
		userRepo.save(user);
	}
	
	public void makeAdmin(User user) {
		List<Role> useradmin = new ArrayList<Role>();
		useradmin.add(roleRepo.findByName("ROLE_USER"));
		useradmin.add(roleRepo.findByName("ROLE_ADMIN"));
		user.setRoles(useradmin);
		user.setLevel("Admin");
		userRepo.save(user);
	}
	
	public void makeUser(User user) {
		user.setRoles(roleRepo.findAllByName("ROLE_USER"));
		user.setLevel("User");
		userRepo.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User findById(Long id) {
		return userRepo.findById(id);
	}
	
	public void destroyUser(User user) {
		userRepo.delete(user);
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public List<UserRole> listAdmins() {
		return urRepo.findByRole(roleRepo.findAllByName("ROLE_ADMIN"));
	}
	
	public User isGreatAinur(boolean option) {
		return userRepo.findByGreatAinur(option);
	}
	
	public void updateUser(User user, String username) {
		user.setUsername(username);
		userRepo.save(user);
	}
	
}
