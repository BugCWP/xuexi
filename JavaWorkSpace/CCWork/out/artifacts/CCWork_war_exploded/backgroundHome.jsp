<%--
  Created by IntelliJ IDEA.
  User: 30277
  Date: 2018/11/7
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
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
    <script type="text/javascript" src="js/backgroundHome.js"></script>
    <link type="text/css" rel="stylesheet" href="css/backgroundHome.css">
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
                                <span class="avatar" style="background-image: url()" id="personalheadpicture"></span>
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
        <div class="my-3 my-md-5">
            <div class="container">
                <div class="page-header">
                    <h1 class="page-title">
                        控制面板
                    </h1>
                </div>
                <div class="row row-cards">
                    <div class="col-6 col-sm-4 col-lg-2">
                        <div class="card">
                            <div class="card-body p-3 text-center">
                                <div class="h1 m-0" id="onlineResidentCount">0</div>
                                <div class="text-muted mb-4">在线人数</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-4 col-lg-2">
                        <div class="card">
                            <div class="card-body p-3 text-center">
                                <div class="h1 m-0" id="onlineResidentCountToday">0</div>
                                <div class="text-muted mb-4">今日访问量</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-4 col-lg-2">
                        <div class="card">
                            <div class="card-body p-3 text-center">
                                <div class="h1 m-0" id="residentCount">0</div>
                                <div class="text-muted mb-4">用户数</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-4 col-lg-2">
                        <div class="card">
                            <div class="card-body p-3 text-center">
                                <div class="h1 m-0" id="announcementCount">0</div>
                                <div class="text-muted mb-4">公告数</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-4 col-lg-2">
                        <div class="card">
                            <div class="card-body p-3 text-center">
                                <div class="h1 m-0" id="commentCount">0</div>
                                <div class="text-muted mb-4">评论数</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-4 col-lg-2">
                        <div class="card">
                            <div class="card-body p-3 text-center">
                                <div class="h1 m-0" id="communityCount">0</div>
                                <div class="text-muted mb-4">社区数</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="tablebox">
            <div id="tablebtnbox" class="selectgroup w-19">
                <label class="selectgroup-item">
                    <input type="radio" name="value" value="50" class="selectgroup-input" checked>
                    <span class="selectgroup-button" id="tablecommunitybtn">社区</span>
                </label>
                <label class="selectgroup-item">
                    <input type="radio" name="value" value="50" class="selectgroup-input">
                    <span id="tableresidentbtn" class="selectgroup-button">居民</span>
                </label>
                <label class="selectgroup-item">
                    <input type="radio" name="value" value="50" class="selectgroup-input">
                    <span id="tablepermissionbtn" class="selectgroup-button">权限</span>
                </label>
                <label class="selectgroup-item">
                    <input type="radio" name="value" value="50" class="selectgroup-input">
                    <span id="tableannouncementbtn" class="selectgroup-button">公告</span>
                </label>
                <label class="selectgroup-item">
                    <input type="radio" name="value" value="50" class="selectgroup-input">
                    <span id="tablecommentbtn" class="selectgroup-button">评论</span>
                </label>
            </div>
            <div id="tablecommunity">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">社区管理</h3>
                            <div class="input-group" style="position: absolute;right: 20px;top: 10px;height: 35px;width: 200px">
                                <input type="text" class="form-control" placeholder="根据名称搜索" id="communityTitle">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" id="communitySearch"><i class="fe fe-search" style="cursor: pointer"></i></button>
                                </span>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap">
                                <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>名称</th>
                                    <th>地址</th>
                                    <th>介绍</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody id="communityBody">
                                <%--这里添加社区表信息--%>

                                </tbody>
                            </table>
                        </div>
                        <div style="height: 100px"></div>
                        <div class="btn-list" style="position:absolute;bottom: 20px;right: 10px">
                            <a class="btn btn-secondary" id="communitylastpage"><i class="fe fe-arrow-left"></i></a>
                            <span id="communityPageBtnNumber" style="position: relative;top: -2px;margin-right: 5px"></span>
                            <a class="btn btn-secondary" id="communitynextpage"><i class="fe fe-arrow-right"></i></a>
                            <a class="btn btn-secondary" >总页数:<span id="communityPageSize"></span></a>
                            <a class="btn btn-secondary">总条数:<span id="communityTotalCount"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="tableresident">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">居民管理</h3>
                            <div class="ml-auto"></div>

                            <div class="input-group" style="position: relative;top: 0px;height: 40px;width: 550px">
                                <select class="custom-select" style="height: 40px;width: 30px;" id="ResidentDeleteOrStay">
                                    <option value="1" selected="true">正常</option>
                                    <option value="0">冻结</option>
                                </select>
                                <select class="custom-select" style="height: 40px;width: 100px" id="ResidentCommunityList">
                                    <option value="" selected="true">All Coummunity</option>
                                </select>
                                <select class="custom-select" style="height: 40px"id="ResidentFindType">
                                    <option value="" selected="true">无类型</option>
                                    <option value="residentName">姓名</option>
                                    <option value="residentAge">年龄</option>
                                    <option value="residentEmaill">邮箱</option>
                                    <option value="residentPhone">电话</option>
                                    <option value="residentAdress">住址</option>
                                </select>
                                <input type="text" class="form-control" placeholder="根据类型信息搜索" style="width: 130px" id="ResidentText">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" style="height: 40px" id="residentSearch"><i class="fe fe-search" style="cursor: pointer"></i></button>
                                </span>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap">
                                <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>姓名</th>
                                    <th>年龄</th>
                                    <th>社区</th>
                                    <th>邮箱</th>
                                    <th>电话</th>
                                    <th>住址</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody id="residentBody">
                                <%--这里添加社区表信息--%>

                                </tbody>
                            </table>
                        </div>
                        <div style="height: 100px"></div>
                        <div class="btn-list" style="position:absolute;bottom: 20px;right: 10px">
                            <a class="btn btn-secondary" id="residentlastpage"><i class="fe fe-arrow-left"></i></a>
                            <span id="residentPageBtnNumber" style="position: relative;top: -2px;margin-right: 5px"></span>
                            <a class="btn btn-secondary" id="residnetnextpage"><i class="fe fe-arrow-right"></i></a>
                            <a class="btn btn-secondary" >总页数:<span id="residentPageSize"></span></a>
                            <a class="btn btn-secondary">总条数:<span id="residentTotalCount"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="tablepermission">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">管理人员</h3>
                            <div class="input-group" style="position: absolute;top: 10px;height: 40px;width: 550px;right: 10px">
                                <select class="custom-select" style="height: 40px"id="permissionFindType">
                                </select>
                                <input type="text" class="form-control" placeholder="根据姓名搜索" style="width: 130px" id="permissionText">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" style="height: 40px" id="permissionSearch"><i class="fe fe-search" style="cursor: pointer"></i></button>
                                </span>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap">
                                <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody id="permissionBody">
                                <%--这里添加社区表信息--%>

                                </tbody>
                            </table>
                        </div>
                        <div style="height: 100px"></div>
                        <div class="btn-list" style="position:absolute;bottom: 20px;right: 10px">
                            <a class="btn btn-secondary" id="permissionlastpage"><i class="fe fe-arrow-left"></i></a>
                            <span id="permissionPageBtnNumber" style="position: relative;top: -2px;margin-right: 5px"></span>
                            <a class="btn btn-secondary" id="permissionnextpage"><i class="fe fe-arrow-right"></i></a>
                            <a class="btn btn-secondary" >总页数:<span id="permissionPageSize"></span></a>
                            <a class="btn btn-secondary">总条数:<span id="permissionTotalCount"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="tableannouncement">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">公告管理</h3>
                            <div class="input-group" style="position: absolute;top: 10px;height: 40px;width: 550px;right: 10px">
                                <select class="custom-select" style="height: 40px;width: 30px;" id="announcementDeleteOrStay">
                                    <option value="1" selected="true">正常</option>
                                    <option value="0">屏蔽</option>
                                </select>
                                <select class="custom-select" style="height: 40px"id="announcementFindType">
                                    <option value="" selected="true">无类型</option>
                                    <option value="announcementTitle">标题</option>
                                    <option value="announcementTime">时间</option>
                                    <option value="announcementResident">发布者</option>
                                </select>
                                <input type="text" class="form-control" placeholder="根据类型信息搜索" style="width: 130px" id="announcementText">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" style="height: 40px" id="announcementSearch"><i class="fe fe-search" style="cursor: pointer"></i></button>
                                </span>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap">
                                <thead>
                                <tr>
                                    <th>标题</th>
                                    <th>文章</th>
                                    <th>时间</th>
                                    <th>发布者</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody id="announcementBody">
                                <%--这里添加社区表信息--%>

                                </tbody>
                            </table>
                        </div>
                        <div style="height: 100px"></div>
                        <div class="btn-list" style="position:absolute;bottom: 20px;right: 10px">
                            <a class="btn btn-secondary" id="announcementlastpage"><i class="fe fe-arrow-left"></i></a>
                            <span id="announcementPageBtnNumber" style="position: relative;top: -2px;margin-right: 5px"></span>
                            <a class="btn btn-secondary" id="announcementnextpage"><i class="fe fe-arrow-right"></i></a>
                            <a class="btn btn-secondary" >总页数:<span id="announcementPageSize"></span></a>
                            <a class="btn btn-secondary">总条数:<span id="announcementTotalCount"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="tablecomment">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">评论管理</h3>
                            <div class="input-group" style="position: absolute;top: 10px;height: 40px;width: 550px;right: 10px">
                                <select class="custom-select" style="height: 40px;width: 30px;" id="commentDeleteOrStay">
                                    <option value="1" selected="true">正常</option>
                                    <option value="0">屏蔽</option>
                                </select>
                                <select class="custom-select" style="height: 40px"id="commentFindType">
                                    <option value="" selected="true">无类型</option>
                                    <option value="announcementTitle">公告标题</option>
                                    <option value="commentTime">时间</option>
                                    <option value="commentResident">发布者</option>
                                </select>
                                <input type="text" class="form-control" placeholder="根据类型信息搜索" style="width: 130px" id="commentText">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" style="height: 40px" id="commentSearch"><i class="fe fe-search" style="cursor: pointer"></i></button>
                                </span>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap">
                                <thead>
                                <tr>
                                    <th>公告标题</th>
                                    <th>评论内容</th>
                                    <th>时间</th>
                                    <th>发布者</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody id="commentBody">

                                </tbody>
                            </table>
                        </div>
                        <div style="height: 100px"></div>
                        <div class="btn-list" style="position:absolute;bottom: 20px;right: 10px">
                            <a class="btn btn-secondary" id="commentlastpage"><i class="fe fe-arrow-left"></i></a>
                            <span id="commentPageBtnNumber" style="position: relative;top: -2px;margin-right: 5px"></span>
                            <a class="btn btn-secondary" id="commentnextpage"><i class="fe fe-arrow-right"></i></a>
                            <a class="btn btn-secondary" >总页数:<span id="commentPageSize"></span></a>
                            <a class="btn btn-secondary">总条数:<span id="commentTotalCount"></span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
