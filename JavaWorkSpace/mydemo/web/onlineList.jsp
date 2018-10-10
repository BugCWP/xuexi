<%--
  Created by IntelliJ IDEA.
  User: BugCWP
  Date: 2018/9/20
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<h1>在线人数：<span id="count"></span></h1>
<table id="userList">
    <tr id="trid">
        <td>用户</td>
        <td>登陆时间</td>
        <td>登陆地址</td>
    </tr>
</table>
<script>
    $(function () {
          getOnline();
          setInterval("getOnline()",3000);
    })
    function getOnline() {
        $.ajax({
            url:"onlineListServlet",
            type:"post",
            dataType:"json",
            success:function (data) {
                console.log(data);
                $("#trid").nextAll().remove();
                $("#count").text(data.length);
                for (var i=0;i<data.length;i++){
                    var tr=document.createElement("tr");
                    var td1=document.createElement("td");
                    td1.appendChild(document.createTextNode(data[i].uname));
                    var td2=document.createElement("td");
                    td2.appendChild(document.createTextNode(data[i].utime));
                    var td3=document.createElement("td");
                    td3.appendChild(document.createTextNode(data[i].uid));
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    $("#userList").append(tr);
                }
            },
            error:function (err) {

            }
        })
    }
</script>
</body>
</html>
