<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/24
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<span>学生户名：</span>
<input type="text" id="sname"><br/>
<span>年级：</span>
<input type="text" id="sgrade"><br/>
<span>班级：</span>
<input type="text" id="sclass"><br/>
<span>学号：</span>
<input type="text" id="snumber"><br/>
<input type="button" value="添加" id="addbtn">
<script>
    $(function () {
        // alert(getUrlParameter("uname"));
        $("#addbtn").click(function () {
            updatestudent();
        })
    })
    function updatestudent() {
        var sname=$("#sname").val();
        var sgrade=$("#sgrade").val();
        var sclass=$("#sclass").val();
        var snumber=$("#snumber").val();
        if (sname==""||sname==null){
            alert("请输入姓名");
        } else if (sgrade==""||sgrade==null){
            alert("请输入年级");
        }else if (sclass==""||sclass==null){
            alert("请输入班级");
        }else if (snumber==""||snumber==null){
            alert("请输入学号");
        }else {
            var j={"sname":sname,"sgrade":sgrade,"sclass":sclass,"snumber":snumber}
            $.ajax({
                url:"addStudentServlet",
                type:"post",
                data:j,
                contentType:"application/x-www-form-urlencoded",
                success:function (data) {
                    if (data=="success"){
                        window.location.href="studentlist.jsp";
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
