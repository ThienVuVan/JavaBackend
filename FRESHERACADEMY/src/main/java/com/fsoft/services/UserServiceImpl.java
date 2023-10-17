package com.fsoft.services;

import com.fsoft.bean.User;
import com.fsoft.dao.UserDao;
import com.fsoft.dao.UserdaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User checkLogin(User user) {
		return userDao.checkLogin(user);
	}

}
