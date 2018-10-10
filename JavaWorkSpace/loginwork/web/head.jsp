<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/18
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<h1>欢迎登陆<span id="uname"></span></h1><a href="LoginServlet?out=1" target="_top">注销</a>
<script>
    $(function () {
        getUName();
    })
    function getUName() {
        $.ajax({
            url:"ajaxUserListServlet",
            type:'get',
            success:function (res) {
                $("#uname").text(res);
            },
            error:function (e) {
                $("#uname").text("查询失败");
            }
        })
    }
</script>
</body>
</html>
