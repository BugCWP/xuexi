<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/20
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <style>
        table{
            position: relative;
            left: 40%;
            top:150px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>用户：</td>
        <td><input type="text" id="uname" /></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input type="password" id="upass"></td>
    </tr>
    <tr>
        <td>
            <input type="button" id="loginbtn" value="登陆">
        </td>
    </tr>
</table>
<script>
    $(function () {
        $("#uname").blur(function () {
            var username=$("#uname").val();
            if (username==null||username==""){
                alert("请输入用户名");
            }
        })
        $("#upass").blur(function () {
            var username=$("#uname").val();
            var userlol=$("#upass").val();
            if (username==""||username==null){
                alert("请输入用户名")
            } else if(userlol==""||userlol==null){
                alert("请输入密码")
            }
        })
        $("#loginbtn").click(function () {
            var uname=$("#uname").val();
            var upass=$("#upass").val();
            var j={"uname":uname,"upass":upass};
            $.ajax({
                url:"LoginServlet",
                type:"post",
                data:j,
                contentType:"application/x-www-form-urlencoded",
                success:function (data) {
                    if (data="success"){
                        window.location.href="main.jsp";
                    }
                   else if (data=="err"){
                       alert("登陆错误");
                   }
                },
                error:function () {

                }
            })
        })
    })
</script>
</body>
</html>
