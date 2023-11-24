package com.example.exp4.service;

import com.example.exp4.mapper.BooksMapper;
import com.example.exp4.models.Book;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksService {
    private final SqlSession sqlSession;
    private final BooksMapper booksMapper;

    public BooksService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.booksMapper = sqlSession.getMapper(BooksMapper.class);
    }

    // Get all books
    public List<Book> list() {
        return booksMapper.getAllBooks();
    }

    // Get book by ID
    public Book getById(int id) {
        return booksMapper.getBookById(id);
    }

    // Insert or update book
    public void save(Book book) {
        if (book.getId() == 0) {
            booksMapper.addBook(book);
        } else {
            booksMapper.updateBook(book);
        }
        sqlSession.commit();
    }

    // Delete book
    public void delete(int id) {
        booksMapper.deleteBook(id);
        sqlSession.commit();
    }

    // Get books by conditions
    public List<Book> getBooksByConditions(Map<String, Object> conditions) {
        return booksMapper.getBooksByConditions(conditions);
    }
}
