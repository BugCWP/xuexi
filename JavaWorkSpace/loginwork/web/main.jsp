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
</head>
<frameset rows="100px,*">
    <frame src="head.jsp" name="head">
<frameset cols="300px,500px,*">
    <frame src="adminlogin.jsp" name="left">
    <frame src="" name="center">
    <frame src="right.jsp" name="right">
</frameset>
</frameset>
<body>
<script>
    window.onunload=function (ev) {
        window.location.href="LoginServlet?out=1";
    }
</script>
</body>
</html>
