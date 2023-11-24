package com.example.exp4.mapper;

import com.example.exp4.models.Book;

import java.util.List;
import java.util.Map;

public interface BooksMapper {

    int addBook(Book book);

    int deleteBook(int id);

    int updateBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    List<Book> getBooksByConditions(Map<String, Object> conditions);

}

// 使用注解的方式实现
/*public interface BooksMapper {

    @Insert("INSERT INTO books(book_name, author, price, press, press_date) " +
            "VALUES (#{bookName}, #{author}, #{price}, #{press}, #{pressDate})")
    int addBook(Book book);

    @Delete("DELETE FROM books WHERE id = #{id}")
    int deleteBook(int id);

    @Update("UPDATE books SET book_name  = #{bookName}, " +
            "author     = #{author}, " +
            "price      = #{price}, " +
            "press      = #{press}, " +
            "press_date = #{pressDate} " +
            "WHERE id = #{id}")
    int updateBook(Book book);

    @Select("SELECT * FROM books")
    List<Book> getAllBooks();

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book getBookById(int id);

    @Select({
            "SELECT * FROM books",
            "WHERE",
            "<if test='bookName != null and !bookName.isEmpty()'>",
            "   book_name LIKE #{bookName}",
            "</if>",
            "<if test='author != null and !author.isEmpty()'>",
            "   AND author LIKE #{author}",
            "</if>",
            "<if test='priceMin != null'>",
            "   AND price &gt;= #{priceMin}",
            "</if>",
            "<if test='priceMax != null'>",
            "   AND price &lt;= #{priceMax}",
            "</if>",
            "<if test='pressDateStart != null'>",
            "   AND press_date &gt;= #{pressDateStart}",
            "</if>",
            "<if test='pressDateEnd != null'>",
            "   AND press_date &lt;= #{pressDateEnd}",
            "</if>"
    })
    List<Book> getBooksByConditions(Map<String, Object> conditions);
}*/