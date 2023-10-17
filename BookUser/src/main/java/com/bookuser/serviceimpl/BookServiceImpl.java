package com.bookuser.serviceimpl;

import com.bookuser.dao.BookDao;
import com.bookuser.entity.Book;
import com.bookuser.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void deleteBookUser(int id) {
        bookDao.deleteBookUser(id);
    }

}
