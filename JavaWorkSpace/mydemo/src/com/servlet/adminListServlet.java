package com.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.Page;
import com.model.adminModel;
import com.util.adminDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "adminListServlet")
public class adminListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page page=new Page();
        adminDAL ad=new adminDAL();
        int pageIndex=0;
        pageIndex= Integer.parseInt(request.getParameter("page"));
        page.setTotalCount(ad.adminCount());
        if (page.getTotalCount()%page.getPageSize()==0){
            page.setPageCount(page.getTotalCount()/page.getPageSize());
        }else {
            page.setPageCount(page.getTotalCount()/page.getPageSize()+1);
        }
        if (pageIndex!=0){
            pageIndex=pageIndex+page.getPageSize();
            if (pageIndex<=0){
                page.setPageIndex(1);
            }else if (pageIndex>page.getPageCount()){
                page.setPageIndex(page.getPageCount());
            }else {
                page.setPageIndex(pageIndex);
            }
        }
        List<adminModel> adminModels= ad.selectAdminlist(page);
        for (adminModel a:adminModels){
            System.out.println(a.getUname());
        }
       JSONObject json=new JSONObject();
       json.put("page",page);
       json.put("users",adminModels);
       String result=json.toString();
       System.out.println(result);
        PrintWriter out=response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("selectadmin.jsp").forward(request,response);
    }
}
