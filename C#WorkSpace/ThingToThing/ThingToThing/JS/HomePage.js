$(function () {
    $("#mainShangping").delegate(".Thingbtn", "click", function () {
        var UserId = $(this).siblings(".LoginIdjump").val();
        var ThingId = $(this).siblings(".ThingIdjump").val();
        var link = "../Views/MyChar.aspx?ThingId=" + ThingId + "";
        $.post("../ashx/MyShopYanZheng.ashx", {}, function (data) {
            if (data == "1") {

                $("#DengLu").click();

            } else if (data == "2") {
                window.location.href = link;
            }
        });
        
    });
    $("#mainShangping").delegate("img", "click", function () {
        var ThingId = $(this).siblings("input").val();
        $.post("../ashx/MyShopYanZheng.ashx", {}, function (data) {
            if (data == "1") {

                $("#DengLu").click();

            } else if (data == "2") {
               window.location.href = "../Views/ThingInformation.aspx?ThingId=" + ThingId + "";
            }
        });
        
    });
   
    //var pageIndex = 1;
    //var pageSize = 30;
    //var pagecount;
    //var numberbegin=1;
    ////getmainThing();
    ////function getmainThing() {
    ////    $("div").remove(".mainShangPingthing");
    ////    var suo = 0;
    ////    $.post("../ashx/HomePageFingThing.ashx", { "pageIndex": pageIndex, "pageSize": pageSize }, function (datamianThing) {

    ////        for (var i = 0; i < datamianThing.length; i++) {
    ////            var ThingId = datamianThing[i].ThingId;
    ////            var ThingName = datamianThing[i].ThingName;
    ////            var ThingType = datamianThing[i].ThingType;
    ////            var ThingTime = datamianThing[i].ThingTime;
    ////            var ThingIntroducation = datamianThing[i].ThingIntroduction;
    ////            var UserId = datamianThing[i].UserId;
    ////            $("#mainShangping").append(" <div class='mainShangPingthing'><div class='ShangPingImg'id='H" + ThingId + "'></div><div class='Thingname'>" + ThingName + "</div><div class='ThingType'>" + ThingType + "</div><div class='ThingJian'>" + ThingIntroducation + "</div><div class='Thingbtn btn btn-default'>添加交换</div></div>");
    ////            $.post("../ashx/FindShopThing.ashx", { "ThingId": ThingId }, function (dataurl) {
    ////                $("#H" + dataurl.ThingId + "").append("<img src=" + dataurl.ImgUrl[0] + ">");

    ////            }, "json")
    ////         }
           

    ////        $.post("../ashx/HomePageThingCount.ashx", {}, function (datamainSize) {

    ////            pagecount = datamainSize / pageSize + 1;
    ////            if (pagecount <= 5 || (pagecount - numberbegin) <= 5) {
    ////                $("div").remove(".pagenumberbtn");
    ////                for (var i = 1; i < pagecount; i++) {
    ////                    $("#pagenumber").append("<div class='pagenumberbtn'>" + i + "</div>");
    ////                }
    ////            } else {
    ////                $("div").remove(".pagenumberbtn");
    ////                for (var j = 0; j < 5; j++) {
    ////                    var newnumber = numberbegin / 2 + j + 1;
    ////                    $("#pagenumber").append("<div class='pagenumberbtn'>" + newnumber + "</div>");
    ////                }
    ////            }
    ////            for (var k = 0; k < 5; k++) {
    ////                if ($(".pagenumberbtn").eq(k).text() == numberbegin) {
    ////                    $(".pagenumberbtn").eq(k).css({ "background-color": "rgba(0, 0, 0, 0.70", "color": "white" });
    ////                }
    ////            }
    ////        });
    ////    }, "json");
           
    ////}

    //$("#pagenumber").delegate(".pagenumberbtn", "click", function () {
    //    numberbegin = $(this).text();
    //    pageIndex = $(this).text();
    //    getmainThing();
    //});
    //$("#pagebefore").click(function () {
    //    if (pageIndex > 1) {
    //        pageIndex = pageIndex - 1;
    //    }
    //    getmainThing();
    //});
    //$("#pagenext").click(function () {
    //    if (pageIndex < pagecount - 1) {
    //        pageIndex = pageIndex + 1;
    //    }
    //    getmainThing();
    //});


});