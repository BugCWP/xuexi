$(function () {
     //寻找对应市
    $("#UserAdressProvince").change(function () {
        var porvince = $("#UserAdressProvince").val();
        $.get("SelectCity.ashx", { "porvince": porvince }, function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#UserAdressCity").append("<option value=" + data[i].city + ">" + data[i].city + "</option>");
            }
        },"json")

    });

    //查询是否已存在用户账号
    $("#UserLoginId").blur(function () {
        UserLoginId();
    });


    //注册框判断
    $("#UserName").blur(function () {
        UserLoginId();
        UserName();
    });

    $("#UserPwdOne").blur(function () {
        UserLoginId();
        UserName();
        UserPwdOne();
    });

    $("#UserPwdTwo").blur(function () {
        UserLoginId();
        UserName();
        UserPwdOne();
        UserPwdTwo();
    });

    $("#UserEmail").blur(function () {
        UserLoginId();
        UserName();
        UserPwdOne();
        UserPwdTwo();
        UserEmail();
    });

    $("#UserPhone").blur(function () {
        UserLoginId();
        UserName();
        UserPwdOne();
        UserPwdTwo();
        UserEmail();
        UserPhone();
    });

    $("#UserAdressDetailed").blur(function () {
        UserLoginId();
        UserName();
        UserPwdOne();
        UserPwdTwo();
        UserEmail();
        UserPhone();
        UserAdress();
    });

    function UserLoginId() {
            var Id = $("#UserLoginId").val();
            if ($("#UserLoginId").val() == "") {
                $("#TiShiUserLoginId").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
                $("#IdHidden").val("0");
            } else {
                $.get("ConfimUserId.ashx", { "Id": Id }, function (data) {
                    if (data == "0") {
                        //用户账号已存在
                        $("#TiShiUserLoginId").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
                        $("#IdHidden").val("0");
                    } else {
                        //用户账号可用
                        $("#TiShiUserLoginId").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
                        $("#IdHidden").val("1");
                    }
                });
            }
        
    }

    function UserName() {
        if ($("#UserName").val() == "") {
            $("#TiShiUserName").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
        }
        else {
            $("#TiShiUserName").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
        }
    }

    function UserPwdOne() {
        if ($("#UserPwdOne").val() == "") {
            $("#TiShiUserPwdOne").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
        } else {
            $("#TiShiUserPwdOne").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
            if ($("#UserPwdTwo").val() != "") {
                if ($("#UserPwdTwo").val() != $("#UserPwdOne").val()) {
                    $("#TiShiUserPwdTwo").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
                }
            }
        }
    }

    function UserPwdTwo() {
        if ($("#UserPwdTwo").val() == "") {
            $("#TiShiUserPwdTwo").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
        }
        else {
            if ($("#UserPwdOne").val() != "") {
                if ($("#UserPwdTwo").val() != $("#UserPwdOne").val()) {
                    $("#TiShiUserPwdTwo").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
                   
                } else {
                    $("#TiShiUserPwdTwo").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
                }
            }
        }
    }

    function UserEmail() {
        var email = $("#UserEmail").val();
        if (email == "") {
            $("#TiShiUserEmail").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
        } else {
            if (/^(\w+)(\.\w+)*@(\w+)(\.\w+)*.(\w+)$/i.test(email)) {
                $("#TiShiUserEmail").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
            } else {
                $("#TiShiUserEmail").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
            }
        }
    }

    function UserPhone() {
        var phone = $("#UserPhone").val();
        if (phone == "") {
            $("#TiShiUserPhone").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
        } else {
            if (/^1(3|4|5|7|8)\d{9}$/i.test(phone)) {
                $("#TiShiUserPhone").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
            } else {
                $("#TiShiUserPhone").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
            }
        }
    }

    function UserAdress() {
        var adresspprvince = $("#UserAdressProvince").val();
        var adresscity = $("#UserAdressCity").val();
        var adressdetailed = $("#UserAdressDetailed").val();
        if (adresspprvince == "省" || adresscity == "市" || adressdetailed == "") {
            $("#UserAdress").removeClass("glyphicon glyphicon-ok").addClass("glyphicon glyphicon-remove").css("color", "#ff0800");
        } else {
            $("#UserAdress").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").css("color", "#16f605");
        }
    }

    //清除按钮
    $("#btn-Clear").click(function () {
        $("#UserLoginId").val("") ;
        $("#UserName").val("");
        $("#UserPwdOne").val("") ;
        $("#UserPwdTwo").val("") ;
        $("#UserEmail").val("");
        $("#UserPhone").val("") ;
        $("#UserAdressProvince").val("省") ;
        $("#UserAdressCity").val("市")  ;
        $("#UserAdressDetailed").val("");
        $("#TiShiUserLoginId").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
        $("#TiShiUserName").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
        $("#TiShiUserPwdOne").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
        $("#TiShiUserPwdTwo").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
        $("#TiShiUserEmail").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
        $("#TiShiUserPhone").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
        $("#UserAdress").removeClass("glyphicon glyphicon-remove").removeClass("glyphicon glyphicon-ok");
    });

   
})