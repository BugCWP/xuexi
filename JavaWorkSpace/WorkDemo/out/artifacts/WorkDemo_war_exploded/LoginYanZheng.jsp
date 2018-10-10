<%@ page import="com.servlet.PageServlet" %><%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/13
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String tishi="";
    if(PageServlet.OK){
        tishi="登陆成功";
    }else {
        tishi="登陆失败";
    }
%>
<form action="PageServlet" method="post">
   <input name="uname" type="text">
    <input name="upwd" type="password">
    <input type="submit" value="验证">
    <span><%=tishi%></span>
</form>
</body>
</html>
