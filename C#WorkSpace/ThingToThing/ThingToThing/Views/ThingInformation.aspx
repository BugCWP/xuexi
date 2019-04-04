<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ThingInformation.aspx.cs" Inherits="ThingToThing.Views.ThingInformation" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
     <link href="../CSS/MainMaster.css" rel="stylesheet" />
     <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
     <link href="../CSS/ThingInformation.css" rel="stylesheet" />
    <script src="../JS/jquery-3.2.1.min.js"></script>
     <script src="../JS/MainMaster.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../JS/ThingInformation.js"></script>
    <script src="../JS/jquery.cookie.js"></script>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div id="mainbody" class=" container-fluid">
              <div id="headmenu" class="row">
                <div class="col-lg-2">
                    <div style="position: relative; top: 35px; left: 50px;">
                        <a style="font-size: 35px; color: white; text-decoration: none; font-weight: 800">物to物</a>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div style="position: relative; top: 60px; left: -60px">
                        <span style="font-size: 9px; color: white;">加入物物交换，让物尽其用</span>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div style="position: relative; top: 45px;">
                        <a style="text-decoration: none; color: white; font-size: 23px" href="../Views/HomePage.aspx">首页</a>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div style="position: relative; top: 45px;">
                        <div id="MyThingBtn" style="text-decoration: none; color: white; font-size: 23px;cursor:pointer" >我的物品</div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div style="position: relative; top: 45px;">
                        <div id="MyThingPage" style="text-decoration: none; color: white; font-size: 23px; position: relative; left: -90px;cursor:pointer">我的订单</div>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div class="glyphicon glyphicon-shopping-cart" id="ShopChat" style="font-size: 27px; color: white; position: relative; top: 40px; left: 70px;cursor:pointer"></div>
                </div>
                <div class="col-lg-2">
                    <div id="LoginMenu" style="color: white; position: absolute; top: 50px; left: 20px;">
                        <a style="text-decoration: none; color: white ;cursor:pointer"  data-toggle="modal" data-target="#myModal" id="DengLu">你好请登陆</a> 
                        <a style="text-decoration: none; color: white ;cursor:pointer ; display:none;" id="LoginMenuname"></a>|
                        <a href="../Users/Register.aspx" style="text-decoration: none; color: white" id="ZhuCe">免费注册</a>
                        <a style="text-decoration: none; color: white; display:none;cursor:pointer;" id="ZhuXiao">注销</a>
                    </div>
                </div>
            </div>
            <div id="MainChar" class="row">
                <div style="width:80%;margin-left:10%;">
                    <div id="Thingimg" style="position:relative;width:200px;height:240px;background-color:black;left:100px;top:50px;">
                        <img style="width:200px;height:240px;" src="<%=siuq.ImgUrl[0] %>" id="bigimg"/>
                    </div>
                    <div id="Thingimgs" style="position:relative;width:400px;top:60px;left:50px;">
                        <%foreach (string url in siuq.ImgUrl) { %>
                        <img style="width:90px;height:90px;margin-right:10px;margin-top:10px;float:left" src="<%=url %>" class="YuLanimg"/>
                        <%} %>
                    </div>
                    <div id="ThingName" style="position:absolute;font-size:35px;left:530px;top:170px;">
                        <% =stm.ThingName%>
                    </div> 
                    
                    <div id="ThingType" style="position:absolute;font-size:25px;left:530px;top:220px;">
                        <%=stm.ThingType %>
                    </div>
                    <div id="ThingUserName" style="position:absolute;font-size:18px;left:530px;top:260px;">
                       卖家信息：<%=uim.UserName %><%=uim.UserPhone %><br/><%=uim.UserAdress %>
                    </div>
                    <div id="ThingTime" style="position:absolute;font-size:18px;left:530px;top:300px;">
                        上传时间：<%=stm.ThingTime %>
                    </div>
                    <div id="Thingintroducation" style="position:absolute;font-size:20px;left:530px;top:340px;width:400px;height:100px;word-wrap:break-word" >
                        <%=stm.ThingIntroduction %>
                    </div>
                    <div id="Pingjiadiv" style="width:900px;position:absolute;left:30%;top:500px;">
                        <div id="PingJiaCharu"></div>
                    <%foreach (ThingToThingModel.PingJiaModel p in listp)
                        { %>
                     <div class="pingjiaing">
                         <div class="PingJiaName"><%=p.UserName %></div>
                         <div class="PingJiaTime"><%=p.PJTime %></div>
                         <div class="PingJiaZhuTi"><%=p.PingJiatxt %></div>
                     </div>
                        <%} %>
                  <%if (UserId == null)
                      { %>
                    <textarea class="input-group" rows="4" style="width:500px;height:150px;" id="PingJia"></textarea>
                    <div class="btn btn-default" id="TiJiao" style="width:90px;height:30px;position:relative;left:400px;top:10px;">提交</div>
                    <input  id="ThingIdjump" type="hidden" value="<%=stm.ThingId %>" />
                       
                    <%} %>

                    </div>
                </div>
            </div>
            <div id="foot" class="row" style="position:relative;top:-1000px;">
                <div>
                </div>
            </div>
        </div>
         <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">欢迎登陆</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="LoginUserId">账号</label>
                            <input type="text" class="form-control" id="LoginUserId" placeholder="LoginId" />
                            <span id="TiShiLoginId" style="position:relative;top:-25px;left:530px;">&nbsp</span>
                        </div>
                        <div class="form-group">
                            <label for="LoginUserPassword">密码</label>
                            <input type="text" class="form-control" id="LoginUserPassword" placeholder="Password" />
                            <span id="TiShiLoginPwd" style="position:relative;top:-25px;left:530px;">&nbsp</span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="Loginbtn">登陆</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="Logincloss">关闭</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
