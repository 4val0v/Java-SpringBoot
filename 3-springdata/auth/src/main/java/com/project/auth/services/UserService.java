package com.project.auth.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.auth.models.Role;
import com.project.auth.models.User;
import com.project.auth.repositories.RoleRepo;
import com.project.auth.repositories.UserRepo;

@Service
public class UserService {
	
	private UserRepo ur; private RoleRepo rr; private BCryptPasswordEncoder bc;
	public UserService(UserRepo ur, RoleRepo rr, BCryptPasswordEncoder bc) {
		this.ur = ur; this.rr = rr; this.bc = bc;
	}


	// Create

	public void createSuper(User user) {
		if (rr.findAll().isEmpty()) {
			rr.save(new Role("ROLE_USER"));
			rr.save(new Role("ROLE_ADMIN"));
			rr.save(new Role("ROLE_SUPER")); }
		user.setPassword(bc.encode(user.getPassword()));
		List<Role> superadmin = new ArrayList<Role>();
		superadmin.add(rr.findByName("ROLE_USER"));
		superadmin.add(rr.findByName("ROLE_ADMIN"));
		superadmin.add(rr.findByName("ROLE_SUPER"));
		user.setRoles(superadmin);
		user.setLevel("Super");
		ur.save(user);
	}
	
	public void createUser(User user) {
		user.setPassword(bc.encode(user.getPassword()));
		user.setRoles(rr.findAllByName("ROLE_USER"));
		user.setLevel("User");
		ur.save(user);
	}


	// Update
	public void updateLastLogin(User user) {user.setLastLogin(new Date()); ur.save(user); }
	public void delete(User user) { ur.delete(user); }

	public void makeAdmin(User user) {
		List<Role> useradmin = new ArrayList<Role>();
		useradmin.add(rr.findByName("ROLE_USER"));
		useradmin.add(rr.findByName("ROLE_ADMIN"));
		user.setRoles(useradmin);
		user.setLevel("Admin");
		ur.save(user);
	}
	
	public void makeUser(User user) {
		user.setRoles(rr.findAllByName("ROLE_USER"));
		user.setLevel("User");
		ur.save(user);
	}


	// Basic retrieval
	public List<User> getAll() {return ur.findAll();}
	public List<User> getAllByLevel(String level) {return ur.findByLevel(level);}
	public User getByUsername(String username) {return ur.findByUsername(username);}
	public User get(Long id) {return ur.findById(id);}
	public long count() {return ur.count();}
	// public List<Role> listByName(String name) {return rr.findAllByName(name);}
	
}
