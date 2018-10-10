<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/8
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="position:relative;top: 200px;left: 40%;text-align: center">
    <table>
        <th>
            <td>登陆界面</td>
        </th>
        <tr>
            <td>
                <span>用户名：</span>
            </td>
            <td>
                <input type="text" name="username" id="username" placeholder="请输入用户名" >
            </td>
        </tr>
        <tr>
            <td>
                <span>密码：</span>
            </td>
            <td>
                <input type="password" name="password" id="password" placeholder="请输入密码" >
            </td>
        </tr>
        <tr>
            <td>
              <input type="button" onclick="isclick()" value="登陆">
            </td>
        </tr>
    </table>
</form>
<script>
    function isclick(){
        var name=document.getElementById("username").value;
        var pass=document.getElementById("password").value;
        if (name==""){
            alert("输入用户名");
        } else if(pass==""){
            alert("输入密码");
        }
    }
</script>
</body>
</html>
