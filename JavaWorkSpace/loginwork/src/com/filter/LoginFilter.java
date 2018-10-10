package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private String charset;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //chain.doFilter(req, resp);
        if (charset!=null&&!"".equals(charset)){
            HttpServletRequest request=(HttpServletRequest) req;
            HttpServletResponse response=(HttpServletResponse) resp;
            request.setCharacterEncoding(charset);
            response.setCharacterEncoding(charset);
            chain.doFilter(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
          charset=config.getInitParameter("charset");
    }

}
