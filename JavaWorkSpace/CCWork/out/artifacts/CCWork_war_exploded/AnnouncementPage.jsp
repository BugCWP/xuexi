<%@ page import="com.cwp.entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.cwp.entity.Resident" %>
<%@ page import="com.cwp.entity.Picture" %><%--
  Created by IntelliJ IDEA.
  User: 30277
  Date: 2018/11/15
  Time: 15:34
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

    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/announcementPage.js"></script>
    <link href="/css/announcementPage.css" rel="stylesheet" type="text/css">
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
                                    <%--<span class="avatar mr-3 align-self-center" style="background-image: url()"></span>--%>
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
                                <a class="nav-link" id="homeDemo" href="/Home.jsp"><i class="fe fe-home"></i> Home</a>
                            </li>
                            <%--<li class="nav-item">--%>
                                <%--<a class="nav-link" id="chartDemo" href="/Chart.jsp"><i class="fe fe-message-circle"></i>Chart</a>--%>
                            <%--</li>--%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
             <div id="announcemetBox">
                     <div class="card announcementDemolow">
                         <div class="card-body d-flex flex-column">
                             <div class="d-flex align-items-center pt-5 mt-auto">
                                 <div class="avatar avatar-md mr-3" style="background-image: url(<%=request.getAttribute("announcementresidentpicture")%>)"></div>
                                 <div>
                                     <a class="text-default"><%=request.getAttribute("announcementresidentname")%></a>
                                     <small class="d-block text-muted"><%=request.getAttribute("announcementtime")%></small>
                                 </div>
                             </div>
                             <h4><a><%=request.getAttribute("announcementtitle")%></a></h4>
                             <div class="text-muted">
                                 <%=request.getAttribute("announcementtable")%>
                             </div>
                             <%
                                 List<Picture> pictureList=(List<Picture>) request.getAttribute("announcementPicture");
                             %>
                             <div class="row gutters-sm">
                                 <%
                                     if (pictureList!=null){
                                         for (Picture p:pictureList){
                                 %>
                                 <img class="imagecheck-img picture" src="<%=p.getPictureUrl()%>">
                                 <%
                                     }
                                   }
                                 %>
                             </div>
                         </div>
                     </div>
             </div>
            <div id="inputComment">
                <div class="card">
                <div class="card-header">
                    <h3 class="card-title">评论区</h3>
                </div>
                <div class="card-body">
                    <input type="hidden" id="announcementId" value="<%=request.getAttribute("announcementId")%>">
                    <textarea id="commenttext" class="form-control" type="text" placeholder="请输入你的评论"></textarea><br>
                    <a class="btn btn-primary" style="width: 80px;color: white" id="commenttextbtn">发送评论</a>
                </div>
                </div>
            </div>
            <div id="commentlist">
                <%
                    List<Map> list=(List<Map>) request.getAttribute("maplist");
                    for (Map map:list
                         ) {
                        Resident r=(Resident) map.get("resident");
                        Comment c=(Comment)map.get("comment");
                        Picture p=(Picture)map.get("picture");
                %>
                <div class="card">
                    <div class="card-body d-flex flex-column">
                        <div class="d-flex align-items-center pt-5 mt-auto">
                            <div class="avatar avatar-md mr-3" style="background-image: url(<%=p.getPictureUrl()%>)"></div>
                            <div>
                                <a class="text-default"><%=r.getResidentName()%></a>
                                <small class="d-block text-muted"><%=c.getCommentTime()%></small>
                            </div>
                        </div>
                        <div class="text-muted">
                            <%=c.getCommentTable()%>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
    </div>
</div>
</div>
</body>
</html>
