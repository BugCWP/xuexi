package com.servlet;

import com.model.adminModel;
import com.util.adminDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAdminServlet")
public class deleteAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String uname=request.getParameter("uname");
         String upass=request.getParameter("upass");
//         System.out.println(uname+upass);
         adminDAL ad=new adminDAL();
        adminModel admin=new adminModel(uname,upass);
         if (ad.delAdmin(admin)){
             request.getRequestDispatcher("/selectadmin.jsp").forward(request,response);
         }else {

         }
    }
}
