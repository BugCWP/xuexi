<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MyChar.aspx.cs" Inherits="ThingToThing.Views.MyChar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
     <link href="../CSS/MainMaster.css" rel="stylesheet" />
     <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
     <link href="../CSS/MyChar.css" rel="stylesheet" />
    <script src="../JS/jquery-3.2.1.min.js"></script>
     <script src="../JS/MainMaster.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../JS/MyChar.js"></script>
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
                <div id="CharLeft" style="width:50%;height:500px;background-color:white;overflow-y:auto;">
                    <div id="CharJiaoYi" style="width:100%;">
                       <%-- <div class="ThingChange">
                            <div class="MyThingChange">
                                <div class="MyThingChangeImg"></div>
                                <div class="MyThingChangeName">name</div>
                                <div class="MyThingChangeType">type</div>
                            </div>
                            <div class="ChangeThingChange">
                                <div class="changeThingChangeImg"></div>
                                <div class="changeThingChangeName">name</div>
                                <div class="changeThingChangeType">Type</div>
                            </div>
                        </div>--%>
                        <%foreach (ThingToThingModel.ShopCharThingChangeModel sctc in shopcharthingchange) { %>
                        <div class="ThingChange">
                            <div class="MyThingChange">
                                <div class="MyThingChangeImg">
                                    <img src="<%=sctc.myshopUrl %>""/>
                                </div>
                                <div class="MyThingChangeName"><%=sctc.myshopThing.ThingName %></div>
                                <div class="MyThingChangeType"><%=sctc.myshopThing.ThingType %></div>
                            </div>
                            <div style="color:green;font-size:20px;float:left;position:relative;left:100px;top:30px;">物品等待交易</div>
                            <div class="ChangeThingChange">
                                <div class="changeThingChangeImg">
                                    <img src="<%=sctc.changeshopUrl %>""/>
                                </div>
                                <div class="changeThingChangeName"><%=sctc.changeshopThing.ThingName %></div>
                                <div class="changeThingChangeType"><%=sctc.changeshopThing.ThingType %></div>
                            </div>
                        </div>

                        <%} %>
                    </div>
                </div>
                <div id="CharRight" style="width:50%;height:500px;background-color:white;overflow-y:auto;">
                    <div id="CharLiShi" style="width:100%;">
                      
                      <%foreach (ThingToThingModel.ShopCharThingChangeModel sctc in shopcharthingchangeover) { %>
                        <div class="ThingChange">
                            <div class="MyThingChange">
                                <div class="MyThingChangeImg">
                                    <img src="<%=sctc.myshopUrl %>""/>
                                </div>
                                <div class="MyThingChangeName"><%=sctc.myshopThing.ThingName %></div>
                                <div class="MyThingChangeType"><%=sctc.myshopThing.ThingType %></div>
                            </div>
                            <div style="color:red;font-size:20px;float:left;position:relative;left:100px;top:30px;">物品以交易等待收货</div>
                            <div class="ChangeThingChange">
                                <div class="changeThingChangeImg">
                                    <img src="<%=sctc.changeshopUrl %>""/>
                                </div>
                                <div class="changeThingChangeName"><%=sctc.changeshopThing.ThingName %></div>
                                <div class="changeThingChangeType"><%=sctc.changeshopThing.ThingType %></div>
                            </div>
                        </div>
                        <%} %>
                    </div>
                </div>
                <div id="CharBottom" style="position:relative;left:50%;top:-1000px; width:50%;height:1000px;">
                    <div id="CharChange" style="width:100%;height:200px;">
                        <div id="thingby" style="width:300px;height:180px;margin-top:10px;">
                            <div id="byimg" style="height:150px;width:140px;margin-left:20px;margin-top:15px;float:left">
                                <img src="<%=byimg.ImgUrl %>" style="width:140px;height:150px;"/>
                            </div>
                            <div id="byname" style="float:left;font-size:27px;position:relative;left:10px;top:30px;"><%=byshop.ThingName %></div>
                            <div id="bytype"style="float:left;font-size:20px;position:relative;left:-50px;top:80px;"><%=byshop.ThingType %></div>
                            <input  id="myThingid" type="hidden" value="<%=byshop.ThingId %>""/>
                        </div>
                        <div id="changebtn" class="btn btn-default" style="position:absolute;width:100px;height:40px;left:350px;top:70px;"><span class="glyphicon glyphicon-refresh" style="font-size:30px;color:#8e8c8c"></span></div>
                        <div id="Mychangething" style="width:300px;height:180px;position:absolute;right:40px;top:0px ;">

                        </div>
                    </div>
                    <div id="CharMyThing" style="width:100%;height:800px;overflow-x:auto;background-color:white;">
                        <%foreach (ThingToThingModel.ShopThingModel stm in shopthing)
                            { %>
                         <div class="MyThing">
                            <div class="MyThingImg">
                                <%for(int i=0;i<shopimgurl.Count;i++)
                                    {
                                        if (shopimgurl[i].ThingId == stm.ThingId)
                                        {%>
                                         <img src="<%=shopimgurl[i].ImgUrl %>""/>
                                       <%}
                                           } %>
                            </div>
                            <div class="MyThingName"><%=stm.ThingName %></div>
                            <div class="MyThingType"><%=stm.ThingType %></div>
                            <div class="Time">Time:</div>
                            <div class="MyThingTime"><%=stm.ThingTime %></div>
                            <div class="MyThingbtn btn btn-default"><span class="glyphicon glyphicon-plus"></span></div>
                             <input class="MyThingid" type="hidden" value="<%=stm.ThingId %>""/>
                        </div>
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
