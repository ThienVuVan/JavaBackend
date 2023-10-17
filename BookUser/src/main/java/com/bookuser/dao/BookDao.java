package com.bookuser.dao;

import com.bookuser.entity.Book;

public interface BookDao {
    public void saveBook(Book book);
    public void deleteBook(int id);
    public void deleteBookUser(int id);
}
