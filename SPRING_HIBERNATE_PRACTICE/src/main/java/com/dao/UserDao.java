package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public User checklogin(User user);
	public List<User> getUser();
	public void saveUser(User user);
	public User getUser(int userId);
	public void deleteUser(int userId);
}
