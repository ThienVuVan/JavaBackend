package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.AuthorDaoImpl;
import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.entities.Author;
import com.bookstore.entities.Book;

public class BookAuthor {
	public static BookDaoImpl bookDao;
	public static AuthorDaoImpl authorDao;
	@Before
	public void setUp() {
		bookDao = new BookDaoImpl();
		authorDao = new AuthorDaoImpl();
	}
	
	@Test
	public void Test() {
//		Book book = new Book("LaptrinhCPP", 120000d, LocalDate.of(2010, 12, 3), null);
//		Author author = new Author("Thien", "Vu Van", "abc@gmail.com", "123456789");
//		Author author = new Author("Thinh", "Vu Van", "bdc@gmail.com", "1239876789");
		Author author = authorDao.getById(3);
		Book book = bookDao.getById(5);
		book.getAuthors().add(author);
		author.getBooks().add(book);
		assertTrue(bookDao.saveorupdate(book));
	}
}
