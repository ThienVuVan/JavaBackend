package com.service;

import com.entity.Book;

public interface BookService {
	public void saveBook(Book book);
	public void deleteBook(int id);
	public void deleteBookUser(int id);
}
