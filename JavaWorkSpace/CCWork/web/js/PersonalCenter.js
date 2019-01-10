$(function () {

    //个人信息获取
    var residentId;
    getPersonalResident();
    function getPersonalResident(){
        $.ajax({
            url:"personal/getpersonalinformation",
            type:"post",
            dataType:"json",
            data:{},
            async:false,
            success:function (data) {
                 residentId=data.resident.residentId;
                $("#residentName").text(data.resident.residentName);
                $("#residentCommunity").text(data.communityName);
                $("#residentPermission").text(data.permissionName);
                $("#residentAge").text(data.resident.residentAge);
                $("#residentPhone").text(data.resident.residentPhone);
                $("#residentEmail").text(data.resident.residentAccount);
                $("#residentAdress").text(data.resident.residentAdress);
                $("#residentPicture").attr('src',data.pictureurl);
            }
        })
    }

    //修改个人信息
    $("#residentChangebtn").click(function () {
        $("#residentBody").css("display","none");
        $("#residentChangeBody").css("display","block");
        var communityId;
        $.ajax({
            url:"personal/getpersonalinformation",
            type:"post",
            dataType:"json",
            data:{},
            async:false,
            success:function (data) {
                $("#residentChangeName").val(data.resident.residentName);
                $("#residentChangeAge").val(data.resident.residentAge);
                $("#residentChangePhone").val(data.resident.residentPhone);
                $("#residentChangeAdress").val(data.resident.residentAdress);
                $("#residentChangePicture").attr('src',data.pictureurl);
                communityId=data.resident.residentCommunity;
            }
        })
        getResidentCommunity(communityId);
        
    });

    //获取居民社区
    function getResidentCommunity(id){
        $.ajax({
            url:"community/listAllCommunity",
            type:"post",
            dataType:"json",
            data:{},
            async:false,
            success:function (data) {
               for (var i=0;i<data.length;i++){
                   if (data[i].communityId==id){
                       $("#residentChangeCommunity").append("<option value='"+data[i].communityId+"' selected='true'>"+data[i].communityName+"</option>");
                   } else {
                       $("#residentChangeCommunity").append("<option value='"+data[i].communityId+"'>"+data[i].communityName+"</option>");
                   }

               }
            }
        })
    }




    //个人信息修改提交
    $("#residentChangeOK").click(function () {
        var residentChangeName=$("#residentChangeName").val();
        var residentChangeCommunity=$("#residentChangeCommunity").val();
        var residentChangeAge=$("#residentChangeAge").val();
        var residentChangePhone=$("#residentChangePhone").val();
        var residentChangeAdress=$("#residentChangeAdress").val();
        $.ajax({
            url:"personal/updatepersonal",
            type:"post",
            dataType:"json",
            async:false,
            data:{
                "residentId":residentId,
                "residentChangeName":residentChangeName,
                "residentChangeCommunity":residentChangeCommunity,
                "residentChangeAge":residentChangeAge,
                "residentChangePhone":residentChangePhone,
                "residentChangeAdress":residentChangeAdress,
            },
            success:function () {

            }
        })
        getPersonalResident();
        $("#residentBody").css("display","block");
        $("#residentChangeBody").css("display","none");
        getPersonalHead();
    })

    //取消修改
    $("#residentChangeNO").click(function () {
        $("#residentBody").css("display","block");
        $("#residentChangeBody").css("display","none");
        getPersonalResident();
    })



    //个人评论模块
        //评论的公告的显示和影藏
    $("#commentBody").on('click','.commentshowbtn',function () {
        var announcementbox=$(this).siblings('.commentAnnouncementbox');
        var flag=announcementbox.css("display");
        var i=$(this).children('a').children('i');
        if (flag=="block"){
            announcementbox.css("display","none");
            i.removeClass('fe-chevron-up');
            i.addClass('fe-chevron-down');
        }else {
            announcementbox.css("display","block");
            i.removeClass('fe-chevron-down');
            i.addClass('fe-chevron-up');
        }
    })
    //获取评论和评论的公告
    function getCommentList(){
        $.ajax({
            url:"personal/getpersonalcommentlist",
            type:"post",
            dataType:"json",
            async:false,
            data:{},
            success:function (data) {
                $("#commentBody").children("div").remove();
                for (var i=0;i<data.length;i++){
                    $("#commentBody").append("" +
                        "<div class='commentbox card'>" +
                        "<div class='commentPictureList'>" +
                        "<div class='commentText'>"+data[i].comment.commentTable+"</div>" +
                        "</div>" +
                        "<div>" +
                        "<span class='commentTime'>"+data[i].comment.commentTime+"</span>" +
                        "<button class='btn btn-danger commentDeletebtn' value='"+data[i].comment.commentId+"'><i class='fe fe-trash-2'></i></button>" +
                        "</div>" +
                        "<div class='commentAnnouncementbox'>" +
                        "<div>" +
                        "<span class='commentAnnouncementTitle'>"+data[i].announcement.announcementTitle+"</span><br>" +
                        "<span class='commentAnnouncementTime'>"+data[i].announcement.announcementTime+"</span>" +
                        "</div>" +
                        "<div class='commentAnnouncementPictureList'>" +
                        "<div class='commentAnnouncementText'>"+data[i].announcement.announcementTable+"</div>" +
                        "</div>"+
                        "</div>" +
                        "<div class='commentshowbtn'><a><i class='fe fe-chevron-down'></i></a></div>"+
                        "</div>");
                    for (var j=0;j<data[i].commentPicture.length;j++){
                         $(".commentPictureList:last").append("<img src='data[i].commentPicture[j].pictureUrl'>");
                    }
                    for (var k=0;k<data[i].announcementPicture.length;k++){
                        $(".commentAnnouncementPictureList:last").append("<img src='data[i].announcementPicture[k].pictureUrl'>")
                    }
                }
            }
        })
    }

    $("#commentBody").on('click','.commentDeletebtn',function () {
        if (confirm("Confirm delete?")) {
            var id = $(this).val();
            $.ajax({
                url: "personal/deletepersonalcomment",
                type: "post",
                async: false,
                data: {
                    "id": id,
                },
                success: function () {
                    getCommentList();
                }
            })
        }else {

        }
    })


    //公告模块
        //公告评论展示
    $("#announcementBody").on('click','.announcementshowbtn',function () {
        var commentbox=$(this).siblings('.announcementCommentBoxDiv');
        var flag=commentbox.css("display");
        var i=$(this).children('a').children('i');
        if (flag=="block"){
            commentbox.css("display","none");
            i.removeClass('fe-chevron-up');
            i.addClass('fe-chevron-down');
        }else {
            commentbox.css("display","block");
            i.removeClass('fe-chevron-down');
            i.addClass('fe-chevron-up');
        }
    })
    //获取公告和公告的评论
    function getAnnouncementList(){
        $.ajax({
            url:"personal/getpersonalannouncementlist",
            type:"post",
            dataType:"json",
            async:false,
            data:{},
            success:function (data) {
                  $("#announcementBody").children("div").remove();
                  for (var i=0;i<data.length;i++){
                      $("#announcementBody").append("" +
                          "<div class='announcementbox card'>" +
                          "<div class='announcementPictureList'>" +
                          "<div class='announcementTitle'>"+data[i].announcement.announcementTitle+"</div>" +
                          "<div class='announcementTime'>"+data[i].announcement.announcementTime+"</div>" +
                          "<div class='announcementText'>"+data[i].announcement.announcementTable+"</div>" +
                          "</div>" +
                          "<button class='btn btn-danger announcementDeletebtn' value='"+data[i].announcement.announcementId+"'><i class='fe fe-trash-2'></i></button>" +
                          "<div class='announcementCommentBoxDiv'>" +
                          "</div>"+
                          "<div class='announcementshowbtn'>" +
                          "<a><i class='fe fe-chevron-down'></i></a>"+
                          "</div>"+
                          "</div>");
                      for (var j=0;j<data[i].announcementPicture.length;j++){
                          $(".announcementPictureList:last").append("<img src='"+data[i].announcementPicture[j].pictureUrl+"'>")
                      }
                      for (var k=0;k<data[i].commentlist.length;k++){
                          $(".announcementCommentBoxDiv:last").append("<div class='announcementCommentbox'>" +
                              "<div>" +
                              "<span class='avatar avatar-lg announcementResidentAvatar' style='background-image: url("+data[i].commentlist[k].picture.pictureUrl+")'></span>" +
                              "<span class='announcementResidentName'>"+data[i].commentlist[k].resident.residentName+"</span>" +
                              "<span class='announcementCommentTime'>"+data[i].commentlist[k].comment.commentTime+"</span>" +
                              "</div>"+
                              "<div class='announcementCommentPictureList'>" +
                              "<div class='announcementCommentText'>"+data[i].commentlist[k].comment.commentTable+"</div>" +
                              "</div>"+
                              "</div>");
                          for (var n=0;n<data[i].commentlist[k].commentPicturelist.length;n++){
                              $(".announcementCommentPictureList:last").append("<img src='data[i].commentlist[k].commentPicturelist[n].pictureUrl'>");
                          }
                      }
                  } 
            }
        })
    }
    //个人公告的删除
    $("#announcementBody").on('click','.announcementDeletebtn',function () {
        if (confirm("Confirm delete?")){
        var id=$(this).val();
        $.ajax({
            url:"personal/deletepersonalannouncement",
            type:"post",
            async:false,
            data:{
                "id":id,
            },
            success:function () {
                getAnnouncementList();
            }
        })}else {

        }
    })

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

    
    //面板切换
    $("#residentbtn").click(function () {
        getPersonalResident();
        $("#residentBody").css("display","block");
        $("#announcementBody").css("display","none");
        $("#commentBody").css("display","none");
        $("#residentChangeBody").css("display","none");
    })
    $("#announcementbtn").click(function () {
        getAnnouncementList();
        $("#residentBody").css("display","none");
        $("#announcementBody").css("display","block");
        $("#commentBody").css("display","none");
        $("#residentChangeBody").css("display","none");
    })
    $("#commentbtn").click(function () {
        getCommentList();
        $("#residentBody").css("display","none");
        $("#announcementBody").css("display","none");
        $("#commentBody").css("display","block");
        $("#residentChangeBody").css("display","none");
    })
})