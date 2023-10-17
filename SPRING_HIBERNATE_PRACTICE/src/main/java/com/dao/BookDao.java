package com.dao;

import com.entity.Book;

public interface BookDao {
	public void saveBook(Book book);
	public void deleteBook(int id);
	public void deleteBookUser(int id);
}
