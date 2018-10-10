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
<table border="1" id="userlisttable">
    <tr id="trid">
        <td>用户账号</td>
        <td>用户密码</td>
    </tr>
</table>
<jsp:include page="pagedemo.jsp"></jsp:include>
<script>
    $(function () {
        getAdminList();
        setInterval("getAdminList()",1000);
    })
    function getAdminList() {
        $.ajax({
            url:"adminListServlet",
            type:"post",
            data:"",
            dataType:"json",
            success:function (res) {
                console.log(res);
                $("#trid").nextAll().remove();
                for(var i=0;i<res.length;i++){
                    $("#userlisttable").append("<tr><td>"+res[i].uname+"</td><td>"+res[i].upass+"</td></tr>");
                }
            },
            error:function (err) {
                console.log("失败");
            }
        })
    }
</script>
</body>
</html>
