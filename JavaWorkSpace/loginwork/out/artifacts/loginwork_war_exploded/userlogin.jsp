<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/18
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <style>
        form{
            position: relative;
            left: 40%;
            top:150px;
        }
    </style>
</head>
<body>
<form method="post" action="LoginServlet">
    <table>
        <tr>
            <td><span>用户名:</span></td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td><span>lol区：</span></td>
            <td><input type="text" name="userlol" id="userlol"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
<script>
     $(function () {
         $("#username").blur(function () {
             var username=$("#username").val();
             if (username==null||username==""){
                 alert("请输入用户名");
             }
         })
         $("#userlol").blur(function () {
             var username=$("#username").val();
             var userlol=$("#userlol").val();
             if (username==""||username==null){
                 alert("请输入用户名")
             } else if(userlol==""||userlol==null){
                 alert("请输入lol区")
             }
         })
     })
</script>
</body>
</html>
