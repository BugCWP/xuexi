package com.servlet;

import com.model.LoginUserModel;
import com.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbdemo.pageDAL;
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("uname");
        String lol=request.getParameter("lol");
        String ip=request.getRemoteAddr();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(new Date());
        UserModel user=new UserModel(name,ip,time,lol);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        response.sendRedirect("main.jsp");
    }
    public static List<LoginUserModel> loginUserModels=pageDAL.getloginUserModels();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          if(request.getParameter("out")!=null){
              HttpSession session=request.getSession();
              session.removeAttribute("user");
              response.sendRedirect("main.jsp");
          }
          if (request.getParameter("pageIndex")!=null){
              int cout=Integer.parseInt(request.getParameter("pageIndex"));
              System.out.println(cout);
              int pageIndex=pageDAL.pageIndex;
              pageDAL.pageIndex=pageIndex+cout;
              loginUserModels=pageDAL.getloginUserModels();
              response.sendRedirect("pagedemo.jsp");
          }
    }
}
