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

@WebServlet(name = "deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("进入删除");
           String id=request.getParameter("id");
           System.out.println(id);
           studentModel student=new studentModel(Integer.parseInt(id));
           studentDAL sd=new studentDAL();
           if (sd.delStudent(student)){
               request.getRequestDispatcher("/studentlist.jsp");
           }else {
              System.out.println("删除失败");
           }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
