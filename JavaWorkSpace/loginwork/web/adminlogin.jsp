<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/18
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <table>
        <tr>
            <td>账户：</td>
            <td><input type="text" name="uname" id="uname"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="upwd" id="upwd"></td>
        </tr>
        <tr>
            <td><input type="button" id="adminlogin" value="登陆"></td>
        </tr>
    </table>
    <a href="left.jsp" id="leftbutten"></a>
<script>
    $(function () {
        $("#uname").blur(function () {
            var uname=$("#uname").val();
            if (uname==""||uname==null){
                alert("请输入账号");
            }
        })
        $("#upwd").blur(function () {
            var uname=$("#uname").val();
            var upwd=$("#upwd").val();
            if (uname==""||uname==null){
                alert("请输入账号");
            }else if(upwd==""||upwd==null){
                alert("请输入密码");
            }
        })
        $("#adminlogin").click(function () {
            var uname=$("#uname").val();
            var upwd=$("#upwd").val();
           $.post("adminLoginServlet",{"uname":uname,"upwd":upwd},function (data) {
               if (data=="success"){
                    $("#leftbutten")[0].click();
               }
           })
        })
    })
</script>
</body>
</html>
