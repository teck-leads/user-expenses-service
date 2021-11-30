package com.techleads.app.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.Expenses;
import com.techleads.app.repository.ExpensesRepository;

@Service
public class ExpensesService {
	@Autowired
	private ExpensesRepository expensesRepository;

	/**
	 * Save Expense for the given userId
	 * 
	 * @param expense
	 * @param userId
	 * @return String
	 */

	public String saveExpense(Expenses expense, Integer userId) {

		int count = expensesRepository.saveExpense(expense, userId);
		if (count > 0) {
			return "Expense details are saved successfully!";
		}
		return "Error: Expense details are not saved!";

	}

	/**
	 * Find all expenses for the given userId
	 * 
	 * @param userId
	 * @return List<Expenses>
	 */

	public List<Expenses> findExpensesByUserId(Integer userId) {
		List<Expenses> expenses = expensesRepository.findExpensesByUserId(userId);

		expenses = expenses.parallelStream().sorted(Comparator.comparing(Expenses::getDateOfExpense).reversed())
				.collect(Collectors.toList());

		return expenses;

	}

	/**
	 * Filtering expenses by Month for the given userId
	 * 
	 * @param userId
	 * @param monthValue
	 * @return List<Expenses>
	 */
	public List<Expenses> findExpensesByUserIdByMonth(Integer userId, int monthValue) {
		List<Expenses> expenses = expensesRepository.findExpensesByUserId(userId);

		expenses = expenses.parallelStream().filter(exp -> exp.getDateOfExpense().getMonth().getValue() == monthValue)
				.collect(Collectors.toList());
		return expenses;

	}

	/**
	 * Filtering expenses by Year for the given userId
	 * 
	 * @param userId
	 * @param year
	 * @return List<Expenses>
	 */

	public List<Expenses> findExpensesByUserIdByYear(Integer userId, int year) {
		List<Expenses> expenses = expensesRepository.findExpensesByUserId(userId);

		expenses = expenses.parallelStream().filter(exp -> exp.getDateOfExpense().getYear() == year)
				.collect(Collectors.toList());
		return expenses;

	}

}
