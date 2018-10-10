package com.servlet;

import com.model.adminModel;
import com.util.adminDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addAdminServlet")
public class addAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String upass=request.getParameter("upass");
//      System.out.println(uname+upass);
        adminDAL ad=new adminDAL();
        adminModel admin=new adminModel(uname,upass);
        if(ad.addAdmin(admin)){
            PrintWriter out=response.getWriter();
            out.print("success");
            out.flush();
            out.close();
        }else {
            PrintWriter out=response.getWriter();
            out.print("error");
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
