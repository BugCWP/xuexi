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
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <style>
        form{
            position: absolute;
            left: 40%;
            top: 200px;
            text-align: center;
        }
    </style>
</head>
<body>
<%
    System.out.println(session.getAttribute("uname"));
    if(session.getAttribute("uname")!=null){
        response.sendRedirect("main.jsp");
    }
    String err="";
    if (request.getAttribute("error")!=null){
        err=(String) request.getAttribute("error");
    }
%>
<form action="LoginServlet" method="post" role="form">
    <table>
        <tr>
            <td><span>用户名：</span></td>
            <td><input type="text" name="uname" id="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td><span>密码</span></td>
            <td><input type="password" name="upwd" id="pwd" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td><span><%=err%></span></td>
            <td><input type="submit" value="登陆" id="btn" disabled></td>
        </tr>
    </table>
</form>
<script>
    $(function () {
        $("#username").change(function () {
            var name=$("#username").val();
            var pwd=$("#pwd").val();
            if (name==""){
                alert("用户名不能为空");
                $("#btn").attr('disabled',true);
            }
        })
        $("#pwd").change(function () {
            var name=$("#username").val();
            var pwd=$("#pwd").val();
            if (pwd==""){
                alert("密码不能为空");
                $("#btn").attr('disabled',true);
            }else if(name==""){
                alert("用户名不能为空");
                $("#btn").attr('disabled',true);
            }else {
                $("#btn").attr('disabled',false);
            }
        })
    })
</script>
</body>
</html>
