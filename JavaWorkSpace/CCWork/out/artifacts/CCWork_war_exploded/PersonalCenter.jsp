<%--
  Created by IntelliJ IDEA.
  User: 30277
  Date: 2018/11/12
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Language" content="en" />
    <meta name="msapplication-TileColor" content="#2d89ef">
    <meta name="theme-color" content="#4188c9">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <link rel="icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" />
    <!-- Generated: 2018-04-06 16:27:42 +0200 -->
    <title>Empty page - tabler.github.io - a responsive, flat and full featured admin template</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <script src="/assets/js/require.min.js"></script>
    <script>
        requirejs.config({
            baseUrl: '.'
        });
    </script>
    <!-- Dashboard Core -->
    <link href="/assets/css/dashboard.css" rel="stylesheet" />
    <script src="/assets/js/dashboard.js"></script>
    <!-- c3.js Charts Plugin -->
    <link href="/assets/plugins/charts-c3/plugin.css" rel="stylesheet" />
    <script src="/assets/plugins/charts-c3/plugin.js"></script>
    <!-- Google Maps Plugin -->
    <link href="/assets/plugins/maps-google/plugin.css" rel="stylesheet" />
    <script src="/assets/plugins/maps-google/plugin.js"></script>
    <!-- Input Mask Plugin -->
    <script src="/assets/plugins/input-mask/plugin.js"></script>

    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/java" src="js/jquery.ui.widget.js"></script>
    <script type="text/java" src="js/jquery.iframe-transport.js"></script>
    <script type="text/java" src="js/jquery.fileupload.js"></script>
    <script type="text/java" src="js/jquery.xdr-transport.js"></script>
    <script type="text/javascript" src="js/PersonalCenter.js"></script>
    <link rel="stylesheet" type="text/css" href="css/PersonalCenter.css">
</head>
<body class="">
<div class="page">
    <div class="page-main">
        <div class="header py-4"> <%--第一条头--%>
            <div class="container">
                <div class="d-flex">
                    <a class="header-brand" href="/Home.jsp">
                        <img src="/demo/brand/tabler.svg" class="header-brand-img" alt="tabler logo">
                    </a>
                    <div class="d-flex order-lg-2 ml-auto">
                        <%--消息通知--%>
                        <%--<div class="dropdown d-none d-md-flex">--%>
                            <%--<a class="nav-link icon" data-toggle="dropdown">--%>
                                <%--<i class="fe fe-bell"></i>--%>
                                <%--&lt;%&ndash;有没有消息的标记小红点&ndash;%&gt;--%>
                                <%--<span class="nav-unread"></span>--%>
                            <%--</a>--%>
                            <%--<div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">--%>
                                <%--&lt;%&ndash;收到的消息&ndash;%&gt;--%>
                                <%--<a href="#" class="dropdown-item d-flex">--%>
                                    <%--<span class="avatar mr-3 align-self-center" style="background-image: url(noting.jpg)"></span>--%>
                                    <%--<div>--%>
                                        <%--<strong>Nathan</strong> pushed new commit: Fix page load performance issue.--%>
                                        <%--<div class="small text-muted">10 minutes ago</div>--%>
                                    <%--</div>--%>
                                <%--</a>--%>
                                <%--<div class="dropdown-divider"></div>--%>
                                <%--<a href="#" class="dropdown-item text-center text-muted-dark">全部设为已读</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="dropdown">
                            <%--个人信息展示--%>
                            <a href="#" class="nav-link pr-0 leading-none" data-toggle="dropdown">
                                <span class="avatar" style="background-image: url(/noting.jpg)" id="personalheadpicture"></span>
                                <span class="ml-2 d-none d-lg-block">
                                         <span class="text-default" id="personalheadname">Jane Pearson</span>
                                         <small class="text-muted d-block mt-1" id="personalheadcommunity">Administrator</small>
                                    </span>
                            </a>
                            <%--个人信息栏--%>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                <a class="dropdown-item" href="/backgroundHome.jsp">
                                    <i class="dropdown-icon fe fe-settings"></i>网站管理
                                </a>
                                <a class="dropdown-item" href="/Home.jsp">
                                    <i class="dropdown-icon fe fe-globe"></i>网站游览
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/resident/loginout">
                                    <i class="dropdown-icon fe fe-log-out"></i> 退出
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="header collapse d-lg-flex p-0" id="headerMenuCollapse">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg order-lg-first">
                        <ul class="nav nav-tabs border-0 flex-column flex-lg-row">
                            <li class="nav-item" >
                                <a class="nav-link" id="residentbtn"><i class="fe fe-user"></i>个人中心</a>
                            </li>
                            <li class="nav-item">
                               <a class="nav-link" id="announcementbtn"><i class="fe fe-file-text"></i>个人公告</a>
                           </li>
                            <li class="nav-item">
                                <a class="nav-link" id="commentbtn"><i class="fe fe-message-circle"></i>个人评论</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div style="width: 100%">
            <div id="residentBody" class="showbody" style="display: block">
                <div style="width: 80%;position: relative;left: 10%;top: 20px;background-color: white;height: 400px">
                    <div style="position:relative;float: left;width: 35%;left: 10%" >
                        <div style="position: absolute;">
                            <img src="/noting.jpg" style="width: 100%;" id="residentPicture"/>
                        </div>
                    </div>
                    <div style="position: absolute;float: left;left: 50%;top: 30px;">
                        <div style="margin-bottom: 10px;font-size: 30px"><span id="residentName">cwp</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><i class="fe fe-home"></i><span id="residentCommunity" style="position: relative;left: 10px">阳光</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><i class="fe fe-briefcase"></i><span id="residentPermission" style="position: relative;left: 10px">社员</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><i class="fe fe-crosshair"></i><span id="residentAge" style="position: relative;left: 10px">1</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><i class="fe fe-phone"></i><span id="residentPhone" style="position: relative;left: 10px">21121</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><i class="fe fe-mail"></i><span id="residentEmail" style="position: relative;left: 10px">31321</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><i class="fe fe-map-pin"></i><span id="residentAdress" style="position: relative;left: 10px">13131</span></div>
                        <div style="margin-bottom: 10px;font-size: 17px"><button class="btn btn-primary" id="residentChangebtn">修改个人信息</button></div>
                    </div>
                </div>
            </div>
            <div id="residentChangeBody" class="showbody">
                <div style="width: 80%;position: relative;left: 10%;top: 20px;background-color: white;height: 650px">
                    <div style="position:relative;float: left;width: 35%;left: 10%" >
                        <div style="position: relative;">
                            <img src="C:\fakepath\rBACE1Pyt5aQ4EaZACFdoSRerRs948.jpg" style="width: 100%;" id="residentChangePicture"/>
                        </div>
                       <form action="picture/uploadpersonalpicture" method="post" enctype="multipart/form-data">
                            <input type="file" name="upload" value=""/>
                           <input type="submit" value="提交"/>
                       </form>
                        <div id="progress">
                            <div class="bar" style="width: 0%;"></div>
                        </div>
                    </div>
                    <div style="position: absolute;float: left;left: 50%;top: 30px;" class="card-body">
                        <div style="margin-bottom: 10px;font-size:17px" class="col-md-14">
                            <label >姓名</label>
                            <input id="residentChangeName" type="text" class="form-control">
                        </div>
                        <div style="margin-bottom: 10px;font-size: 17px" class="col-md-14">
                            <label >社区</label>
                            <select class="custom-select" id="residentChangeCommunity">

                            </select>
                        </div>
                        <div style="margin-bottom: 10px;font-size: 17px" class="col-md-14">
                            <label >年龄</label>
                            <input id="residentChangeAge" type="text" class="form-control">
                        </div>
                        <div style="margin-bottom: 10px;font-size: 17px" class="col-md-14">
                            <label >电话</label>
                            <input id="residentChangePhone" type="text" class="form-control">
                        </div>
                        <div style="margin-bottom: 10px;font-size: 17px" class="col-md-14">
                            <label >具体地址</label>
                            <input id="residentChangeAdress" type="text" class="form-control">
                        </div>
                        <div style="margin-bottom: 10px;font-size: 17px">
                            <div class="btn-list">
                                <button class="btn btn-success" id="residentChangeOK">提交</button>
                                <button class="btn btn-secondary" id="residentChangeNO">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="announcementBody" class="showbody">
                <div class="announcementbox card">
                    <div>
                        <div class="announcementTitle">Title</div>
                        <div class="announcementTime">time</div>
                        <div class="announcementText">Text</div>
                        <img src="noting.jpg" width="100" height="100">
                    </div>
                    <button class="btn btn-danger announcementDeletebtn"><i class="fe fe-trash-2"></i></button>
                    <div class="announcementCommentbox">
                        <div>
                            <span class="avatar avatar-lg announcementResidentAvatar" style="background-image: url(/noting.jpg)"></span>
                            <span class="announcementResidentName">name</span>
                            <span class="announcementCommentTime">time</span>
                        </div>
                        <div>
                            <div class="announcementCommentText">text</div>
                            <img src="noting.jpg" class="announcementCommentPicture" width="80px" height="80px">
                        </div>
                    </div>
                    <div class="announcementshowbtn">
                        <a><i class="fe fe-chevron-down"></i></a>
                    </div>
                </div>
            </div>
            <div id="commentBody" class="showbody">
                <div class="commentbox card">
                    <div class="commentPictureList">
                        <div class="commentText">text</div>
                        <img src="noting.jpg" class="commentPicture" width="80px" height="80px">
                    </div>
                    <div>
                        <span class="commentTime">time</span>
                        <button class="btn btn-danger commentDeletebtn"><i class="fe fe-trash-2"></i></button>
                    </div>
                    <div class="commentAnnouncementbox">
                        <div>
                            <span class="commentAnnouncementTitle">tiitle</span><br>
                            <span class="commentAnnouncementTime">time</span>
                        </div>
                        <div>
                            <div class="commentAnnouncementText">text</div>
                            <img src="noting.jpg" width="100" height="100" class="commentAnnouncementPicture">
                        </div>
                    </div>
                    <div class="commentshowbtn">
                        <a><i class="fe fe-chevron-down"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
