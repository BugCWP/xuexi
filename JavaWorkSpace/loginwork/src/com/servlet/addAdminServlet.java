package com.servlet;

import com.model.adminModel;
import com.util.adminDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addAdminServlet")
public class addAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String uname=request.getParameter("uname");
          String upwd=request.getParameter("upwd");
          System.out.println(uname+upwd);
          adminModel admin=new adminModel(uname,upwd);
          adminDAL ad=new adminDAL();
          boolean res=ad.addAdmin(admin);
          if (res){
              request.getRequestDispatcher("center.jsp").forward(request,response);
          }else {
              request.setAttribute("err","添加失败");
          }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
