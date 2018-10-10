<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/11
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String username=(String)session.getAttribute("uname");%>
<h1>欢迎<%=username%>登陆</h1>
<a href="LoginServlet?out=1">注销</a>&nbsp;&nbsp;
<a href="LoginServlet?List=1">用户列表</a>
</body>
</html>
