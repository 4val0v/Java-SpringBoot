package com.project.auth.services;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.auth.models.User;
import com.project.auth.repositories.UserRepo;

@Service
public class UserService {
	
	private UserRepo ur; private BCryptPasswordEncoder bc;
	public UserService(UserRepo ur, BCryptPasswordEncoder bc) {
		this.ur = ur; this.bc = bc;
	}


	// Create

	public void createSuper(User user) {
		user.setPassword(bc.encode(user.getPassword()));
		user.setLevel(3);
		ur.save(user);
	}
	
	public void createUser(User user) {
		user.setPassword(bc.encode(user.getPassword()));
		user.setLevel(1);
		ur.save(user);
	}


	// Update
	public void updateLastLogin(User user) {
		user.setLastLogin(new Date());
		ur.save(user); }
	
	public void delete(User user) { ur.delete(user); }

	public void promote(User user) {
		user.setLevel(2);
		ur.save(user);
	}
	
	public void demote(User user) {
		user.setLevel(1);
		ur.save(user);
	}


	// Basic retrieval
	public List<User> getAll() {return ur.findAll();}
	public List<User> getByLevel(int level) {return ur.findByLevel(level);}
	public List<User> excludeByLevel(int level) {return ur.findByLevelNotIn(level);}
	public User getByUsername(String username) {return ur.findByUsername(username);}
	public User get(Long id) {return ur.findById(id);}
	public long count() {return ur.count();}


	// Custom retrieval
	public User getFirst() {return ur.findFirstByOrderByIdAsc();}
	public List<User> search(String u) {return ur.findByUsernameContaining(u);}
	
	// Retrieval by relationship
	// public User getOne(One one) {return repo.findBy_One_(one);} // 1t1
	// public List<User> getMany(One one) {return repo.findBy_One_(one);} // 1tm
	// public List<User> getJoins(One one) {return jrepo.findBy_One_(one);} // mtm

	// Assigning relationships
	// public void assignOne(User u, One one) {u.setOne(one); repo.save(u);} // 1t1
	// public void assignMany(User u, List<Many> many)
		// {u.setMany(many); repo.save(u);} // 1tm
	// public void assignJoin(User u, One one)
		// { Join join = new Join(u, one); jrepo.save(join); } // mtm

}
