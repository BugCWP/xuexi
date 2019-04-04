$(function () {
    $.post("../Users/LoginSuccese.ashx", {}, function (data) {
        if (data == "") {

        } else {
            var name = data.UserName;
            $("#DengLu").css("display", "none");
            $("#ZhuCe").css("display", "none");
            $("#LoginMenuname").css("display", "inline");
            $("#ZhuXiao").css("display", "inline");
            $("#LoginMenuname").text(name);
        }

    }, "json");

    $("#NavMenu1").mouseover(function () {
        $("#NavMenu1").css("background-color", "black");
    });
    $("#NavMenu1").mouseout(function () {
        $("#NavMenu1").css("background-color", "rgba(0, 0, 0, 0.0)");
    });
    $("#NavMenu2").mouseover(function () {
        $("#NavMenu2").css("background-color", "black");
    });
    $("#NavMenu2").mouseout(function () {
        $("#NavMenu2").css("background-color", "rgba(0, 0, 0, 0.0)");
    });

    $("#Loginbtn").click(function () {
        var UserId = $("#LoginUserId").val();
        var Userpwd = $("#LoginUserPassword").val();
        $.post("../Users/Login.ashx", { "Id": UserId, "pwd": Userpwd }, function (data) {
            if (data == "1") {
                //用户名不存在
                $("#TiShiLoginId").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
                $("#TiShiLoginPwd").removeClass("glyphicon glyphicon-ok").remove("glyphicon glyphicon-remove").css("color", "white");
            }
            else if (data == "3") {
                //密码错误
                $("#TiShiLoginId").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
                $("#TiShiLoginPwd").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
            }
            else if (data == "2") {
                //登陆成功
                $.post("../Users/LoginSuccese.ashx", {}, function (data) {
                    var name = data.UserName;
                    $("#DengLu").css("display", "none");
                    $("#ZhuCe").css("display", "none");
                    $("#LoginMenuname").css("display", "inline");
                    $("#ZhuXiao").css("display", "inline");
                    $("#LoginMenuname").text(name);
                    $("#Logincloss").click();
                    window.location.href = "../Views/HomePage.aspx";
                }, "json");
            }
        });
    });

    $("#Logincloss").click(function () {
        $("#LoginUserId").val("");
        $("#LoginUserPassword").val("");
        $("#TiShiLoginId").removeClass("glyphicon glyphicon-ok").remove("glyphicon glyphicon-remove").css("color", "white");
        $("#TiShiLoginPwd").removeClass("glyphicon glyphicon-ok").remove("glyphicon glyphicon-remove").css("color", "white");
    });

    $("#ZhuXiao").click(function () {
        $.post("../Users/LoginZhuXiao.ashx", {}, function (data) {
            if (data == "1") {
                $("#DengLu").css("display", "inline");
                $("#ZhuCe").css("display", "inline");
                $("#LoginMenuname").css("display", "none");
                $("#ZhuXiao").css("display", "none");
                $("#LoginMenuname").text("");
            }
        });
    });

    $("#MyThingBtn").click(function () {
        $.post("../ashx/MyShopYanZheng.ashx", {}, function (data) {
            if (data == "1") {

                $("#DengLu").click();

            } else if (data == "2") {
                window.location.href = '../Views/MyShop.aspx';
            }
        });
    })
    $("#MyThingPage").click(function () {
        $.post("../ashx/MyShopYanZheng.ashx", {}, function (data) {
            if (data == "1") {

                $("#DengLu").click();

            } else if (data == "2") {
                window.location.href = '../Views/MyOrder.aspx';
            }
        });
    })

    $("#ShopChat").click(function () {
        $.post("../ashx/MyShopYanZheng.ashx", {}, function (data) {
            if (data == "1") {

                $("#DengLu").click();

            } else if (data == "2") {
                window.location.href = '../Views/MyChar.aspx';
            }
        });
    })
});
