<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/24
  Time: 21:27
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
<input type="button" value="修改" id="addbtn">
<script>
    $(function () {
        // alert(getUrlParameter("uname"));
        $("#uname").val(getUrlParameter("uname"));
        $("#upass").val(getUrlParameter("upass"));
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
                url:"updateAdminServlet",
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
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };
</script>
</body>
</html>
