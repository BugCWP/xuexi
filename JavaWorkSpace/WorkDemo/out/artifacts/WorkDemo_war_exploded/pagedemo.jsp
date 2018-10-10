<%@ page import="java.util.List" %>
<%@ page import="com.model.LoginUserModel" %>
<%@ page import="com.servlet.LoginServlet" %><%--
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
<table>
    <tr>
        <td>用户</td>
        <td>密码</td>
    </tr>
    <%
        List<LoginUserModel> loginUserModels= LoginServlet.loginUserModels;
        for (LoginUserModel user:loginUserModels){
    %>
    <tr>
        <td><%=user.getuName()%></td>
        <td><%=user.getuPwd()%></td>
    </tr>
    <%
        }
    %>
</table>
<%@include file="pagebtn.jsp"%>
</body>
</html>
