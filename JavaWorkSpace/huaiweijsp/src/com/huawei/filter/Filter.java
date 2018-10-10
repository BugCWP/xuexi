package com.huawei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);//只有执行doFilter才能继续走

    }
     //初始化方法，执行一次，过滤器一创建就执行，可以初始化一些参数
    public void init(FilterConfig config) throws ServletException {
        String charset=config.getInitParameter("charset");
        System.out.println(charset);
    }

}
