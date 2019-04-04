$(function () {
    $("#CharMyThing").delegate(".MyThingbtn", "click", function () {
        $("#Mychangething").children().remove();
        var id = $(this).siblings(".MyThingid").val();
        var name = $(this).siblings(".MyThingName").text();
        var type = $(this).siblings(".MyThingType").text();
        var url = $(this).siblings(".MyThingImg").children("img").attr("src");
        $("#Mychangething").append("<div class='changeThingimg'><img src='" + url + "'/></div><div class='changThingName'>" + name + "</div><div class='changeThingtype'>" + type + "</div><input id='changeThingid' value='" + id + "' type='hidden'/>");
    });

    $("#changebtn").click(function () {
        var myid = $("#myThingid").val();
        var changeid = $("#changeThingid").val();
        $.post("../ashx/ShopCharAdd.ashx", { "myid": myid, "changeid": changeid }, function (data) {
            if (data == "1") {
                window.location.href = "../Views/MyChar.aspx";
            } else {
                alert("交换失败");
            }
        })
    });
});