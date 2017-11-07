package com.project.ModelsApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ModelsApp.repositories.UserRepository;

import com.project.ModelsApp.models.User;

@Service
public class UserService {
	// Member variables / repositories initializations go here
	private UserRepository userRepository;

	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public void create(User user){
		userRepository.save(user);
	}

	public void update(User user) {
		userRepository.save(user);
	}

	public ArrayList<User> all(){
		return (ArrayList<User>) userRepository.findAll();
	}

	public User findById(long id){
		return (User) userRepository.findOne(id);
	}

	public void destroy(long id){
		userRepository.delete(id);
	}

}
