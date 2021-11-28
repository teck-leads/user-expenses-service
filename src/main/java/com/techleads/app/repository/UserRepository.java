package com.techleads.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techleads.app.common.DBQueries;
import com.techleads.app.model.Expenses;
import com.techleads.app.model.Users;

@Repository
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Users findById(Integer id) {
		Object[] params = { id };
		Users user = jdbcTemplate.query(DBQueries.SELECT_USER_BY_ID, new ExtractUserById(), params);
		
		return user;

	}

	public List<Users> findAllUsers() {
		Object[] params = {};
		List<Users> users = jdbcTemplate.query(DBQueries.SELECT_ALL_USER, new ExtractAllUser(), params);

		return users;

	}
	
	public int saveUser(Users user) {
		Object[] params = {user.getName(), user.getLocation(), user.getCardType(), user.getCardNumber(), user.getCvvNumber()};
		int count = jdbcTemplate.update(DBQueries.INSERT_INTO_USER, params);
		return count;
	}
	
	
	public int updateUserById(Users user) {
		Object[] params = {user.getLocation(), user.getCardType(), user.getCardNumber(), user.getCvvNumber(), user.getId()};
		int count = jdbcTemplate.update(DBQueries.UPDATE_USER_BY_ID, params);
		return count;
	}
	
	public int deleteUserById(Integer id) {
		Object[] params = { id};
		int count = jdbcTemplate.update(DBQueries.DELETE_USER_BY_ID, params);
		return count;
	}


}
