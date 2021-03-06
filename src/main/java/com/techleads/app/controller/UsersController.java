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

	@GetMapping(value = { "/users/{userid}" })
	public Users findUserById(@PathVariable("userid") Integer userId) {

		Users user = usersService.findUserById(userId);
		return user;

	}

	@GetMapping(value = { "/users/{userid}/month/{monthValue}" })
	public Users findUserByIdExpensesByMonth(@PathVariable("userid") Integer userId, @PathVariable("monthValue") Integer monthValue) {

		Users user = usersService.findUserByIdExpensesByMonth(userId, monthValue);
		return user;

	}
	
	@GetMapping(value = { "/users/{userid}/year/{year}" })
	public Users findUserByIdExpensesByYear(@PathVariable("userid") Integer userId, @PathVariable("year") Integer year) {

		Users user = usersService.findUserByIdExpensesByYear(userId, year);
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

	@DeleteMapping(value = { "/users/{userId}" })
	public String deleteUserById(@PathVariable("userId") Integer userId) {

		String result = usersService.deleteUserById(userId);
		return result;

	}

}
