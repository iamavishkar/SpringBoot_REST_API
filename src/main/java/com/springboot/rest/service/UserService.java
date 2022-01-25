package com.springboot.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springboot.rest.model.User;
import com.springboot.rest.repo.UserRepo;
import java.util.List;

@Component
public class UserService {

	@Autowired
	private UserRepo userRepo;

	// get all users
	public List<User> getUsers() {
		// return list of all users
		return (List<User>) userRepo.findAll();
	}

	// create a user
	public User createUser(User user) {
		// return the current user
		return userRepo.save(user);
	}

	// delete a user
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
	
	//update a user
	public User updateUser(int id, User user) {
		user.setId(id);
		return userRepo.save(user);
	}

}
