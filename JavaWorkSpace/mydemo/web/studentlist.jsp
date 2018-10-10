<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/24
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<table border="1" id="userlist">
    <tr id="trid">
        <td>学生姓名</td>
        <td>年级</td>
        <td>班级</td>
        <td>学号</td>
    </tr>
</table>
<button id="prepage">上一页</button>
<span id="count"></span>
<button id="nextpage">下一页</button>
总页数：<span id="pagecount"></span>
<script>
    $(function () {
        getList(0);
        $("#prepage").click(function () {
            getList(-1);
        });
        $("#nextpage").click(function () {
            getList(1);
        })
    })
    function getList(pagenum) {
        var j={"page":pagenum}
        $.ajax({
            url:"studentListServlet",
            type:"post",
            data:j,
            dataType:"json",
            contentType:"application/x-www-form-urlencoded",
            success:function (data) {
                console.log(data);
                $("#trid").nextAll().remove();
                $("#count").text(data.page.pageIndex);
                $("#pagecount").text(data.page.pageCount);
                console.log(data.users.length);
                for (var i=0;i<data.users.length;i++){
                    var tr=document.createElement("tr");
                    var td1=document.createElement("td");
                    td1.appendChild(document.createTextNode(data.users[i].sname));
                    var td2=document.createElement("td");
                    td2.appendChild(document.createTextNode(data.users[i].sgrade));
                    var td3=document.createElement("td");
                    td3.appendChild(document.createTextNode(data.users[i].sclass));
                    var td4=document.createElement("td");
                    td4.appendChild(document.createTextNode(data.users[i].snumber));
                    var td5=document.createElement("td");
                    var a1=document.createElement("a");
                    var a2=document.createElement("a");
                    a1.href="deleteStudentServlet?id="+data.users[i].id+"";
                    a2.href="updatestudent.jsp?id="+data.users[i].id+"&&sname="+data.users[i].sname+"&&sgrade="+data.users[i].sgrade+"&&sclass="+data.users[i].sclass+"&&snumber="+data.users[i].snumber+"";
                    a1.innerText="删除";
                    a2.innerText="修改";
                    td5.appendChild(a1);
                    td5.appendChild(a2);
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    tr.append(td5);
                    $("#userlist").append(tr);
                }
            },
            error:function () {

            }
        })
    }
</script>
</body>
</html>
