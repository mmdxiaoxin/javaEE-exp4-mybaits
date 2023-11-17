package com.example.exp4.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化代码
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // 检查用户是否已登录
        boolean loggedIn = session != null && session.getAttribute("username") != null;

        // 获取请求的资源路径
        String requestURI = httpRequest.getRequestURI();

        // 如果用户已登录或请求是登录页面，允许继续访问
        if (loggedIn || isLoginPage(requestURI)) {
            chain.doFilter(request, response);
        } else {
            // 用户未登录，重定向到登录页面
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/views/login.jsp");
        }
    }

    // 检查请求是否是登录页面
    private boolean isLoginPage(String requestURI) {
        return requestURI.endsWith("/views/login.jsp") || requestURI.endsWith("/user-ctrl") || requestURI.endsWith("/user-ctrl?action=login");
    }

    @Override
    public void destroy() {
        // 销毁代码
    }
}
