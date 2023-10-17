package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.TagDaoImpl;
import com.bookstore.entities.Book;
import com.bookstore.entities.Tag;


public class BookTag {
	public static BookDaoImpl bookDao;
	public static TagDaoImpl tagDao;
	@Before
	public void setUp() {
		bookDao = new BookDaoImpl();
		tagDao = new TagDaoImpl();
	}
	
	@Test
	public void Test() {
		Book book = new Book("LaptrinhOOP", 120000d, LocalDate.of(2010, 12, 3), null);
		Tag tag = new Tag("laptrinhoop");
		book.getTags().add(tag);
		tag.getBooks().add(book);
		assertTrue(bookDao.saveorupdate(book));
	}
}
