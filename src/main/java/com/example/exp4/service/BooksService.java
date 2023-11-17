package com.example.exp4.service;

import com.example.exp4.models.Book;
import com.example.exp4.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class BooksService {
    private final SqlSession sqlSession;

    public BooksService() throws IOException {
        this.sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    }

    // Get all books
    public List<Book> list() {
        return sqlSession.selectList("getAllBooks");
    }

    // Get book by ID
    public Book getById(int id)  {
        return sqlSession.selectOne("getBookById", id);
    }

    // Insert or update book
    public void save(Book book)  {
        if (book.getId() == 0) {
            sqlSession.insert("addBook", book);
        } else {
            sqlSession.update("updateBook", book);
        }
    }

    // Delete book
    public void delete(int id) {
        sqlSession.delete("deleteBook", id);
    }
}
