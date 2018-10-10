<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/14
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      form{
        position: relative;
        left: 40%;
        top:150px;
      }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
  </head>
  <body>
  <form action="LoginServlet" method="post">
     <table>
        <tr>
          <td><span>用户名:</span></td>
          <td><input type="text" name="username" id="username" value="" placeholder="请输入用户名"></td>
        </tr>
       <tr>
         <td><span>用户密码:</span></td>
         <td><input type="password" name="userpassword" id="userpassword" value="" placeholder="请输入密码"></td>
       </tr>
       <tr>
         <td><span>LOL：</span></td>
         <td><input type="text" name="userlol" id="userlol"></td>
       </tr>
       <tr>
         <td><span></span></td>
         <td><input type="submit" value="登陆"></td>
       </tr>
     </table>
  </form>
  <script>
    $(function () {
        $("#username").blur(function () {
            var name=$("#username").val();
            if (name==""){
                alert("请输入用户名");
            }
        });
        $("#userpassword").blur(function () {
            var pass=$("#userpassword").val();
            if (pass==""){
                alert("请输入密码");
            }
        })
    })
  </script>
  </body>
</html>
