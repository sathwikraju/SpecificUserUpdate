package com.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.user.beans.User;

//RowMapper is pre defined interface to convert resultset records to object
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User users = new User();
		users.setUid(rs.getInt("uid"));
		users.setUname(rs.getString("uname"));
		users.setEmail(rs.getString("email"));

		return users;
	}

}