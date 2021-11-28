package com.techleads.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.techleads.app.model.Users;

public class ExtractUserById implements ResultSetExtractor<Users> {
	private Users user = new Users();

	@Override
	public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
		while (rs.next()) {
			user.setId(rs.getInt("USER_ID"));
			user.setName(rs.getString("NAME"));
			user.setLocation(rs.getString("LOCATION"));
			user.setCardType(rs.getString("CARDTYPE"));
			user.setCardNumber(rs.getString("CARDNUMBER"));
			user.setCvvNumber(rs.getString("CVVNUMBER"));
		}
		return user;
	}

}
