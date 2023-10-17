package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.UserDaoImpl;
import com.bookstore.entities.Book;
import com.bookstore.entities.User;

public class UserBook {
	static UserDaoImpl userdao;
	static BookDaoImpl bookdao;


	@Before
	public void setUp() {
		userdao = new UserDaoImpl();
		bookdao = new BookDaoImpl();
	}

	@Test
	public void testSave() {
//		User user1 = new User("user02", "Thien", "Vu Van", "ThienVuVan", "4382841223", "thienvuvan2003@gmail.com",
//				"1232356584");
//		Book book1 = new Book("Lap Trinh CPP", 100000d, LocalDate.of(2010, 12, 3), null);
//		Book book2 = new Book("Lap Trinh PHP", 120000d, LocalDate.of(2010, 12, 3), null);
//
//		user1.getBooks().add(book2);
//		book2.setUser(user1);
//		assertTrue(userdao.saveorupdate(user1));
		User user = userdao.getById("user02");
		Book book = bookdao.getById(5);
		user.getBooks().add(book);
		book.setUser(user);
		assertTrue(userdao.saveorupdate(user));
	}
}
