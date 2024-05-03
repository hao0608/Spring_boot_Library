package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@Component
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book getBookById(Integer bookId){
        return bookDao.getBookById(bookId);
    }

    public Integer createBook(Book bookRequest){
        return bookDao.createBook(bookRequest);
    }

    public void updateBook(Integer bookId, Book bookRequest){
        bookDao.updateBook(bookId, bookRequest);
    }

    public void deleteBookById(Integer bookId) {
        bookDao.deleteBookById(bookId);
    }
}
