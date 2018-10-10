package com.listener;

import com.dbdemo.UserListDAL;
import com.model.UserModel;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class userListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public userListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------
    public static List<UserModel> userModelList=new ArrayList<>();
    public static int number=0;
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
      boolean res=false;
      UserListDAL uld=new UserListDAL();
      String name= sbe.getName();
      if ("user".equals(name)) {
          System.out.println("有人登陆");
          res = uld.inputUser((UserModel) sbe.getValue());
          number++;
      }
      if (res==true){
          userModelList=uld.getUserList();
      }
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        boolean res=false;
        UserListDAL uld=new UserListDAL();
        String name= sbe.getName();
        if ("user".equals(name)) {
            System.out.println("有人离开");
            res = uld.deletUser((UserModel) sbe.getValue());
            number--;
        }
        if (res==true){
            System.out.println("删除成功");
           userModelList=uld.getUserList();
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
