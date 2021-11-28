package com.techleads.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.techleads.app.model.Users;

public class ExtractUserByIds implements ResultSetExtractor<Users> {
	private Users user = new Users();

	@Override
	public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			user.setId(rs.getInt("ID"));
			user.setName(rs.getString("NAME"));
			user.setLocation(rs.getString("LOCATION"));
			user.setCardType(rs.getString("cardType"));
			user.setCardNumber(rs.getString("cardNumber"));
			user.setCvvNumber(rs.getString("cvvNumber"));
		}
		return user;
	}

}
