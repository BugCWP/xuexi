package com.servlet;

import com.model.adminModel;
import com.util.adminDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String upass=request.getParameter("upass");
        String uid=request.getRemoteAddr();
        SimpleDateFormat adf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String utime=adf.format(new Date());
        adminModel admin=new adminModel(uname,upass,uid,utime);
        adminDAL ad=new adminDAL();
         if (ad.selectAdmin(admin)){
             HttpSession session=request.getSession();
             session.setAttribute("user",admin);
             PrintWriter out=response.getWriter();
             out.print("success");
             out.flush();
             out.close();
         }else {
             PrintWriter out=response.getWriter();
             out.print("err");
             out.flush();
             out.close();
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
