package com.techleads.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Expenses;
import com.techleads.app.service.ExpensesService;

@RestController
public class ExpensesController {
	@Autowired
	private ExpensesService expensesService;

	@PostMapping(value = { "/expenses/user/{userid}" })
	public String saveUser(@RequestBody Expenses expense, @PathVariable("userid") Integer userId) {

		String result = expensesService.saveExpense(expense, userId);
		return result;

	}

	@GetMapping(value = { "/expenses/user/{userid}" })
	public List<Expenses> findExpensesByUserId(@PathVariable("userid") Integer userid) {

		List<Expenses> expensesByUserId = expensesService.findExpensesByUserId(userid);
		return expensesByUserId;

	}

	@GetMapping(value = { "/expenses/user/{userid}/{monthValue}" })
	public List<Expenses> findExpensesByUserIdByMonth(@PathVariable("userid") Integer userId,
			@PathVariable("monthValue") Integer monthValue) {
		List<Expenses> expenses = expensesService.findExpensesByUserIdByMonth(userId, monthValue);

		return expenses;

	}

}
