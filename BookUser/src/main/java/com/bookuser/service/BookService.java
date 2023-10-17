package com.bookuser.service;

import com.bookuser.entity.Book;

public interface BookService {
    public void saveBook(Book book);
    public void deleteBook(int id);
    public void deleteBookUser(int id);
}
