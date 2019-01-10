$(function () {
    getPersonalHead();
    //获取头部
    function getPersonalHead(){
        $.ajax({
            url: "/personal/getpersonalhead",
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
    
    $("#commenttextbtn").click(function () {
        var text=$("#commenttext").val();
        var id=$("#announcementId").val();
        $.ajax({
            url: "/comment/addcomment",
            type: "post",
            dataType: "json",
            async: false,
            data: {
                "text":text,
                "id":id,
            },
            success:function (data) {

            }
        })
        window.location.reload();
    })
})