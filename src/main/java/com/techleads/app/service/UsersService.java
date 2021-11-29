package com.techleads.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.Expenses;
import com.techleads.app.model.Users;
import com.techleads.app.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExpensesService expensesService;

	public Users findUserById(Integer id) {

		Users user = userRepository.findById(id);

		List<Expenses> findExpensesByUserId = expensesService.findExpensesByUserId(id);
		user.setExpenses(findExpensesByUserId);
		
		double totalExpenses = 0;
		for(Expenses expns: findExpensesByUserId) {
			totalExpenses=totalExpenses+expns.getPrice();
		}
		user.setTotalExpenditure(totalExpenses);
		
		
		if (user.getExpenses() == null) {
			Expenses exp = new Expenses();
			List<Expenses> expns = new ArrayList<>();
			expns.add(exp);
			user.setExpenses(expns);

		}
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
