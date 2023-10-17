package com.fsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsoft.bean.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet result, int ivalue) throws SQLException {
		User user = new User();
		user.setUserName(result.getString(2));
		user.setPassword(result.getString(4));
		return user;
	}
}
