package com.techleads.app.common;

public interface DBQueries {
	String SELECT_ALL_USER = "SELECT ID, NAME, LOCATION, CARDTYPE, CARDNUMBER, CVVNUMBER FROM USERS";
	String SELECT_USER_BY_ID = "SELECT ID, NAME, LOCATION, CARDTYPE, CARDNUMBER, CVVNUMBER FROM USERS WHERE ID=?";

	String INSERT_INTO_USER = "INSERT INTO USERS (NAME, LOCATION, CARDTYPE, CARDNUMBER, CVVNUMBER) VALUES(?,?,?,?,?)";

	String UPDATE_USER_BY_ID = "UPDATE USERS SET LOCATION=?, CARDTYPE=?, CARDNUMBER=?, CVVNUMBER=? WHERE ID=?";
	String DELETE_USER_BY_ID = "DELETE FROM USERS WHERE ID=?";

}
