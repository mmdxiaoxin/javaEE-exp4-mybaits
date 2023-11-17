package com.example.exp4.mapper;

import com.example.exp4.models.Book;

import java.util.List;

public interface BooksMapper {

    int addBook(Book book);

    int deleteBook(int id);

    int updateBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

}
