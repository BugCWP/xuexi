<%@ page import="com.model.userModel" %><%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/14
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% userModel user=(userModel)session.getAttribute("user");%>
<h1>欢迎登陆<%=user.getName()%></h1>
</body>
</html>
