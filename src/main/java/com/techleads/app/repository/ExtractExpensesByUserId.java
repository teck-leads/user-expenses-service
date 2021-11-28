package com.techleads.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.techleads.app.model.Expenses;

public class ExtractExpensesByUserId implements ResultSetExtractor<List<Expenses>> {
	private List<Expenses> expenses = new ArrayList<>();

	@Override
	public List<Expenses> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			Expenses expense = new Expenses();
			expense.setId(rs.getInt("EXPNSE_ID"));
			expense.setItemName(rs.getString("ITEMNAME"));
			expense.setCategory(rs.getString("CATEGORY"));
			expense.setPrice(rs.getDouble("PRICE"));

			String stringDate = rs.getString("DATE_OF_EXPENSE");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(stringDate, formatter);
			expense.setDateOfExpense(date);
			expenses.add(expense);

		}
		return expenses;
	}

}
