package com.example.exp4.filters;

import java.io.IOException;
import java.util.Objects;

public class EncodingFilter implements javax.servlet.Filter {
    private String encoding = null;

    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException, IOException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void init(javax.servlet.FilterConfig fConfig) throws javax.servlet.ServletException {
        encoding = fConfig.getInitParameter("encoding");
        this.encoding = Objects.requireNonNullElse(encoding, "UTF-8");
    }

}
