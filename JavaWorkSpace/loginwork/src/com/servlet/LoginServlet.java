package com.servlet;

import com.model.userModel;
import com.util.userDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String uname=request.getParameter("username");
         String ulol=request.getParameter("userlol");
         String uip=request.getRemoteAddr();
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String utime=sdf.format(new Date());
         userModel user=new userModel(uname,ulol,uip,utime);
         HttpSession session=request.getSession();
         session.setAttribute("user",user);
         response.sendRedirect("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         if(request.getParameter("out")!=null){
             HttpSession session=request.getSession();
             session.removeAttribute("user");
             response.sendRedirect("userlogin.jsp");
         }
    }
}
