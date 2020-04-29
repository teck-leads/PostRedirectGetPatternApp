package com.techleads.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techleads.app.model.Users;
import com.techleads.app.repository.UserRepository;

@Repository
public class UsersService {
	@Autowired
	private UserRepository userRepository;

	public Users saveUser(Users user) throws Exception {
		try {
			Users savedUser = userRepository.save(user);
			savedUser = userRepository.findById(savedUser.getId()).get();
			return savedUser;
		} catch (Exception e) {
			throw e;
		}
	}

}
