package com.servlet;

import com.model.studentModel;
import com.util.studentDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        System.out.println(id);
        String sname=request.getParameter("sname");
        String sgrade=request.getParameter("sgrade");
        String sclass=request.getParameter("sclass");
        String snumber=request.getParameter("snumber");
        studentModel student=new studentModel(Integer.parseInt(id),sname,snumber,sgrade,sclass);
        studentDAL sd=new studentDAL();
       if(sd.updateStudent(student)){
           PrintWriter out=response.getWriter();
           out.print("success");
           out.flush();
           out.close();
       }else {
           System.out.println("学生列表修改失败");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
