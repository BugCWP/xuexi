<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/20
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<span>用户名：</span>
<input type="text" id="uname">
<span>密码：</span>
<input type="text" id="upass">
<input type="button" value="添加" id="addbtn">
<script>
    $(function () {
        $("#addbtn").click(function () {
            addadmin();
        })
    })
    function addadmin() {
        var uanme=$("#uname").val();
        var upass=$("#upass").val();
        if (uanme==""||uanme==null){
            alert("请输入用户名");
        } else if (upass==""||upass==null){
            alert("请输入密码");
        }else {
            var j={"uname":uanme,"upass":upass}
            $.ajax({
                url:"addAdminServlet",
                type:"post",
                data:j,
                contentType:"application/x-www-form-urlencoded",
                success:function (data) {
                    if (data=="success"){
                        window.location.href="selectadmin.jsp";
                    } else if (data=="error"){
                        alert("添加失败");
                    }
                },
                error:function (err) {

                }
            })
        }
    }
</script>
</body>
</html>
