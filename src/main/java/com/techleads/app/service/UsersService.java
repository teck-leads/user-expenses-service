package com.techleads.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.Users;
import com.techleads.app.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	public Users findUserById(Integer id) {

		Users user = userRepository.findById(id);
		return user;

	}

	public List<Users> findAllUsers() {

		List<Users> users = userRepository.findAllUsers();
		return users;

	}

	public String saveUser(Users user) {

		int count = userRepository.saveUser(user);
		if (count > 0) {
			return "User details are saved successfully!";
		}
		return "Error: user details are not saved!";

	}
	
	public String updateUserById(Users user) {

		int count = userRepository.updateUserById(user);
		if (count > 0) {
			return "User details are Updated successfully!";
		}
		return "Error: user details are not Updated!";

	}
	
	public String deleteUserById(Integer id) {

		int count = userRepository.deleteUserById(id);
		if (count > 0) {
			return "User details are deleted successfully!";
		}
		return "Error: user details are not deleted!";

	}

}
