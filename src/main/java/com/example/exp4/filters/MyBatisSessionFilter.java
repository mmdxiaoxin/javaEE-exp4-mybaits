package com.example.exp4.filters;

import com.example.exp4.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import java.io.IOException;

public class MyBatisSessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // ...
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession()) {
            // 将 SqlSession 存放在 ThreadLocal 中，使其在整个请求范围内可用
            MyBatisUtils.setSqlSession(sqlSession);

            chain.doFilter(request, response);

            // 提交事务
            sqlSession.commit();
        } finally {
            // 关闭 SqlSession，确保资源被释放
            MyBatisUtils.closeSqlSession();
        }
    }

    @Override
    public void destroy() {
        // ...
    }
}
