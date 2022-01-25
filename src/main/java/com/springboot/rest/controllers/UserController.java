package com.springboot.rest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.rest.model.User;
import com.springboot.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> list = userService.getUsers();
		if (list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userCreated = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(userCreated);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
		User userUpdated = userService.updateUser(id, user);
		return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
	}

}
