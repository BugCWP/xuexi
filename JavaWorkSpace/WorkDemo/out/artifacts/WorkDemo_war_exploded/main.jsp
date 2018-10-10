<%@ page import="java.util.List" %>
<%@ page import="com.model.UserModel" %>
<%@ page import="com.listener.userListener" %><%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/12
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.addIntHeader("Refresh",2);
%>
<h1>欢迎登陆,在线人数<%=userListener.number%></h1>
<a href="LoginServlet?out=1">注销</a>
<table border="1">
    <tr>
        <td>大名</td>
        <td>LOL区</td>
        <td>上线时间</td>
        <td>IP地址</td>
    </tr>
<%
    List<UserModel> userModelList= userListener.userModelList;
    for(UserModel user:userModelList){
%>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getLol()%></td>
        <td><%=user.getTime()%></td>
        <td><%=user.getIp()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
