package com.huawei.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    private String charset=null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(charset!=null &&!"".equals(charset)){
            HttpServletRequest request=(HttpServletRequest)req;
            HttpServletResponse response=(HttpServletResponse)resp;
             req.setCharacterEncoding(charset);
             response.setCharacterEncoding(charset);
             chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
          charset=config.getInitParameter("charset");

    }

}
