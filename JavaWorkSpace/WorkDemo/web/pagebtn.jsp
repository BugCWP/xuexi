<%@page import="com.dbdemo.pageDAL" %>
<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/13
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!int pageIndex=pageDAL.pageIndex;%>
<a href="LoginServlet?pageIndex=-1">上一页</a>
<span>当前页数<%=pageIndex%></span>
<a href="LoginServlet?pageIndex=1">下一页</a>
</body>
</html>
