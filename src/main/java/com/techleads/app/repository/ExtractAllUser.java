package com.techleads.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.techleads.app.model.Users;

public class ExtractAllUser implements ResultSetExtractor<List<Users>> {

	private List<Users> users=new ArrayList<>();
	
	@Override
	public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			Users user = new Users();
			user.setId(rs.getInt("ID"));
			user.setName(rs.getString("NAME"));
			user.setLocation(rs.getString("LOCATION"));
			user.setCardType(rs.getString("cardType"));
			user.setCardNumber(rs.getString("cardNumber"));
			user.setCvvNumber(rs.getString("cvvNumber"));
			users.add(user);
		}
		return users;
	}

}
