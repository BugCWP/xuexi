$(function () {

    getsixnumber();
    getCommunityList();
    // 获取控制板六数据展示，用定时器循环取值
    setInterval(getsixnumber,5000);
    function getsixnumber(){
        $.post("controlpanel/controlnumber",{},function (data) {
            $("#onlineResidentCount").html(data.onlineResidentCount);
            $("#onlineResidentCountToday").html(data.onlineResidentCountToday);
            $("#residentCount").html(data.residentCount);
            $("#announcementCount").html(data.announcementCount);
            $("#commentCount").html(data.commentCount);
            $("#communityCount").html(data.communityCount);
        },"json");
    }

    //社区栏控制模块
       //获取社区队列信息
    var communitypageSize;
    var communitypageIndex=1;
    var communityTotalCount;
    function getCommunityList(){
        var communityTitle=$("#communityTitle").val();
        getCommunityTotalCount();
        $.post("community/listCommunityByPage",{"pageIndex":communitypageIndex,"communityTitle":communityTitle},function (data) {
            $("#communityBody").html("");
            console.log(data.length);
            console.log(data[0]);
            for (var i=0;i<data.length;i++){
                $("#communityBody").append("<tr><td></td><td>"+data[i].communityName+"</td><td>"+data[i].communityAdress+"</td><td>"+data[i].communityIntroduction+"</td></tr>");
            }
        },"json");
    }
       //获取社区的总数
    function getCommunityTotalCount(){
        $.post("community/CommunityTotalCount",{},function (data) {
             communityTotalCount=data.communityTotalCount;
             //判断页数
             if (communityTotalCount/10<1){
                 communitypageSize=1;
             } else if (communityTotalCount/10>=1){
                 if (communityTotalCount%10==0){
                     communitypageSize=communityTotalCount/10;
                 } else {
                     communitypageSize=parseInt(communityTotalCount/10)+1;
                 }
             }
             $("#communityPageSize").text(communitypageSize);
            $("#communityTotalCount").text(communityTotalCount);
            setCommunityPageBtnNumber();
        },"json")
    }
      //生成按钮
    function setCommunityPageBtnNumber(){
        if (communitypageSize>5){
             if (communitypageSize-communitypageIndex<3){
                 $("#communityPageBtnNumber").html("");
                 for (var i=communitypageSize-4;i<=communitypageSize;i++){
                     $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber'>"+i+"</a>");
                 }
             }else if(communitypageIndex<=3){
                 $("#communityPageBtnNumber").html("");
                 for (var i=1;i<=5;i++){
                     $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber'>"+i+"</a>");
                 }
             }else{
                 $("#communityPageBtnNumber").html("");
                 for(var i=communitypageIndex-2;i<=communitypageIndex+2;i++){
                     $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber'>"+i+"</a>");
                 }
             }
        } else {
            $("#communityPageBtnNumber").html("");
            for (var i=1;i<=communitypageSize;i++){
                $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber'>"+i+"</a>")
            }
        }
    }

    // 表格切换
    $("#tablecommunitybtn").click(function () {
        $("#tablecommunity").css("display","block");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","none");
    });
    $("#tableresidentbtn").click(function () {
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","block");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","none");
    });
    $("#tablepermissionbtn").click(function () {
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","block");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","none");
    });
    $("#tableannouncementbtn").click(function () {
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","block");
        $("#tablecomment").css("display","none");
    });
    $("#tablecommentbtn").click(function () {
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","block");
    })
})