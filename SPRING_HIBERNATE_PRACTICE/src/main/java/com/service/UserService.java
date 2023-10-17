package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	public User checklogin(User user);
	public List<User> getUser();
	public void saveUser(User user);
	public User getUser(int userId);
	public void deleteUser(int userId);
}