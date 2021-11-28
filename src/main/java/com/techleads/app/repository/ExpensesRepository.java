package com.techleads.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techleads.app.common.DBQueries;
import com.techleads.app.model.Expenses;
import com.techleads.app.model.Users;
@Repository
public class ExpensesRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int saveExpense(Expenses expenses, Integer userId) {
		Object[] params = {expenses.getItemName(), expenses.getCategory(), expenses.getPrice(), expenses.getDateOfExpense(), userId};
		int count = jdbcTemplate.update(DBQueries.INSERT_INTO_EXPENSE, params);
		return count;
	}
	
	public List<Expenses> findExpensesByUserId(Integer userId) {
		Object[] params = { userId };
		List<Expenses> expenses = jdbcTemplate.query(DBQueries.SELECT_EXPNS_BY_USER_ID, new ExtractExpensesByUserId(), params);
		
		return expenses;

	}

}
