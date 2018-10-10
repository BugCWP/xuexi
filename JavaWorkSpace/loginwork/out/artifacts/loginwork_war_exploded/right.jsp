<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/18
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
   在线人数：<span id="count"></span>
   <table id="userlisttable" border="1">
       <tr id="trid">
           <td>用户名</td>
           <td>lol区</td>
           <td>登陆地址</td>
           <td>登陆时间</td>
       </tr>
   </table>
<script>
    $(function () {
        getUserList();
        setInterval("getUserList()",2000);
    })
    function getUserList() {
        $.ajax({
            url:"ajaxUserListServlet",
            type:"post",
            dataType:'json',
            data:"",
            success:function (res) {
                $("#trid").nextAll().remove();
                 $("#count").text(res.length);
                 for(var i=0;i<res.length;i++){
                     $("#userlisttable").append("<tr><td>"+res[i].uname+"</td><td>"+res[i].ulol+"</td><td>"+res[i].uip+"</td><td>"+res[i].utime+"</td></tr>");
                 }
            },
            error:function () {
                alert("请求出错");
            }
        })
    }
</script>
</body>
</html>
