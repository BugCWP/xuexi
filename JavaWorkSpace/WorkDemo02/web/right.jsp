<%@ page import="java.util.List" %>
<%@ page import="com.model.userModel" %>
<%@ page import="com.dal.userDAL" %><%--
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
<%
    userDAL udl=new userDAL();
    List<userModel> userModels=udl.userModelList();
    int i=userModels.size();
%>
<h1>在线人数为<%=i%></h1>
<table>
    <tr>
        <td>用户名：</td>
        <td>lol:</td>
        <td>登录时间：</td>
        <td>登陆地址：</td>
    </tr>
    <%
        for (userModel user:userModels){

    %>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLol()%></td>
        <td><%=user.getTime()%></td>
        <td><%=user.getIp()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
