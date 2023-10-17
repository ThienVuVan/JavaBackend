package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.RoleDaoImpl;
import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.entities.Role;
import com.bookstore.entities.User;

public class UserRole {
	UserDaoImpl userDao;
	RoleDaoImpl roleDao;
	
	@Before
	public void setUp() {
		userDao = new UserDaoImpl();
	}
	@Test
	public void testsave() {
		User user1 = userDao.getById("user03");
		Role admin = new Role("role01", "admin");
		Role employee = new Role("role02", "employee");
		
		user1.setRole(employee);
		employee.getUsers().add(user1);
		assertTrue(userDao.saveorupdate(user1));
//		
//		user1.setRole(employee);
//		employee.getUsers().add(user1);
//		assertTrue(userDao.saveorupdate(user1));
	}
}
