package com.example.exp4;

import com.example.exp4.mapper.BooksMapper;
import com.example.exp4.models.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBaits {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        BooksMapper booksMapper = sqlSession.getMapper(BooksMapper.class);
        List<Book> books = booksMapper.getAllBooks();
        System.out.println(books);
    }

    private static void getMySqlSimple() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 获取session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Book book = sqlSession.selectOne("getBookById", 1);
            System.out.println(book);
        }
    }

    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
