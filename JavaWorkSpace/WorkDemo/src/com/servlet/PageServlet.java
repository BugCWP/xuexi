package com.servlet;

import com.dbdemo.LoginYanZhen;
import com.dbdemo.UserListDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet")
public class PageServlet extends HttpServlet {
    public static boolean OK=false;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String uname=request.getParameter("uname");
         String upwd=request.getParameter("upwd");
         LoginYanZhen lg=new LoginYanZhen();
         if (lg.login(uname,upwd)){
             OK=true;
         }else {
             OK=false;
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
