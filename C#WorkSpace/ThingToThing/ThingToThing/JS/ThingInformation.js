$(function () {
    $("#TiJiao").click(function () {
        var pjtxt = $("#PingJia").val();
        var ThingId = $("#ThingIdjump").val();
       
        $.post("../ashx/PJAdd.ashx", { "pjtxt": pjtxt, "ThingId": ThingId }, function (data) {
            $("#PingJiaCharu").append("<div class='pingjiaing'><div class='PingJiaName'>" + data.UserName + "</div><div class='PingJiaTime'>" + data.PJTime + "</div><div class='PingJiaZhuTi'>" + data.PingJiatxt + "</div></div>");
            var pjtxt = $("#PingJia").val("");
        },"json");
    })
    $("#Thingimgs").children().first().addClass("border");
    $("#Thingimgs").delegate(".YuLanimg", "click", function () {
        var url = $(this).attr("src");
        $("#bigimg").attr("src", url);
        $(this).siblings().removeClass("border");
        $(this).addClass("border");
    });
});