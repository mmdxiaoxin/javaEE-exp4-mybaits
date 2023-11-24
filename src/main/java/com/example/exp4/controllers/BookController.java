package com.example.exp4.controllers;

import com.example.exp4.models.Book;
import com.example.exp4.service.BooksService;
import com.example.exp4.utils.DateUtil;
import com.example.exp4.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookController", value = "/book-ctrl")
public class BookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前线程的 SqlSession
        SqlSession sqlSession = MyBatisUtils.getThreadLocalSqlSession();
        BooksService booksService = new BooksService(sqlSession);
        String action = request.getParameter("action");
        try {
            if ("list".equals(action)) {
                List<Book> books = booksService.list();
                System.out.println(books);
                request.setAttribute("result", books);
                request.getRequestDispatcher("/views/list.jsp").forward(request, response);
            } else if ("add".equals(action)) {
                request.getRequestDispatcher("/views/add.jsp").forward(request, response);
            } else if ("edit".equals(action)) {
                String id = request.getParameter("id");
                Book book = booksService.getById(Integer.parseInt(id));
                request.setAttribute("book", book);
                request.getRequestDispatcher("/views/edit.jsp").forward(request, response);
            } else if ("save".equals(action)) {
                String id = request.getParameter("id");
                String bookName = request.getParameter("bookName");
                String author = request.getParameter("author");
                String press = request.getParameter("press");
                String pressDate = request.getParameter("pressDate");
                String price = request.getParameter("price");
                Book book = new Book();
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPress(press);
                book.setPressDate(DateUtil.strToUtilDate(pressDate));
                book.setPrice(Float.parseFloat(price));
                if (id == null || id.isEmpty()) {
                    booksService.save(book);
                } else {
                    int idi = Integer.parseInt(id);
                    book.setId(idi);
                    booksService.save(book);
                }
                response.sendRedirect("book-ctrl?action=list");
            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                int idi = Integer.parseInt(id);
                booksService.delete(idi);
                response.sendRedirect("book-ctrl?action=list");
            } else if ("search".equals(action)) {
                Map<String, Object> conditions = new HashMap<>();
                String bookName = request.getParameter("bookName");
                String author = request.getParameter("author");
                String priceMin = request.getParameter("priceMin");
                String priceMax = request.getParameter("priceMax");
                String pressDateStart = request.getParameter("pressDateStart");
                String pressDateEnd = request.getParameter("pressDateEnd");
                // 处理模糊匹配的字符串参数
                if (bookName != null && !bookName.isEmpty()) {
                    conditions.put("bookName", "%" + bookName + "%");
                }
                if (author != null && !author.isEmpty()) {
                    conditions.put("author", "%" + author + "%");
                }
                // 其他参数处理...
                if (priceMin != null && !priceMin.isEmpty()) {
                    conditions.put("priceMin", Float.parseFloat(priceMin));
                }
                if (priceMax != null && !priceMax.isEmpty()) {
                    conditions.put("priceMax", Float.parseFloat(priceMax));
                }
                if (pressDateStart != null && !pressDateStart.isEmpty()) {
                    conditions.put("pressDateStart", DateUtil.strToUtilDate(pressDateStart));
                }
                if (pressDateEnd != null && !pressDateEnd.isEmpty()) {
                    conditions.put("pressDateEnd", DateUtil.strToUtilDate(pressDateEnd));
                }
                List<Book> books = booksService.getBooksByConditions(conditions);
                request.setAttribute("result", books);
                request.getRequestDispatcher("/views/list.jsp").forward(request, response);
            } else {
                throw new Exception("非法请求！！");
            }
        } catch (Exception e) {
            request.setAttribute("msg", e.getLocalizedMessage());
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
