package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.FavoriteDaoImpl;
import com.bookstore.daoimpl.FolderDaoImpl;
import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.entities.Book;
import com.bookstore.entities.Favorite;
import com.bookstore.entities.Folder;
import com.bookstore.entities.User;

public class FavoriteUserBookFolder {
	public static UserDaoImpl userDao;
	public static BookDaoImpl bookDao;
	public static FavoriteDaoImpl favoriteDao;
	public static FolderDaoImpl folderDao;

	@Before
	public void setUp() {
		userDao = new UserDaoImpl();
		bookDao = new BookDaoImpl();
		favoriteDao = new FavoriteDaoImpl();
		folderDao = new FolderDaoImpl();
	}

	@Test
	public void testsave() {
		User user = userDao.getById("user02");
		Book book = bookDao.getById(6);
		Folder folder = folderDao.getByName("Favorite");
		Favorite favortie = new Favorite(user, book, folder);
		assertTrue(favoriteDao.save(favortie));
	}
}
