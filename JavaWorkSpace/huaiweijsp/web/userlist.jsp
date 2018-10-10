<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/11
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<%
    if(session.getAttribute("list")!=null){
        ResultSet res= (ResultSet) session.getAttribute("list");
        try {
            while (res.next()){
            %>
              <tr>
                  <td><%=res.getString("uName")%></td>
                  <td><%=res.getString("uPwd")%></td>
                  <td><a href="LoginServlet?name=<%=res.getString("uName")%>&&pwd=<%=res.getString("uPwd")%>">删除</a></td>
              </tr>
            <%
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
%>
</table>
</body>
</html>
