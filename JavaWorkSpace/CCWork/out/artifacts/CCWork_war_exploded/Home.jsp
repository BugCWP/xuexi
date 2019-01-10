<%@ page import="com.cwp.entity.Resident" %><%--
  Created by IntelliJ IDEA.
  User: 30277
  Date: 2018/11/6
  Time: 10:22
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
    <script type="text/javascript" src="js/home.js"></script>
    <link href="css/home.css" rel="stylesheet" type="text/css">
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
                                        <%--<span class="avatar mr-3 align-self-center" style="background-image: url(demo/faces/male/41.jpg)"></span>--%>
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
                                    <span class="avatar"  id="personalheadpicture"></span>
                                    <span class="ml-2 d-none d-lg-block">
                                         <span class="text-default" id="personalheadname">Jane Pearson</span>
                                         <small class="text-muted d-block mt-1" id="personalheadcommunity">Administrator</small>
                                    </span>
                                </a>
                                    <%--个人信息栏--%>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                    <a class="dropdown-item" href="/PersonalCenter.jsp">
                                        <i class="dropdown-icon fe fe-user"></i>个人信息
                                    </a>
                                    <a class="dropdown-item" href="/backgroundHome.jsp">
                                      <i class="dropdown-icon fe fe-settings"></i>网站管理
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
                                <li class="nav-item">
                                    <a class="nav-link" id="homeDemo" href="Home.jsp"><i class="fe fe-home"></i> Home</a>
                                </li>
                                <%--<li class="nav-item">--%>
                                    <%--<a class="nav-link" id="chartDemo" href="Chart.jsp"><i class="fe fe-message-circle"></i>Chart</a>--%>
                                <%--</li>--%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div id="uploadannouncement">
                    <div class="card">
                        <div class="card-body">
                            <form enctype="multipart/form-data" action="announcementpicture/addannouncement" method="post">
                                <label class="form-label">标题</label>
                                <input type="text" name="announcementTitle" class="form-control">
                                <label class="form-label">内容</label>
                                <textarea name="announcementTable" class="form-control" cols="5"></textarea>
                                <label class="form-label">图片</label>
                                <input name="upload" type="file" class="btn btn-primary" value="">
                                <input type="submit" value="发表" class="btn btn-primary">
                            </form>
                        </div>
                    </div>
                    <div id="downupload">
                        <i class="fe fe-chevron-down"></i>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="page-header"></div>
                 <div class="row row-cards row-deck" id="announcementBody">
                         <div class="col-lg-11">
                             <div class="card announcementDemolow">
                                     <div class="card-body d-flex flex-column">
                                         <h4><a>Title</a></h4>
                                        <div class="text-muted">
                                         tabledhaskjdkjasdjaksdjksajkdajskakshdjksajkdsakjdkjaksdhjaksdhsakjhdkjsadjsadhajshdjksakasd
                                         ashdjkashdkjsakhdjksadkjsakdsakjdjsakjdksakjhdjsakjdhjsadjskahdjkasjdksadkjsjadjsajdsakjdjsakdjk
                                         asdkjsahjdsakhdjsajdkjas
                                            ashdaisodasoidaisudiasoidasojldsajkdjsalkdlksajdlksajdksadaksl
                                            dsajlkdjsalkldasdada
                                        </div>
                                     <div class="d-flex align-items-center pt-5 mt-auto">
                                         <div class="avatar avatar-md mr-3" style="background-image: url(/noting.jpg)"></div>
                                         <div>
                                             <a class="text-default">name</a>
                                             <small class="d-block text-muted">time</small>
                                         </div>
                                     </div>
                                 </div>
                                 <div class="announcementdownbtn">
                                     <i class="fe fe-chevron-down"></i>
                                 </div>
                             </div>
                         </div>
                 </div>
            </div>
        </div>
    </div>
</body>
</html>
