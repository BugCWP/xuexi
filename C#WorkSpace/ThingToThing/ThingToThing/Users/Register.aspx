<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="ThingToThing.Users.Register" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../CSS/Registered.css" rel="stylesheet" />
    <link href="../CSS/MainMaster.css" rel="stylesheet" />
    <script src="../JS/jquery-3.2.1.min.js"></script>
    <script src="../JS/Registered.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <div class="container-fluid" id="mainbody" >
              <div id="headmenu" class="row">
                <div class="col-lg-2">
                    <div style="position: relative; top: 35px; left: 50px;">
                        <a style="font-size: 35px; color: white; text-decoration: none; font-weight: 800">物to物</a>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div style="position: relative; top: 60px; left: -60px">
                        <span style="font-size: 10px; color: white;">加入物物交换，让物尽其用</span>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div style="position: relative; top: 45px;">
                        <a style="text-decoration: none; color: white; font-size: 23px" href="../Views/HomePage.aspx">首页</a>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div style="position: relative; top: 45px;">
                        <a style="text-decoration: none; color: white; font-size: 23px">我的物品</a>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div style="position: relative; top: 45px;">
                        <a style="text-decoration: none; color: white; font-size: 23px; position: relative; left: -60px">我的订单</a>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div class="glyphicon glyphicon-shopping-cart" id="ShopChat" style="font-size: 27px; color: white; position: relative; top: 40px; left: 70px;"></div>
                </div>
                <div class="col-lg-2">
                    <div id="LoginMenu" style="color: white; position: relative; top: 50px; left: 20px;">
                        <a style="text-decoration: none; color: white">你好请登陆</a> |
                        <a href="../Users/Registered.aspx" style="text-decoration: none; color: white">免费注册</a>
                    </div>
                </div>
            </div>  

            </div>
            <div id="RegisteredMain">
        <div id="Registeredbox">
            <div id="Registeredhead">
                <p class="text-center" id="Registeredtitle">欢迎注册</p>
            </div>
            <div id="Resgisteredinput">
               <div class="form-group">
                   <label for="UserLoginId">用户账号：</label>
                   <input class="form-control" id="UserLoginId" type="text" name="UserLoginId" placeholder="ID" value="<%=UserLoginId %>""/> 
                  
                   <span id="TiShiUserLoginId" style="position:absolute;left:80%;top:215px;font-size:21px;"></span> 
                   <input type="hidden" id="IdHidden" name="IdHidden"/>
               </div>
               
                <div class="form-group">
                    <label for="UserName">用户姓名：</label>
                    <input class="form-control" id="UserName" type="text" name="UserName" placeholder="Name" value="<%=UserName %>""/>
                     <span id="TiShiUserName" style="position:absolute;left:80%;top:295px;font-size:21px;"></span>
                </div>
                <div class="form-group">
                    <label for="UserPwdOne">用户密码：</label>
                    <input class="form-control" id="UserPwdOne" type="password" name="UserPwdOne" placeholder="Password" value="<%=UserPwdOne %>""/>
                    <span id="TiShiUserPwdOne" style="position:absolute;left:80%;top:375px;font-size:21px;"></span>
                </div>
                 <div class="form-group">
                    <label for="UserPwdTwo">确认密码：</label>
                    <input class="form-control" id="UserPwdTwo" type="password" name="UserPwdTwo" placeholder="PasswordAgain" value="<%=UserPwdTwo %>""/>
                      <span id="TiShiUserPwdTwo" style="position:absolute;left:80%;top:450px;font-size:21px;"></span>
                </div>
                 <div class="form-group">
                    <label for="UserEmail">用户邮箱：</label>
                    <input class="form-control" id="UserEmail" type="text" name="UserEmail" placeholder="EmailNumber" value="<%=UserEmail %>""/>
                      <span id="TiShiUserEmail" style="position:absolute;left:80%;top:530px;font-size:21px;"></span>
                </div>
                 <div class="form-group">
                    <label for="UserPhone">用户电话：</label>
                     <input class="form-control" id="UserPhone" type="text" name="UserPhone" placeholder="PhoneNumber" value="<%=UserPhone %>""/>
                     <span id="TiShiUserPhone" style="position:absolute;left:80%;top:610px;font-size:21px;"></span>
                 </div>
                <div class="form-group">
                    <label for="UserAdressProvince">地址</label>
                    <div id="adress" class="form-inline">
                        <select class="form-control" id="UserAdressProvince" name="UserAdressProvince" >
                            <option value="省" selected="selected">省</option>
                           
                            <%listProvince.ForEach((x) =>
                                {%>
                                   <option value="<%=x.province %>""><%=x.province %></option>
                            <% }); %>
                        </select>
                        <select class="form-control" id="UserAdressCity" name="UserAdressCity">
                            <option value="市" selected="selected">市</option>
                        </select>
                    </div>
                    <textarea class="form-control" rows="3" id="UserAdressDetailed" name="UserAdressDetailed" placeholder="具体地址" ></textarea>
                     <span id="UserAdress" style="position:absolute;left:80%;top:750px;font-size:21px;"></span>
                </div>

            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-default" value="注册" id="btn-Registered" />
                <input type="button" class="btn btn-danger" value="清空" id="btn-Clear" />
            </div>
            <div style="position:relative;left:200px;top:-680px; color:#ff0800;font-size:20px;">
               <%=Res %>
            </div>
        </div>
    </div>
              <div id="foot">
                <div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
