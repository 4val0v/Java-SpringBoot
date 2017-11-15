package com.project.auth2.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.auth2.models.User;
import com.project.auth2.repositories.UserRepo;

@Service
public class UserService extends UserDetailsService {
	
	private UserRepo userRepo;
	private BCryptPasswordEncoder bCrypt;
	
	public UserService(UserRepo userRepo, RoleRepo roleRepo, UserRoleRepo urRepo, BCryptPasswordEncoder bCrypt) {
		this.userRepo = userRepo;
		this.bCrypt = bCrypt;
	}
	
	public void createSuper(User user) {
		if (roleRepo.findAll().isEmpty()) {
			roleRepo.save(new Role("ROLE_USER"));
			roleRepo.save(new Role("ROLE_ADMIN"));
			roleRepo.save(new Role("ROLE_SUPER"));
		}
		user.setPassword(bCrypt.encode(user.getPassword()));
		List<Role> superadmin = new ArrayList<Role>();
		superadmin.add(roleRepo.findByName("ROLE_USER"));
		superadmin.add(roleRepo.findByName("ROLE_ADMIN"));
		superadmin.add(roleRepo.findByName("ROLE_SUPER"));
		user.setRoles(superadmin);
		user.setLevel("Super");
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
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public void recordLogin(User user) {
		user.setLastLogin(new Date());
		userRepo.save(user);
	}
	
	public List<Role> listByName(String name) {
		return roleRepo.findAllByName(name);
	}
	
	public List<UserRole> listAdmins() {
		return urRepo.findByRole(roleRepo.findAllByName("ROLE_ADMIN"));
	}

	public default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user));
	}

	public default List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (user.getPermissionLevel() >= 2) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		if (user.getPermissionLevel() == 3) {
			authorities.add(new SimpleGrantedAuthority("ROLE_SUPERADMIN"));
		}
		for (GrantedAuthority i : authorities) {
			System.out.println(i);
		}
		return authorities;
	}
	
}
