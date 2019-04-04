<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="HomePage.aspx.cs" Inherits="ThingToThing.Views.HomePage" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
     <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="../CSS/MainMaster.css" rel="stylesheet" />
    <link href="../CSS/HomePage.css" rel="stylesheet" />
    <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../JS/jquery-3.2.1.min.js"></script>
    <script src="../JS/HomePage.js"></script>
    <script src="../JS/MainMaster.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
            <div id="selectmenu" class="row" >
                <div class="container">
                    <div class="row" >
                        <div class="col-lg-6">
                        </div>
                        <div class="col-lg-2">
                            <div id="NavMenu1" style="height: 40px;">
                                <div class="dropdown text-center">
                          
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-2">
                            <div id="NavMenu2" style="height: 40px;">
                                <div class="dropdown text-center">
                                  
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-lg-2">
                            <div class="input-group" style="position: relative; top: 5px; left: 100px">
                                <input type="text" class="form-control" aria-label="..." style="height: 30px; width: 200px;" />
                                <div class="input-group-btn">
                                    <button class="btn btn-default glyphicon glyphicon-search" type="button" style="height: 30px; width: 40px; position: relative; left: 5px;"></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="mian" class="row">
                <div id="mainPage">
                    <div id="mainGunDong">

                    </div>
                    <div id="mainShangping">
                        
                        <%foreach (ThingToThingModel.ShopThingModel shop in Shopthinglist)
                            { %>
                        <div class='mainShangPingthing'>
                            <div class='ShangPingImg'>
                                <%foreach (ThingToThingModel.ShopImgUrl imgurl in Shopurllist)
                                    {
                                        if (imgurl.ThingId == shop.ThingId)
                                        { %>
                                  <img src="<%=imgurl.ImgUrl %>"  />
                                  <input type="hidden" value="<%=shop.ThingId %>"/>
                                <%}
                                } %>
                            </div>
                            <div class='Thingname'><%=shop.ThingName %></div>
                            <div class='ThingType'><%=shop.ThingType %></div>
                            <div class="ThingJian"><%=shop.ThingIntroduction %></div>
                            <div class="Thingbtn btn btn-default" >添加交换</div>
                            <input value="<%=shop.UserId %>"" type="hidden" class="LoginIdjump"/>
                            <input type="hidden" value="<%=shop.ThingId %>" class="ThingIdjump"/>
                        </div>
                        <%} %>
                    </div>
                    
                </div>
               
            </div> 
            <div id="mainBianHao" class="row">
                <a id="pagebefore"  class="btn btn-default glyphicon glyphicon-chevron-left" style="font-size:30px;float:left" href="HomePage.aspx?PageIndx=<%=index - 1 < 1 ? 1 : index - 1 %>"></a>
                <div id="pagenumber" style="width:200px;height:60px;float:left;text-align:center">
                    <%if (PageCount - index >= 4)
                        {
                            for (int i = index; i <= index + 4; i++)
                            { %>
                    <a class="pagenumberbtn" href="HomePage.aspx?PageIndx=<%=i %>"><%=i %></a>
                    <%}
                        }
                        else
                        {
                            for (int i = index; i <= PageCount; i++)
                            {
                    %>
                    <a class="pagenumberbtn" href="HomePage.aspx?PageIndx=<%=i %>"><%=i %></a>
                    <%
                            }
                        }


                    %>
                </div>
                <a id="pagenext" class="btn btn-default glyphicon glyphicon-chevron-right" style="font-size: 30px;float:left " href="HomePage.aspx?PageIndx=<%=index+1>PageCount?PageCount:index+1 %>"></a>

                <input id="pageCount" type="text" style="width: 60px; border-radius: 5px; height: 60px;float:left;font-size:25px"value="<%=index %>"" />
                <a id="pagebtn" class="btn btn-default" style="font-size: 25px;float:left" href="HomePage.aspx?PageIndx=<%=index>PageCount?PageCount:index %>">确定</a>
           
            </div>
            <div id="foot" class="row">
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
