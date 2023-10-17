package com.bookstore.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.bookstore.daoimpl.BookDaoImpl;
import com.bookstore.daoimpl.FolderDaoImpl;
import com.bookstore.entities.Book;
import com.bookstore.entities.Folder;

public class BookFolder {
	public static FolderDaoImpl folderDao;
	public static BookDaoImpl bookDao;
	@Before
	public void setUp() {
		folderDao = new FolderDaoImpl();
		bookDao = new BookDaoImpl();
	}
	
	@Test
	public void Test() {
//		Folder science = new Folder(1,"Science","com/bookstore/user03/science/");
//		Book book2 = new Book(1,"Lap Trinh PHP", 120000d, LocalDate.of(2010, 12, 3), null);
		Folder favorite = new Folder("Favorite","com/bookstore/user_id/favorite/");
		Book book = bookDao.getById(1);
//		Folder folder = folderDao.getById(1);
//		book.setFolder(folder);
//		assertTrue(bookDao.saveorupdate(book));
		assertTrue(folderDao.save(favorite));
	}
}
