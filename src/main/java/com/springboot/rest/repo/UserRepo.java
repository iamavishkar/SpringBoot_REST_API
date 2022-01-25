package com.springboot.rest.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
