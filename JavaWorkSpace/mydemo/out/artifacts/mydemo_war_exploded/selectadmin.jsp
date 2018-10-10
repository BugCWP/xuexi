<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/20
  Time: 16:16
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
        <td>用户名：</td>
        <td>密码：</td>
        <td>操作</td>
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
            url:"adminListServlet",
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
                    td1.appendChild(document.createTextNode(data.users[i].uname));
                    var td2=document.createElement("td");
                    td2.appendChild(document.createTextNode(data.users[i].upass));
                    var td3=document.createElement("td");
                    var a1=document.createElement("a");
                    var a2=document.createElement("a");
                    a1.href="deleteAdminServlet?uname="+data.users[i].uname+"&&upass="+data.users[i].upass+"";
                    a2.href="updateadmin.jsp?uname="+data.users[i].uname+"&&upass="+data.users[i].upass+"";
                    a1.innerText="删除";
                    a2.innerText="修改";
                    td3.appendChild(a1);
                    td3.appendChild(a2);
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
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
