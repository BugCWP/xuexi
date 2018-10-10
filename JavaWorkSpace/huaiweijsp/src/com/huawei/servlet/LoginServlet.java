package com.huawei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

import com.huaiwei.bean.FindUser;
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    FindUser fu=new FindUser();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("post进入");
          String name=request.getParameter("uname");
          String pwd=request.getParameter("upwd");
          if (fu.finduser(name,pwd)){
              HttpSession session=request.getSession();
              session.setAttribute("uname",name);
              response.sendRedirect("main.jsp");
          }else {
              String err="请重新登录";
              request.setAttribute("error",err);
              request.getRequestDispatcher("Login.jsp").forward(request,response);
          }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get进入");
        if (request.getParameter("out")!=null){
            HttpSession session=request.getSession();
            session.removeAttribute("uname");
           response.sendRedirect("Login.jsp");
        }
        if (request.getParameter("List")!=null){
             ResultSet res=fu.getUserList();
             HttpSession session=request.getSession();
             session.setAttribute("list",res);
             response.sendRedirect("userlist.jsp");
        }
        if(request.getParameter("name")!=null){
            String name=request.getParameter("name");
            String pwd=request.getParameter("pwd");
            if(fu.deleteUser(name,pwd)){
                ResultSet res=fu.getUserList();
                HttpSession session=request.getSession();
                session.setAttribute("list",res);
                request.getRequestDispatcher("userlist.jsp");
            }
        }
    }
}
