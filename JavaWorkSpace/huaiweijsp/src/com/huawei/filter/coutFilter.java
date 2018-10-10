package com.huawei.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "coutFilter")
public class coutFilter implements Filter {
    private int count=0;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        count++;
        ServletContext context= req.getServletContext();
        context.setAttribute("count",count);
        System.out.println(req.getRemoteAddr());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
