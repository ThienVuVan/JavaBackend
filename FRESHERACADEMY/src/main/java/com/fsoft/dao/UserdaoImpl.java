package com.fsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fsoft.bean.User;

@Repository
public class UserdaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User checkLogin(User user) {
		String query = "select * from users where user_name = ? and password = ?";
		List<User> listUser = jdbcTemplate.query(query, new Object[] {user.getUserName(), user.getPassword()}, new UserRowMapper());
		return listUser.get(0);
	}
}
