package com.servlet;

import com.model.adminModel;
import com.model.studentModel;
import com.util.studentDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addStudentServlet")
public class addStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname=request.getParameter("sname");
        String sgrade=request.getParameter("sgrade");
        String sclass=request.getParameter("sclass");
        String snumber=request.getParameter("snumber");
//      System.out.println(uname+upass);
        studentDAL sd=new studentDAL();
        studentModel student=new studentModel(sname,snumber,sgrade,sclass);
        if(sd.addStudent(student)){
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
