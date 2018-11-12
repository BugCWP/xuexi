$(function () {

    //面板切换
    $("#residentbtn").click(function () {
        $("#residentBody").css("display","block");
        $("#announcementBody").css("display","none");
        $("#commentBody").css("display","none");
    })
    $("#announcementbtn").click(function () {
        $("#residentBody").css("display","none");
        $("#announcementBody").css("display","block");
        $("#commentBody").css("display","none");
    })
    $("#commentbtn").click(function () {
        $("#residentBody").css("display","none");
        $("#announcementBody").css("display","none");
        $("#commentBody").css("display","block");
    })
})