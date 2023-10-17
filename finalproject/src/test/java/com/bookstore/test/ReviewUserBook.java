package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.ReviewDaoImpl;
import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.entities.Book;
import com.bookstore.entities.Review;
import com.bookstore.entities.User;

public class ReviewUserBook {
	public static UserDaoImpl userDao;
	public static BookDaoImpl bookDao;
	public static ReviewDaoImpl reviewDao;
	

	@Before
	public void setUp() {
		userDao = new UserDaoImpl();
		bookDao = new BookDaoImpl();
		reviewDao = new ReviewDaoImpl();
	}

	@Test
	public void testsave() {
		User user1 = userDao.getById("user03");
		Book book1 = bookDao.getById(5);
		Review reivew = new Review(user1, book1, "sach hay qua", 5);
		assertTrue(reviewDao.saveorupdate(reivew));
	}
}
