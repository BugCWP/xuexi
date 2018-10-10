package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private String charset=null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (charset!=null&&"".equals(charset)){
            HttpServletResponse response=(HttpServletResponse)resp;
            HttpServletRequest request=(HttpServletRequest)req;
            request.setCharacterEncoding(charset);
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
         charset=config.getInitParameter("charset");
    }

}
