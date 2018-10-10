<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/12
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <form action="LoginServlet" method="post">
         <table>
             <tr>
                 <td>用户名:</td>
                 <td><input type="text" name="uname" id="uname" value=""></td>
             </tr>
             <tr>
                 <td>LOL区：</td>
                 <td><input type="text" name="lol" id="lol" value=""></td>
             </tr>
             <tr>
                 <input type="submit" value="登陆">
             </tr>
         </table>
     </form>
</body>
</html>
