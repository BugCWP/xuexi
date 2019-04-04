<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MyShop.aspx.cs" Inherits="ThingToThing.Views.MyShop" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../CSS/MyShop.css" rel="stylesheet" />
    <link href="../CSS/MainMaster.css" rel="stylesheet" />
    <script src="../JS/jquery-3.2.1.min.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../JS/jquery.cookie.js"></script>
    <script src="../JS/MainMaster.js"></script>
    <script src="../JS/MyShop.js"></script>
    <title></title>
</head>
<body>
    <form id="form1" runat="server" >
        <div>
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
                            <a style="text-decoration: none; color: white; font-size: 23px" href="../Views/MyShop.aspx">我的物品</a>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div style="position: relative; top: 45px;">
                            <a style="text-decoration: none; color: white; font-size: 23px; position: relative; left: -90px;cursor:pointer" href="MyOrder.aspx">我的订单</a>
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
                <div id="selectmenu" class="row">
                   <%-- <div class="container">
                        <div class="row">
                            <div class="col-lg-6">
                            </div>
                            <div class="col-lg-2">
                                <div id="NavMenu1" style="height: 40px;">
                                    <div class="dropdown text-center">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 15px; text-decoration: none; color: white; position: relative; top: 10px;">分类
                                        <span class="caret"></span>
                                        </a>
                                        <ul class="dropdown-menu" style="position: relative; top: 12px; background-color: black; color: white; border-radius: 0px;">
                                            <li>sds</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div id="NavMenu2" style="height: 40px;">
                                    <div class="dropdown text-center">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 15px; text-decoration: none; color: white; position: relative; top: 10px;">提示
                                        <span class="caret"></span>
                                        </a>
                                        <ul class="dropdown-menu" style="position: relative; top: 12px; background-color: black; color: white; border-radius: 0px;">
                                        </ul>
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
                    </div>--%>
                </div>
                <div id="shopmain" class="row">
                    <div id="Left">
                        <div id="LeftTianJia" class="Leftbtn" style="background-color:black"><a style="color:white">交换物品</a></div>
                        <div id="LeftLiShi" class="Leftbtn"><a>物品记录</a></div>
                        <div id="LeftSelf" class="Leftbtn"><a>个人信息</a></div>
                    </div>
                    <div id="rightTianJia">
                        <div id="ShopTianJia" class="rightpage" >
                            <%--<div class="ShopTianJiaing"></div>--%>
                            <div id="ShopTianJiabtn" style="cursor:pointer">

                                <span class="glyphicon glyphicon-plus" style="position: relative; left: 100px; top: 120px; font-size: 50px; color: rgba(0, 0, 0, 0.50)"></span>
                               
                            </div>
                            <div style="position:absolute;width:60px;top:25%;right:15px;border-radius:20px;background-color:black;text-align:center">
                                <div id="pageup" class="glyphicon glyphicon-menu-up" style="width:40px;height:40px;color:white;font-size:40px;cursor:pointer"></div>
                                <div id="pagebtn"></div>
                                <div id="pagedown" class="glyphicon glyphicon-menu-down"style="width:40px;height:40px;color:white;font-size:40px;cursor:pointer"></div>
                            </div>
                        </div>
                        <div id="ShopLiShi" class="rightpage" style="display:none;overflow:scroll">
                            <%--<div class="ShopLiShibtn">
                                <input type='hidden' />
                                <div class="ShopLiShiimg"></div>
                                <div class="ShopLiShiName">name</div>
                                <div class="ShopLiShiType">Type</div>
                                <div class="ShopLiShiTimetext">上传时间:</div>
                                <div class="ShopLiShiTime">time</div>
                                <div class="ShopLiShiDeleteZhuangtai">物品状态：</div>
                                <div class="ShopLiShiDelete">1</div>
                                <div class="btn btn-default ShopLiShiXiangQing">详情</div>
                            </div>--%>
                        </div>
                        <div id="ShopSelf" class="rightpage" style="display:none;">
                            <div style="width:700px;height:650px;background-color:white;position:relative;left:400px;top:0px;">
                               
                                <div class="form-group" style="margin-top:50px;font-size:20px;width:500px;margin-left:100px;position:relative;top:30px;">
                                    <table for="ChangeName">用户姓名:</table>
                                    <input class="form-control" type="text" id="ChangeName"  value="<%=UName %>""/>
                                </div>
                                <div class="form-group" style="margin-top:30px;font-size:20px;width:500px;margin-left:100px;position:relative;top:30px;">
                                    <table for="ChangePwd">用户密码:</table>
                                    <input class="form-control" type="password" id="ChangePwd" value="<%=UPwd %>""/>
                                </div>
                                <div class="form-group" style="margin-top:30px;font-size:20px;width:500px;margin-left:100px;position:relative;top:30px;">
                                    <table for="ChangePhone">用户电话:</table>
                                    <input class="form-control"type="text" id="ChangePhone" value="<%=UPhone %>""/>
                                </div>
                                <div class="form-group" style="margin-top:30px;font-size:20px;width:500px;margin-left:100px;position:relative;top:30px;">
                                    <table for="ChangeEmail">用户邮箱:</table>
                                    <input class="form-control"type="text" id="ChangeEmail" value="<%=UEmail %>"" />
                                </div>
                                <div class="form-group" style="margin-top:30px;font-size:20px;width:500px;margin-left:100px;position:relative;top:30px;">
                                    <table for="ChangeAdress">用户地址:</table>
                                   <textarea id="ChangeAdress" class="form-control" rows="4"><%=UAdress %></textarea>
                                </div>
                                <input  id="ChangeUser" type="button" class="btn btn-default" style="width:300px;position:relative;left:200px;top:50px" value="提交修改"/>
                                <input id="UID" type="hidden" value="<%=UId %>""/>
                            </div>
                        </div>
                    </div>
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
                            <%--<label for="LoginUserId">账号</label>--%>
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
        <div id="TianJiapage">
            <div id="TianJiapageClose" style="font-size:25px;background-color:black;border-radius:50%;width:50px;height:50px;color:white;position:absolute;right:30px;top:20px;z-index:1000;cursor:pointer"><span class="glyphicon glyphicon-remove" style="margin-left:12px;margin-top:12px;"></span></div>
            <div id="ThingImgpage">
                <div id="ThingImgJia" style="position:absolute;left:100px;top:50px;width:700px;">
                   
                </div>
                <div id="ThingImgKuang" style="width:400px;height:400px;position:absolute;left:180px;top:300px;">
                    <img src="../Images/start.png" id="ThingImgShow"style="width:400px;height:400px;"/>
                </div>
            </div>
            <div id="ThingXiaoXi">
                <div id="ThingXiaoXiInput">
                    <div class="form-group">
                        <lable for="Thingname" style="font-size: 20px;">物品名称</lable>
                        <input type="text" class="form-control" id="Thingname" style="width: 450px;" placeholder="ThingName" />
                    </div>
                    <br />
                    <div class=" form-group">
                        <lable for="ThingType" style="font-size: 20px">物品种类</lable>
                        <select class="form-control" id="ThingType" style="width: 450px;">
                            <option>TypeTitle</option>
                        </select>
                    </div>
                    <br />
                    <div class="form-group">
                        <label for="ThingImgFile" style="font-size: 20px; font-weight: 500">物品图片</label>
                        <input type="file" class="form-control" id="TingImgFile" style="width: 450px; height: 50px;" />
                    </div>
                    <br />
                    <div class="form-group">
                        <label for="ThingIntroduction" style="font-size: 20px; font-weight: 500">物品简介</label>
                        <textarea id="ThingIntroduction" class="form-control" rows="7" style="width: 450px;" placeholder="ThingIntroduction">

                        </textarea>
                    </div>
                    <br />
                    <br />
                    <input class="btn btn-default" type="button" id="ThingTiJiaobtn" value="确认添加" style="font-size: 20px; margin-left: 140px; width: 200px; text-align: center" />
                </div>
            </div>
        </div>
        <div id="ThingXiuGaipage">
            <div id="XiuGaiLeft">
                <div id="XiuGaiimg">

                </div>
            </div>
            <div id="XiuGaiRight">
                <div id="XiuGaiinpt">
                    <div class="form-group">
                        <lable for="XiuGainame" style="font-size: 20px;">物品名称</lable>
                        <input type="text" class="form-control" id="XiuGainame" style="width: 450px;" placeholder="ThingName" value="" />
                    </div>
                    <br />
                    <div class=" form-group">
                        <lable for="XiuGaiType" style="font-size: 20px">物品种类</lable>
                        <select class="form-control" id="XiuGaiType" style="width: 450px;">
                            <option>TypeTitle</option>
                        </select>
                    </div>
                    <br />
                    <div class="form-group">
                        <label for="XiuGaiImgFile" style="font-size: 20px; font-weight: 500">物品图片</label>
                        <input type="file" class="form-control" id="XiuGaiImgFile" style="width: 450px; height: 50px;" />
                    </div>
                    <br />
                    <div class="form-group">
                        <label for="XiuGaiIntroduction" style="font-size: 20px; font-weight: 500">物品简介</label>
                        <textarea id="XiuGaiIntroduction" class="form-control" rows="7" style="width: 450px;" placeholder="ThingIntroduction">

                        </textarea>
                    </div>
                    <br />
                    <br />
                    <input type="hidden" id="XiuGaiId" value=""/>
                    <input class="btn btn-default" type="button" id="XiuGaiTiJiaobtn" value="确认修改" style="font-size: 20px; margin-left: 140px; width: 200px; text-align: center" />
                </div>
                <div id="XiuGaiClose" style="width:40px;height:40px;background-color:black;border-radius:50%;z-index:1000;position:relative;left:650px;top:-550px;">
                    <span class="glyphicon glyphicon-remove" style="color:white;font-size:25px;margin-left:8px;margin-top:8px;"></span>

                </div>
            </div>
           
        </div>
    </form>
</body>
</html>
