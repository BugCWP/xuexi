$(function () {
    getPersonalHead();
    //获取头部
    function getPersonalHead(){
        $.ajax({
            url: "personal/getpersonalhead",
            type: "post",
            dataType: "json",
            async: false,
            data: {},
            success:function (data) {
                $("#personalheadpicture").css("background-image","url("+data.picture.pictureUrl+")");
                $("#personalheadname").text(data.resident.residentName);
                $("#personalheadcommunity").text(data.community.communityName);
            }
        })
    }


    //展开合拢公告
    $("#announcementBody").on('click','.announcementdownbtn',function () {
        var demo=$(this).parent();
        var democlass=demo.attr('class');
        if (democlass.indexOf("announcementDemolow")!=-1){
            demo.removeClass('announcementDemolow');
            var c=$(this).children();
            c.removeClass("fe-chevron-down");
            c.addClass("fe-chevron-up");
        } else {
            demo.addClass('announcementDemolow');
            var c=$(this).children();
            c.removeClass("fe-chevron-up");
            c.addClass("fe-chevron-down");
        }
    })
    getannouncementlist();
    //接收信息
    function getannouncementlist() {
        $.ajax({
            url: "announcement/getannouncementlist",
            type: "post",
            dataType: "json",
            async: false,
            data: {},
            success:function (data){
                $("#announcementBody").children("div").remove();
                for (var i=0;i<data.length;i++){
                    for (var j=0;j<data[i].announcementList.length;j++){
                        $("#announcementBody").append("<div class='col-lg-11'>" +
                            "<div class='card announcementDemolow'>" +
                            "<div class='card-body d-flex flex-column'>" +
                            "<h4><a href='announcement/announcementPage?announcementId="+data[i].announcementList[j].announcement.announcementId+"'>"+data[i].announcementList[j].announcement.announcementTitle+"</a></h4>" +
                            "<div class='text-muted'>"+data[i].announcementList[j].announcement.announcementTable+"</div>" +
                            "<div class='announcementPicturebox row gutters-sm'></div>" +
                            "<div class='d-flex align-items-center pt-5 mt-auto'>" +
                            "<div class='avatar avatar-md mr-3' style='background-image: url("+data[i].announcementList[j].picture.pictureUrl+")'></div>" +
                            "<div>" +
                            "<a class='text-default'>"+data[i].announcementList[j].residnt.residentName+"</a>" +
                            "<small class='d-block text-muted'>"+data[i].announcementList[j].announcement.announcementTime+"</small>" +
                            "</div>" +
                            "</div>"+
                            "</div>" +
                            "<div class='announcementdownbtn'><i class='fe fe-chevron-down'></i></div>" +
                            "</div>" +
                            "</div>");
                        if (data[i].announcementList[j].pictureList!=null){
                            for (var k=0;k<data[i].announcementList[j].pictureList.length;K++){
                                $(".announcementPicturebox:last").append("<div class='col-sm-2'><img src='"+data[i].announcementList[j].pictureList[k].pictureUrl+"' class='imagecheck-image picture'></div>");
                            }
                        }
                    }
                }
            }
        })
    }

    $("#downupload").click(function () {
        var demo=$("#downupload").children();
        var democlass=demo.attr('class');
        if (democlass.indexOf("fe-chevron-down")!=-1){
            $("#uploadannouncement").css("height","270px");
            demo.removeClass('fe-chevron-down');
            demo.addClass('fe-chevron-up');
        } else {
            $("#uploadannouncement").css("height","20px");
            demo.removeClass("fe-chevron-up");
            demo.addClass('fe-chevron-down');
        }
    })


})