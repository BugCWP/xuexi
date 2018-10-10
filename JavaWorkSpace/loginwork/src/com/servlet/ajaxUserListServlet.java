package com.servlet;

import com.alibaba.fastjson.JSON;
import com.model.userModel;
import com.util.userDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ajaxUserListServlet")
public class ajaxUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDAL ud=new userDAL();
        List<userModel> userModels=ud.selectuser();
        String result= JSON.toJSONString(userModels);
        PrintWriter out=response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        userModel res= (userModel)session.getAttribute("user");
        String uname=res.getUname();
        PrintWriter out=response.getWriter();
         out.print(uname);
         out.flush();
         out.close();
    }
}
