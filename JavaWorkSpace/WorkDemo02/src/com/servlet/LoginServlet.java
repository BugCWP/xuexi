package com.servlet;

import com.dal.userDAL;
import com.model.userModel;

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
    userDAL ud=new userDAL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String pass=request.getParameter("userpassword");
        System.out.println(name);
        System.out.println(pass);
        String lol=request.getParameter("userlol");
        String ip=request.getRemoteAddr();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(new Date());
        if (ud.selectUser(name,pass)){
            userModel user=new userModel(name,pass,lol,time,ip);
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("main.jsp");
        }else {
            HttpSession session=request.getSession();
            session.setAttribute("res","登陆失败");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
