package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.FolderDaoImpl;
import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.entities.Folder;
import com.bookstore.entities.User;

public class UserFolder {
	public static UserDaoImpl userDao;
	public static FolderDaoImpl folderDao;
	@Before
	public void setUp() {
		userDao = new UserDaoImpl();
		folderDao = new FolderDaoImpl();
	}
	
	@Test
	public void Test() {
//		User user1 = new User("user03", "Thinh", "Vu Van", "ThinhVuVan", "4382431223", "thienvuvan2002@gmail.com",
//				"1232236584");
//		Folder cartoon = new Folder("Cartoon","com/bookstore/user03/cartoon/");
//		Folder science = new Folder("Science","com/bookstore/user03/science/");

		
//		user1.getFolders().add(science);
//		science.setUser(user1);
//		//user1.getFolders().add(science);
//		assertTrue(userDao.saveorupdate(user1));
		User user = userDao.getById("user02");
		Folder folder = folderDao.getById(1);
		//user.getFolders().add(folder);
		folder.setUser(user);
		//assertTrue(userDao.saveorupdate(user));
		assertTrue(folderDao.saveorupdate(folder));
	}
}
