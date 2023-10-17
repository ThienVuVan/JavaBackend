package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.entities.Book;
import com.bookstore.entities.File;

public class BookFile {
	public static BookDaoImpl bookDao;
	@Before
	public void setUp() {
		bookDao = new BookDaoImpl();
	}
	
	@Test
	public void Test() {
		Book book2 = new Book(1,"Lap Trinh PHP", 120000d, LocalDate.of(2010, 12, 3), null);
		File file = new File(1,"laptrinhphp.pdf", "/laptrinhphp.pdf");
		book2.setFile(file);
		file.setBook(book2);
		assertTrue(bookDao.update(book2));
	}
}
