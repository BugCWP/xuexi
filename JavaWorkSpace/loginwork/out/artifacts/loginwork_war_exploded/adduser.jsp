<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/18
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<form action="addAdminServlet" method="post">
    <table>
        <tr>
            <td>账号</td>
            <td><input type="text" name="uname" id="uname"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="upwd" id="upwd"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
            <td>${err}</td>
        </tr>
    </table>
</form>
<script>
    $(function () {
        $("#uname").blur(function () {
            var uname=$("#uname").val();
            if (uname==null||uname==""){
                alert("请输入用户名")
            }
        })
        $("#upwd").blur(function () {
            var uname=$("#uname").val();
            var upwd=$("#upwd").val();
            if (uname==null||uname==""){
                alert("请输入用户名")
            }else if (upwd==null||upwd==""){
                alert("请输入密码")
            }
        })
    })
</script>
</body>
</html>
