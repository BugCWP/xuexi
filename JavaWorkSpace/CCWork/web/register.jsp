<%--
  Created by IntelliJ IDEA.
  User: 30277
  Date: 2018/11/1
  Time: 15:17
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
    <link rel="icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" type="image/x-icon" href="./favicon.ico" />
    <!-- Generated: 2018-04-06 16:27:42 +0200 -->
    <title>注册</title>
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
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body class="">
<div class="page">
    <div class="page-single">
        <div class="container">
            <div class="row">
                <div class="col col-login mx-auto">
                    <div class="text-center mb-6">
                        <%--<img src="./assets/brand/tabler.svg" class="h-6" alt="">--%>
                    </div>
                    <form class="card" action="/resident/register" method="post">
                        <div class="card-body p-6">
                            <div class="card-title">注册新用户</div>
                            <div class="form-group">
                                <label class="form-label">姓名</label>
                                <input type="text" class="form-control" placeholder="Enter name" name="residentName" id="residentName">
                            </div>
                            <div class="form-group">
                                <label class="form-label">邮箱</label>
                                <input type="email" class="form-control" placeholder="Enter email" name="residentAccount" id="residentAccount">
                            </div>
                            <div class="form-group">
                                <label class="form-label">密码</label>
                                <input type="password" class="form-control" placeholder="Enter Password" name="residentPassword" id="residentPassword">
                            </div>
                            <div class="form-group">
                                <label class="form-label">所在社区</label>
                                <select class="form-control custom-select" name="residentCommunity" id="residentCommunity">
                                       <option disabled="true" selected="true">Select community</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="agreecb"/>
                                    <span class="custom-control-label">同意 <a href="terms.jsp">条款和政策</a></span>
                                </label>
                            </div>
                            <div class="form-footer">
                                <button type="submit" class="btn btn-primary btn-block" disabled="true" id="registerbtn">注册</button>
                            </div>
                        </div>
                    </form>
                    <div class="text-center text-muted">
                        已有账号 <a href="login.jsp">登陆</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
