package com.techleads.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Users;
import com.techleads.app.service.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;

	@GetMapping(value = { "/users/{id}" })
	public Users findUserById(@PathVariable("id") Integer id) {

		Users user = usersService.findUserById(id);
		return user;

	}

	@GetMapping(value = { "/users" })
	public List<Users> findAllUsers() {

		List<Users> users = usersService.findAllUsers();
		return users;

	}

	@PostMapping(value = { "/users" })
	public String saveUser(@RequestBody Users user) {

		String result = usersService.saveUser(user);
		return result;

	}

	@PutMapping(value = { "/users" })
	public String updateUserById(@RequestBody Users user) {

		String result = usersService.updateUserById(user);
		return result;

	}

	@DeleteMapping(value = { "/users/{id}" })
	public String deleteUserById(@PathVariable("id") Integer id) {

		String result = usersService.deleteUserById(id);
		return result;

	}

}
