<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MyOrder.aspx.cs" Inherits="ThingToThing.Views.MyOrder" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="../CSS/MainMaster.css" rel="stylesheet" />
     <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../CSS/MyOrder.css" rel="stylesheet" />
    <script src="../JS/jquery-3.2.1.min.js"></script>
     <script src="../JS/MainMaster.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../JS/MyOrder.js"></script>
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
            <div id="MainOrder" class="row" style="overflow-y:auto">
                   <%-- <div class="myThing" style="position:relative;width:50%;height:150px;overflow-y:auto">
                        <div class="mythingimg" style="width:120px;height:120px;position:relative;top:30px;left:30px;background-color:red;float:left">
                            <img  style="width:120px;height:120px;"/>
                        </div>
                        <div class="mythingname" style="font-size:30px;position:relative;left:60px;top:50px;float:left;">name</div>
                         <div class="mythingtype" style="font-size:20px;position:relative;left:0px;top:80px;float:left;">type</div>
                        <div class="mythingtime" style="font-size:20px;position:relative;left:100px;top:80px;float:left;">time:</div>
                    </div>
                   <div class="changeThing" style="position:absolute;width:50%;height:780px;left:50%;top:100px;overflow-y:auto">
                       <div style="width:200px;height:280px;position:relative;left:20px;top:20px;float:left;background-color:greenyellow">
                           <div style="width:200px;height:180px"></div>
                           <div style="font-size:20px;position:relative;left:40px;">name</div>
                           <div style="font-size:15px;position:relative;left:40px;">type</div>
                           <div class="btn btn-default" style="font-size:15px;position:relative;left:60px;top:10px;width:80px;height:30px;">确认交换</div>
                       </div>
                   </div>--%>
                <%foreach (ThingToThingModel.ShopOrderModel som in somlist)
                    { %>
                   <div class="myThing" style="position:relative;width:50%;height:150px;cursor:pointer;margin-top:10px;margin-left:10px">
                        <div class="mythingimg" style="width:120px;height:120px;position:relative;top:10px;left:30px;background-color:red;float:left">
                           
                            <img style="width: 120px; height: 120px;" src="<%=som.MyThing.ThingfirstimgUrl %>"" />
                          
                        </div>
                        <div class="mythingname" style="font-size:30px;position:relative;left:60px;top:50px;float:left;"><%=som.MyThing.ThingName %></div>
                         <div class="mythingtype" style="font-size:20px;position:relative;left:0px;top:80px;float:left;"><%=som.MyThing.ThingType %></div>
                        <div class="mythingtime" style="font-size:20px;position:relative;left:100px;top:80px;float:left;"><%=som.MyThing.ThingTime %></div>
                        <div></div>
                    </div>
                   <div class="changeThing" style="position:absolute;width:50%;height:780px;left:50%;top:100px;overflow-y:auto;display:none">
                       <%foreach (ThingToThingModel.ShopThingModel changet in som.ChangeThing)
                           { %>
                       <div style="width:200px;height:280px;position:relative;left:50px;top:20px;float:left;border:1px solid black;">
                           <div style="width:180px;height:180px;margin-left:10px;">
                              
                               <img style="width:180px;height:180px;" src="<%=changet.ThingfirstimgUrl %>""/>
                              
                           </div>
                           <div style="font-size:20px;position:relative;left:40px;"><%=changet.ThingName %></div>
                           <div style="font-size:15px;position:relative;left:40px;"><%=changet.ThingType %></div>
                           <div class="btn btn-default jiaohuanbtn" style="font-size:13px;position:relative;left:60px;top:10px;width:100px;height:30px;" >确认交换</div>
                           
                           <input type="hidden" value="<%=changet.ThingId %>" class="input1"/>
                           <input type="hidden" value="<%=som.MyThing.ThingId %>" class="input2"/>
                       </div>
                       <%} %>
                   </div>
                <%} %>
                <%foreach (ThingToThingModel.ShopThingModel stm in stlist)
                    { %>
                   <div class="myThing" style="position:relative;width:50%;height:150px;cursor:pointer;margin-top:10px;margin-left:10px">
                        <div class="mythingimg" style="width:120px;height:120px;position:relative;top:10px;left:30px;background-color:red;float:left">
                           
                            <img style="width: 120px; height: 120px;" src="<%=stm.ThingfirstimgUrl %>"" />
                          
                        </div>
                        <div class="mythingname" style="font-size:30px;position:relative;left:60px;top:50px;float:left;"><%=stm.ThingName %></div>
                         <div class="mythingtype" style="font-size:20px;position:relative;left:0px;top:80px;float:left;"><%=stm.ThingType %></div>
                        <div class="mythingtime" style="font-size:20px;position:relative;left:100px;top:80px;float:left;"><%=stm.ThingTime %></div>
                       <div style="color:red;font-size:20px;position:relative;left:170px;top:80px;float:left;">发货中</div>
                        <div></div>
                    </div>
                <%} %>
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
