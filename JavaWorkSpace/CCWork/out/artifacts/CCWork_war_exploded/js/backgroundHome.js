$(function () {

    getsixnumber();
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
    var communityId;
    var communityName;
    var communityAdress;
    var communityIntroduction;
    var communityPicture;
    getCommunityList();
    function getCommunityList(){
        var communityTitle=$("#communityTitle").val();
        getCommunityTotalCount();
        $.ajax({
            url:"community/listCommunityByPage",
            type:"post",
            dataType:"json",
            data:{"communityPageIndex":communitypageIndex,"communityTitle":communityTitle,"communitypageSize":communitypageSize},
            success:function (data) {
                $("#communityBody").html("");
                for (var i=0;i<data.length;i++){
                    if (i==data.length-1){
                        $("#communityBody").append("<tr><td></td><td>"+data[i].communityName+"</td><td>"+data[i].communityAdress+"</td><td>"+data[i].communityIntroduction+"</td><td><div class='btn-list'><button class='btn btn-primary coummunityChangebtn' value='"+data[i].communityId+"'><i class='fe fe-settings' style='color: white'></i></button><button class='btn btn-danger communityDeletebtn' value='"+data[i].communityId+"'><i class='fe fe-trash-2' style='color: white'></i></button><button class='btn btn-secondary communityAddbtn'><i class='fe fe-plus'></i></button></div></td></tr>");
                    }else {
                        $("#communityBody").append("<tr><td></td><td>"+data[i].communityName+"</td><td>"+data[i].communityAdress+"</td><td>"+data[i].communityIntroduction+"</td><td><div class='btn-list'><button class='btn btn-primary coummunityChangebtn' value='"+data[i].communityId+"'><i class='fe fe-settings' style='color: white'></i></button><button class='btn btn-danger communityDeletebtn' value='"+data[i].communityId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td></tr>");
                    }
                }
            },
            error:function () {

            }
        })
    }
       //获取社区的总数
    function getCommunityTotalCount(){
        var communityTitle=$("#communityTitle").val();
        $.ajax({
            url:"community/CommunityTotalCount",
            type:"post",
            dataType:"json",
            data:{"communityTitle":communityTitle},
            async:false,
            success:function (data) {
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
            }
        })
    }
      //生成按钮
    function setCommunityPageBtnNumber(){
        if (communitypageSize>5){
             if (communitypageSize-communitypageIndex<3){
                 $("#communityPageBtnNumber").html("");
                 for (var i=communitypageSize-4;i<=communitypageSize;i++){
                     $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber coummintyNumberbtn'>"+i+"</a>");
                 }
             }else if(communitypageIndex<=3){
                 $("#communityPageBtnNumber").html("");
                 for (var i=1;i<=5;i++){
                     $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber coummintyNumberbtn'>"+i+"</a>");
                 }
             }else{
                 $("#communityPageBtnNumber").html("");
                 for(var i=communitypageIndex-2;i<=communitypageIndex+2;i++){
                     $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber coummintyNumberbtn'>"+i+"</a>");
                 }
             }
        } else {
            $("#communityPageBtnNumber").html("");
            for (var i=1;i<=communitypageSize;i++){
                $("#communityPageBtnNumber").append("<a class='btn btn-secondary btnNumber coummintyNumberbtn'>"+i+"</a>")
            }
        }
    }
         //上一页
    $("#communitylastpage").click(function () {
        if(communitypageIndex>1){
            communitypageIndex--;
            getCommunityList();
        }
    })
         //下一页
    $("#communitynextpage").click(function () {
        if(communitypageIndex<communitypageSize){
            communitypageIndex++;
            getCommunityList();
        }
    })

    //按名称搜索
    $("#communitySearch").click(function () {
            communitypageIndex=1;
            getCommunityList();
    })

    //页码点击跳转事件
    $("#communityPageBtnNumber").on('click','.coummintyNumberbtn',function () {
        var pageIndex=$(this).html();
        communitypageIndex=pageIndex;
        getCommunityList();
    })

    //添加事件
    $("#communityBody").on('click','.communityAddbtn',function () {
        $(this).attr("disabled",true);
        $(".coummunityChangebtn").attr("disabled",true);
        $(".communityDeletebtn").attr("disabled",true);
        $("#communityBody").append("<tr><td></td><td><input type='text' class='form-control' placeholder='CommunityName' id='communityAddTitle'></td><td><input type='text' class='form-control' placeholder='CommunityAdress' id='communityAddAdress'></td><td><input type='text' class='form-control' placeholder='CommunityIntroduction' id='communityAddIntroduction'></td><td><div class='btn-list'><button class='btn btn-primary' id='communityAddOK' style='color: white'>OK</button><button class='btn btn-secondary' id='communityAddNO'>NO</button></div></td></tr>")
    })

    //添加事件确认
    $("#communityBody").on('click','#communityAddOK',function () {
        var communityName=$("#communityAddTitle").val();
        var communityAdress=$("#communityAddAdress").val();
        var communityIntroduction=$("#communityAddIntroduction").val();
        if (communityName==""){
            $("#communityAddTitle").attr('placeholder','There can not be empty');
        }else if (communityAdress=="") {
            $("#communityAddAdress").attr('placeholder','There can not be empty');
        }else {
            $.ajax({
                url:"community/addCommunity",
                type:"post",
                dataType:"json",
                async:false,
                data:{'communityName':communityName,'communityAdress':communityAdress,'communityIntroduction':communityIntroduction},
                success:function (data) {
                },
                error:function () {
                }
            })
            getCommunityList();
        }
    })
    //添加事件取消
    $("#communityBody").on('click','#communityAddNO',function () {
        getCommunityList();
    })

    //删除事件
    $("#communityBody").on('click','.communityDeletebtn',function () {
        if (confirm("Confirm delete this community?")){
            var id= $(this).val();
            $.ajax({
                url:"community/deleteCommunity",
                type:"post",
                async:false,
                data:{"id":id},
                success:function() {
                    getCommunityList();
                },
                error:function () {

                }
            })
        }else {

        }
    })

    //修改社区
    $("#communityBody").on('click','.coummunityChangebtn',function () {
          var id=$(this).val();
          $.ajax({
              url:"community/findcommunity",
              type:"post",
              data:{"id":id},
              dataType:"json",
              async:false,
              success:function(data) {
                 communityId=data.communityId;
                  communityName=data.communityName;
                  communityAdress=data.communityAdress;
                  communityIntroduction=data.communityIntroduction;
                  communityPicture=data.communityPicture;
              },
              error:function () {

              }
          })
        var tr= $(this).parent().parent().parent('tr');
          tr.children('td').remove();
          tr.append("<td></td><td><input id='communityChangeName' type='text' value='"+communityName+"' class='form-control'></td><td><input id='communityChangeAdress' type='text' value='"+communityAdress+"' class='form-control'></td><td><input id='communityChangeIntroduction' type='text' value='"+communityIntroduction+"' class='form-control'></td><td><div class='btn-list'><button id='communityChangeOK' class='btn btn-success' value='"+communityId+"'>OK</button><button id='communityChangeNO' class='btn btn-secondary' value='"+communityId+"'>NO</button></div></td>");
        $(".coummunityChangebtn").attr("disabled",true);
        $(".communityDeletebtn").attr("disabled",true);
    })

    //取消修改
    $("#communityBody").on('click','#communityChangeNO',function () {
        var id=$(this).val();
        // var communityId;
        // var communityName;
        // var communityAdress;
        // var communityIntroduction;
        // var communityPicture;
        $.ajax({
            url:"community/findcommunity",
            type:"post",
            data:{"id":id},
            dataType:"json",
            async:false,
            success:function(data) {
                communityId=data.communityId;
                communityName=data.communityName;
                communityAdress=data.communityAdress;
                communityIntroduction=data.communityIntroduction;
                communityPicture=data.communityPicture;
            },
            error:function () {

            }
        })
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td></td><td>"+communityName+"</td><td>"+communityAdress+"</td><td>"+communityIntroduction+"</td><td><div class='btn-list'><button class='btn btn-primary coummunityChangebtn' value='"+communityId+"'><i class='fe fe-settings' style='color: white'></i></button><button class='btn btn-danger communityDeletebtn' value='"+communityId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td></tr>");
        $(".coummunityChangebtn").attr("disabled",false);
        $(".communityDeletebtn").attr("disabled",false);
    })

    //修改确认
    $("#communityBody").on('click','#communityChangeOK',function () {
          var communityChangeName=$("#communityChangeName").val();
          var communityChangeAdress=$("#communityChangeAdress").val();
          var communityChangeIntroduction=$("#communityChangeIntroduction").val();
          var id=$(this).val();
          if (communityChangeName==""){
              $("#communityChangeName").attr('placeholder','There can not be empty');
          }else if(communityChangeAdress==""){
              $("#communityChangeAdress").attr('placeholder','There can not be empty');
          }else {
              $.ajax({
                  url:"community/updatecommunity",
                  type:"post",
                  data:{"id":id,"communityChangeName":communityChangeName,"communityChangeAdress":communityChangeAdress,"communityChangeIntroduction":communityChangeIntroduction},
                  dataType:"json",
                  async:false,
                  success:function(data) {

                  },
                  error:function () {

                  }
              })
              var tr= $(this).parent().parent().parent('tr');
              tr.children('td').remove();
              tr.append("<td></td><td>"+communityChangeName+"</td><td>"+communityChangeAdress+"</td><td>"+communityChangeIntroduction+"</td><td><div class='btn-list'><button class='btn btn-primary coummunityChangebtn' value='"+id+"'><i class='fe fe-settings' style='color: white'></i></button><button class='btn btn-danger communityDeletebtn' value='"+id+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td></tr>");
              $(".coummunityChangebtn").attr("disabled",false);
              $(".communityDeletebtn").attr("disabled",false);
          }
    })







    //居民控制模块
         //获取居民队列信息
    var residentPageIndex=1;
    var residentPageSize;
    var residentId;
    var residentName;
    var residentAge;
    var residentCommunity;
    var residentEmail;
    var residentPhone;
    var residentAdress;
    function getResidentList(){
        var residentCommunity=$("#ResidentCommunityList").val();
        var residentFindType=$("#ResidentFindType").val();
        var residentText=$("#ResidentText").val();
        var residentDelete=$("#ResidentDeleteOrStay").val();
        getResidentTotalcount();
        $.ajax({
            url:"resident/listresidentByPage",
            type:"post",
            dataType:"json",
            data:{"residentPageIndex":residentPageIndex,"residentPageSize":residentPageSize,"residentCommunity":residentCommunity,"residentFindType":residentFindType,"residentText":residentText,"residentDelete":residentDelete},
            success:function (data) {
                $("#residentBody").html("");
                for (var i=0;i<data.length;i++){
                    if (residentDelete==1){
                        $("#residentBody").append("<tr><td></td><td>"+data[i].resident.residentName+"</td><td>"+data[i].resident.residentAge+"</td><td>"+data[i].communityName+"</td><td>"+data[i].resident.residentAccount+"</td><td>"+data[i].resident.residentPhone+"</td><td>"+data[i].resident.residentAdress+"</td><td><div class='btn-list'><button class='btn btn-primary residentChangebtn' value='"+data[i].resident.residentId+"'><i class='fe fe-settings' style='color: white'></i></button><button class='btn btn-danger residentDeletebtn' value='"+data[i].resident.residentId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td></tr>");
                    }else if(residentDelete==0){
                        $("#residentBody").append("<tr><td></td><td>"+data[i].resident.residentName+"</td><td>"+data[i].resident.residentAge+"</td><td>"+data[i].communityName+"</td><td>"+data[i].resident.residentAccount+"</td><td>"+data[i].resident.residentPhone+"</td><td>"+data[i].resident.residentAdress+"</td><td><div class='btn-list'><button class='btn btn-success residentJiebtn' value='"+data[i].resident.residentId+"'><i class='fe fe-plus' style='color: white'></i></button></div></td></tr>");
                    }
                }
            },
            error:function () {

            }
        })
    }

        //获取居民数量
    function getResidentTotalcount(){
        var residentCommunity=$("#ResidentCommunityList").val();
        var residentFindType=$("#ResidentFindType").val();
        var residentText=$("#ResidentText").val();
        var residentDelete=$("#ResidentDeleteOrStay").val();
        var residentTotalCount;
        $.ajax({
            url:"resident/getresidenttotalcount",
            type:"post",
            dataType:"json",
            data:{"residentCommunity":residentCommunity,"residentFindType":residentFindType,"residentText":residentText,"residentDelete":residentDelete},
            async:false,
            success:function (data) {
                residentTotalCount=data.residentTotalCount;
                //判断页数
                if (residentTotalCount/10<1){
                    residentPageSize=1;
                } else if (residentTotalCount/10>=1){
                    if (residentTotalCount%10==0){
                        residentPageSize=residentTotalCount/10;
                    } else {
                        residentPageSize=parseInt(residentTotalCount/10)+1;
                    }
                }
                $("#residentPageSize").text(residentPageSize);
                $("#residentTotalCount").text(residentTotalCount);
                setResidentPageBtnNumber();
            }
        })
    }

    //生成按钮
    function setResidentPageBtnNumber(){
        if (residentPageSize>5){
            if (residentPageSize-residentPageIndex<3){
                $("#residentPageBtnNumber").html("");
                for (var i=residentPageSize-4;i<=residentPageSize;i++){
                    $("#residentPageBtnNumber").append("<a class='btn btn-secondary btnNumber residentNumberbtn'>"+i+"</a>");
                }
            }else if(residentPageIndex<=3){
                $("#residentPageBtnNumber").html("");
                for (var i=1;i<=5;i++){
                    $("#residentPageBtnNumber").append("<a class='btn btn-secondary btnNumber residentNumberbtn'>"+i+"</a>");
                }
            }else{
                $("#residentPageBtnNumber").html("");
                for(var i=residentPageIndex-2;i<=residentPageIndex+2;i++){
                    $("#residentPageBtnNumber").append("<a class='btn btn-secondary btnNumber residentNumberbtn'>"+i+"</a>");
                }
            }
        } else {
            $("#residentPageBtnNumber").html("");
            for (var i=1;i<=residentPageSize;i++){
                $("#residentPageBtnNumber").append("<a class='btn btn-secondary btnNumber residentNumberbtn'>"+i+"</a>")
            }
        }
    }
    //上一页
    $("#residentlastpage").click(function () {
        if(residentPageIndex>1){
            residentPageIndex--;
            getResidentList();
        }
    })
    //下一页
    $("#residnetnextpage").click(function () {
        if(residentPageIndex<residentPageSize){
            residentPageIndex++;
            getResidentList();
        }
    })

    //按名称搜索
    $("#residentSearch").click(function () {
        residentPageIndex=1;
        getResidentList();
    })

    //页码点击跳转事件
    $("#residentPageBtnNumber").on('click','.residentNumberbtn',function () {
        var pageIndex=$(this).html();
        residentPageIndex=pageIndex;
        getResidentList();
    })

        //获取所有社区队列
    function getAllCommunityList(){
        $.ajax({
            url:"community/listAllCommunity",
            type:"post",
            dataType:"json",
            data:{},
            async:false,
            success:function (data) {
                $("#ResidentCommunityList").children().remove();
                $("#ResidentCommunityList").append("<option value='' selected='true'>All Coummunity</option>");
                for (var i=0;i<data.length;i++){
                    $("#ResidentCommunityList").append("<option value='"+data[i].communityId+"'>"+data[i].communityName+"</option>");
                }
            }
        })
    }

    //删除事件
    $("#residentBody").on('click','.residentDeletebtn',function () {
        if (confirm("Confirm delete this community?")){
            var id= $(this).val();
            $.ajax({
                url:"resident/deleteresident",
                type:"post",
                async:false,
                data:{"id":id},
                success:function() {
                    getResidentList();
                },
                error:function () {

                }
            })
        }else {

        }
    })
    //添加回去residentJiebtn
    $("#residentBody").on('click','.residentJiebtn',function () {
            var id= $(this).val();
            $.ajax({
                url:"resident/updateresidentbydelete",
                type:"post",
                async:false,
                data:{"id":id},
                success:function() {
                    getResidentList();
                },
                error:function () {

                }
            })
    })

    //修改
    $("#residentBody").on('click','.residentChangebtn',function () {
        var id=$(this).val();
        $.ajax({
            url:"resident/findresident",
            type:"post",
            data:{"id":id},
            dataType:"json",
            async:false,
            success:function(data) {
                 residentId=data.resident.residentId;
                 residentName=data.resident.residentName;
                 residentAge=data.resident.residentAge;
                 residentCommunity=data.resident.residentCommunity;
                 residentEmail=data.resident.residentAccount;
                 residentPhone=data.resident.residentPhone;
                 residentAdress=data.resident.residentAdress;
            },
            error:function () {

            }
        })
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td></td><td>"+residentName+"</td><td>"+residentAge+"</td><td><select class='custom-select' id='residentUpdatecommunity'></select></td><td>"+residentEmail+"</td><td><input id='residentChangePhone' type='text' value='"+residentPhone+"' class='form-control'></td><td><input id='residentChangeAdress' type='text' value='"+residentAdress+"' class='form-control'></td><td><div class='btn-list'><button id='residentChangeOK' class='btn btn-success' value='"+communityId+"'>OK</button><button id='residentChangeNO' class='btn btn-secondary' value='"+communityId+"'>NO</button></div></td>");
        $.ajax({
            url:"community/listAllCommunity",
            type:"post",
            data:{},
            dataType:"json",
            async:false,
            success:function(data) {
                for (var i=0;i<data.length;i++){
                    if (data[i].communityId==residentCommunity){
                        $("#residentUpdatecommunity").append("<option value='"+data[i].communityId+"' selected='true'>"+data[i].communityName+"</option>");
                    } else {
                        $("#residentUpdatecommunity").append("<option value='"+data[i].communityId+"'>"+data[i].communityName+"</option>");
                    }
                }
            },
            error:function () {

            }
        })
        $(".residentChangebtn").attr("disabled",true);
        $(".residentDeletebtn").attr("disabled",true);
    })

    //取消修改
    $("#residentBody").on('click','#residentChangeNO',function () {
        var communityName=$("#residentUpdatecommunity").find("option:selected").text();
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td></td><td>"+residentName+"</td><td>"+residentAge+"</td><td>"+communityName+"</td><td>"+residentEmail+"</td><td>"+residentPhone+"</td><td>"+residentAdress+"</td><td><div class='btn-list'><button class='btn btn-primary residentChangebtn' value='"+residentId+"'><i class='fe fe-settings' style='color: white'></i></button><button class='btn btn-danger residentDeletebtn' value='"+residentId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td>");
        $(".residentChangebtn").attr("disabled",false);
        $(".residentDeletebtn").attr("disabled",false);
    })

    //确认修改
    $("#residentBody").on('click','#residentChangeOK',function () {
        var changecommunityId = $("#residentUpdatecommunity").val();
        var residentchangePhone = $("#residentChangePhone").val();
        var residentchangeAdress = $("#residentChangeAdress").val();
        $.ajax({
            url: "resident/updateresident",
            type: "post",
            data: {
                "changecommunityId": changecommunityId,
                "residentchangePhone": residentchangePhone,
                "residentchangeAdress": residentchangeAdress,
                "residentId": residentId
            },
            async: false,
            success: function (data) {

            }
        })
        getResidentList();
    })






    //公告控制模块
    var announcementPageIndex=1;
    var announcementPageSize;
    var announcementId;
    var announcementTitle;
    var announcementTime;
    var announcementTable;
    var announcementresidentName;
         //获取公告列表
    function getAnnouncementList(){
        var announcementFindType=$("#announcementFindType").val();
        var announcementText=$("#announcementText").val();
        var announcementDeleteOrStay=$("#announcementDeleteOrStay").val();
        getAnnouncementTotalcount();
        $.ajax({
            url:"announcement/listannouncementbypage",
            type:"post",
            dataType:"json",
            data:{
                "announcementFindType":announcementFindType,
                "announcementText":announcementText,
                "announcementDeleteOrStay":announcementDeleteOrStay,
                "announcementPageIndex":announcementPageIndex,
                "announcementPageSize":announcementPageSize
             },
            success:function (data) {
                $("#announcementBody").html("");
                for (var i=0;i<data.length;i++){
                    if (announcementDeleteOrStay==1){
                        $("#announcementBody").append("<tr><td>"+data[i].announcement.announcementTitle+"</td><td ><div style='width: 80px;text-overflow: ellipsis'>"+data[i].announcement.announcementTable+"</div></td><td>"+data[i].announcement.announcementTime+"</td><td>"+data[i].residentName+"</td><td><div class='btn-list'><button class='btn btn-primary announcementlookbtn' value='"+data[i].announcement.announcementId+"'><i class='fe fe-eye' style='color: white'></i></button><button class='btn btn-danger annountmentDeletebtn'  value='"+data[i].announcement.announcementId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td></tr>");
                    }else if(announcementDeleteOrStay==0){
                        $("#announcementBody").append("<tr><td>"+data[i].announcement.announcementTitle+"</td><td ><div style='width: 80px;text-overflow: ellipsis'>"+data[i].announcement.announcementTable+"</div></td><td>"+data[i].announcement.announcementTime+"</td><td>"+data[i].residentName+"</td><td><div class='btn-list'><button class='btn btn-success announcementjiebtn' value='"+data[i].announcement.announcementId+"'><i class='fe fe-plus' style='color: white'></i></button></div></td></tr>");
                    }
                }
            },
            error:function () {

            }
        })
    }

        //获取公告数量
    function getAnnouncementTotalcount(){
        var announcementFindType=$("#announcementFindType").val();
        var announcementText=$("#announcementText").val();
        var announcementDeleteOrStay=$("#announcementDeleteOrStay").val();
        var announcementTotalCount;
        $.ajax({
            url:"announcement/announcementTotalCount",
            type:"post",
            dataType:"json",
            data:{
                "announcementFindType":announcementFindType,
                "announcementText":announcementText,
                "announcementDeleteOrStay":announcementDeleteOrStay
            },
            async:false,
            success:function (data) {
                announcementTotalCount=data.announcementTotalCount;
                //判断页数
                if (announcementTotalCount/10<1){
                    announcementPageSize=1;
                } else if (announcementTotalCount/10>=1){
                    if (announcementTotalCount%10==0){
                        announcementPageSize=announcementTotalCount/10;
                    } else {
                        announcementPageSize=parseInt(announcementTotalCount/10)+1;
                    }
                }
                $("#announcementPageSize").text(announcementPageSize);
                $("#announcementTotalCount").text(announcementTotalCount);
               setAnnouncementPageBtnNumber();
            }
        })
    }

    //生成按钮
    function setAnnouncementPageBtnNumber(){
        if (announcementPageSize>5){
            if (announcementPageSize-announcementPageIndex<3){
                $("#announcementPageBtnNumber").html("");
                for (var i=announcementPageSize-4;i<=announcementPageSize;i++){
                    $("#announcementPageBtnNumber").append("<a class='btn btn-secondary btnNumber announcementNumberbtn'>"+i+"</a>");
                }
            }else if(announcementPageIndex<=3){
                $("#announcementPageBtnNumber").html("");
                for (var i=1;i<=5;i++){
                    $("#announcementPageBtnNumber").append("<a class='btn btn-secondary btnNumber announcementNumberbtn'>"+i+"</a>");
                }
            }else{
                $("#announcementPageBtnNumber").html("");
                for(var i=announcementPageIndex-2;i<=announcementPageIndex+2;i++){
                    $("#announcementPageBtnNumber").append("<a class='btn btn-secondary btnNumber announcementNumberbtn'>"+i+"</a>");
                }
            }
        } else {
            $("#announcementPageBtnNumber").html("");
            for (var i=1;i<=announcementPageSize;i++){
                $("#announcementPageBtnNumber").append("<a class='btn btn-secondary btnNumber announcementNumberbtn'>"+i+"</a>")
            }
        }
    }
    //上一页
    $("#announcementlastpage").click(function () {
        if(announcementPageIndex>1){
            announcementPageIndex--;
            getAnnouncementList();
        }
    })
    //下一页
    $("#announcementnextpage").click(function () {
        if(announcementPageIndex<announcementPageSize){
            announcementPageIndex++;
            getAnnouncementList();
        }
    })
//页码点击跳转事件
    $("#announcementPageBtnNumber").on('click','.announcementNumberbtn',function () {
        var pageIndex=$(this).html();
        announcementPageIndex=pageIndex;
        getAnnouncementList();
    })
    //按名称搜索
    $("#announcementSearch").click(function () {
        announcementPageIndex=1;
        getAnnouncementList();
    })
    //删除事件
    $("#announcementBody").on('click','.annountmentDeletebtn',function () {
        if (confirm("Confirm delete this community?")){
            var id= $(this).val();
            $.ajax({
                url:"announcement/deleteannouncement",
                type:"post",
                async:false,
                data:{"id":id},
                success:function() {
                    getAnnouncementList();
                },
                error:function () {

                }
            })
        }else {

        }
    })
    //添加回去announcementjiebtn
    $("#announcementBody").on('click','.announcementjiebtn',function () {
        var id= $(this).val();
        $.ajax({
            url:"announcement/announcementjie",
            type:"post",
            async:false,
            data:{"id":id},
            success:function() {
                getAnnouncementList();
            },
            error:function () {

            }
        })
    })
     //展示按钮
    $("#announcementBody").on('click','.announcementlookbtn',function () {
          var id=$(this).val();
          announcementId=id;
        $.ajax({
            url:"announcement/findannouncement",
            type:"post",
            async:false,
            data:{"id":id},
            dataType:"json",
            success:function(data) {
                announcementTitle=data.announcement.announcementTitle;
                announcementresidentName=data.resident;
                announcementTable=data.announcement.announcementTime;
                announcementTable=data.announcement.announcementTable
             },
            error:function () {

            }
        })
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td><div id='announcementPicture'></div><div>"+announcementTitle+"</div><div>"+announcementresidentName+"  "+announcementTime+"</div><div>"+announcementTable+"</div></td><td><div class='btn-list'><button class='btn btn-secondary' id='announcementClosebtn' value='"+announcementId+"'><i class='fe fe-eye-off'></i></button></div></td>")
        $(".announcementlookbtn").attr("disabled",true);
        $(".annountmentDeletebtn").attr("disabled",true);
    })

      //取消展示
    $("#announcementBody").on('click','#announcementClosebtn',function () {
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td>"+announcementTitle+"</td><td ><div style='width: 80px;text-overflow: ellipsis'>"+announcementTable+"</div></td><td>"+announcementTime+"</td><td>"+announcementresidentName+"</td><td><div class='btn-list'><button class='btn btn-primary announcementlookbtn' value='"+announcementId+"'><i class='fe fe-eye' style='color: white'></i></button><button class='btn btn-danger annountmentDeletebtn'  value='"+announcementId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td>")
        $(".announcementlookbtn").attr("disabled",false);
        $(".annountmentDeletebtn").attr("disabled",false);
    })





    //评论管理模块
    var commentPageIndex=1;
    var commentPageSize;
    var commentId;
    var commentAnnouncementTitle;
    var commentTable;
    var commentTime;
    var commentResidentName;
         //获取评论队列
    function getCommentList(){
        var commentFindType=$("#commentFindType").val();
        var commentText=$("#commentText").val();
        var commentDeleteOrStay=$("#commentDeleteOrStay").val();
        getCommentTotalcount();
        $.ajax({
            url:"comment/listcommentbypage",
            type:"post",
            dataType:"json",
            data:{
                "commentFindType":commentFindType,
                "commentText":commentText,
                "commentDeleteOrStay":commentDeleteOrStay,
                "commentPageIndex":commentPageIndex,
                "commentPageSize":commentPageSize
            },
            success:function (data) {
                $("#commentBody").html("");
                for (var i=0;i<data.length;i++){
                    if (commentDeleteOrStay==1){
                        $("#commentBody").append("<tr><td>"+data[i].announcementTitle+"</td><td ><div style='width: 80px;text-overflow: ellipsis'>"+data[i].comment.commentTable+"</div></td><td>"+data[i].comment.commentTime+"</td><td>"+data[i].residentName+"</td><td><div class='btn-list'><button class='btn btn-primary commentlookbtn' value='"+data[i].comment.commentId+"'><i class='fe fe-eye' style='color: white'></i></button><button class='btn btn-danger commentDeletebtn' value='"+data[i].comment.commentId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td></tr>");
                    }else if(commentDeleteOrStay==0){
                        $("#commentBody").append("<tr><td>"+data[i].announcementTitle+"</td><td ><div style='width: 80px;text-overflow: ellipsis'>"+data[i].comment.commentTable+"</div></td><td>"+data[i].comment.commentTime+"</td><td>"+data[i].residentName+"</td><td><div class='btn-list'><button class='btn btn-success commentjiebtn' value='"+data[i].comment.commentId+"'><i class='fe fe-plus' style='color: white'></i></button></div></td></tr>");
                    }
                }
            },
            error:function () {

            }
        })
    }
        //获取评论数量
    function getCommentTotalcount(){
        var commentFindType=$("#commentFindType").val();
        var commentText=$("#commentText").val();
        var commentDeleteOrStay=$("#commentDeleteOrStay").val();
        var commentTotalCount;
        $.ajax({
            url:"comment/commentTotalCount",
            type:"post",
            dataType:"json",
            data:{
                "commentFindType":commentFindType,
                "commentText":commentText,
                "commentDeleteOrStay":commentDeleteOrStay,
            },
            async:false,
            success:function (data) {
                commentTotalCount=data.commentTotalCount;
                //判断页数
                if (commentTotalCount/10<1){
                    commentPageSize=1;
                } else if (commentTotalCount/10>=1){
                    if (commentTotalCount%10==0){
                        commentPageSize=commentTotalCount/10;
                    } else {
                        commentPageSize=parseInt(commentTotalCount/10)+1;
                    }
                }
                $("#commentPageSize").text(commentPageSize);
                $("#commentTotalCount").text(commentTotalCount);
                setCommentBtnNumber();
            }
        })
    }

    //添加按钮
    function setCommentBtnNumber(){
        if (commentPageSize>5){
            if (commentPageSize-commentPageIndex<3){
                $("#commentPageBtnNumber").html("");
                for (var i=commentPageSize-4;i<=commentPageSize;i++){
                    $("#commentPageBtnNumber").append("<a class='btn btn-secondary btnNumber commentNumberbtn'>"+i+"</a>");
                }
            }else if(commentPageIndex<=3){
                $("#commentPageBtnNumber").html("");
                for (var i=1;i<=5;i++){
                    $("#commentPageBtnNumber").append("<a class='btn btn-secondary btnNumber commentNumberbtn'>"+i+"</a>");
                }
            }else{
                $("#commentPageBtnNumber").html("");
                for(var i=commentPageIndex-2;i<=commentPageIndex+2;i++){
                    $("#commentPageBtnNumber").append("<a class='btn btn-secondary btnNumber commentNumberbtn'>"+i+"</a>");
                }
            }
        } else {
            $("#commentPageBtnNumber").html("");
            for (var i=1;i<=commentPageSize;i++){
                $("#commentPageBtnNumber").append("<a class='btn btn-secondary btnNumber commentNumberbtn'>"+i+"</a>")
            }
        }
    }
    //上一页
    $("#commentlastpage").click(function () {
        if(commentPageIndex>1){
            commentPageIndex--;
            getCommentList();
        }
    })
    //下一页
    $("#commentnextpage").click(function () {
        if(commentPageIndex<commentPageSize){
            commentPageIndex++;
            getCommentList();
        }
    })
    //页码点击跳转事件
    $("#commentPageBtnNumber").on('click','.commentNumberbtn',function () {
        var pageIndex=$(this).html();
        commentPageIndex=pageIndex;
        getCommentList();
    })
    //按名称搜索
    $("#commentSearch").click(function () {
        commentPageIndex=1;
        getCommentList();
    })
    //删除事件
    $("#commentBody").on('click','.commentDeletebtn',function () {
        if (confirm("Confirm delete this community?")){
            var id= $(this).val();
            $.ajax({
                url:"comment/deletecomment",
                type:"post",
                async:false,
                data:{"id":id},
                success:function() {
                    getCommentList();
                },
                error:function () {

                }
            })
        }else {

        }
    })
    //添加回去announcementjiebtn
    $("#commentBody").on('click','.commentjiebtn',function () {
        var id= $(this).val();
        $.ajax({
            url:"comment/commentjiebtn",
            type:"post",
            async:false,
            data:{"id":id},
            success:function() {
                getCommentList();
            },
            error:function () {

            }
        })
    })
    //展示按钮
    $("#commentBody").on('click','.commentlookbtn',function () {
        var id=$(this).val();
        announcementId=id;
        $.ajax({
            url:"comment/findcomment",
            type:"post",
            async:false,
            data:{"id":id},
            dataType:"json",
            success:function(data) {
                communityId=data.comment.commentId;
                commentAnnouncementTitle=data.commentannouncement;
                commentTable=data.comment.commentTable;
                commentTime=data.comment.commentTime;
                commentResidentName=data.commentresident;
            },
            error:function () {

            }
        })
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td><div id='commentPicture'></div><div>"+commentAnnouncementTitle+"</div><div>"+commentResidentName+"  "+commentTime+"</div><div>"+commentTable+"</div></td><td><div class='btn-list'><button class='btn btn-secondary' id='commentClosebtn' value='"+commentId+"'><i class='fe fe-eye-off'></i></button></div></td>")
        $(".commentlookbtn").attr("disabled",true);
        $(".commentDeletebtn").attr("disabled",true);
    })

    //取消展示
    $("#commentBody").on('click','#commentClosebtn',function () {
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td>"+commentAnnouncementTitle+"</td><td ><div style='width: 80px;text-overflow: ellipsis'>"+commentTable+"</div></td><td>"+commentTime+"</td><td>"+commentResidentName+"</td><td><div class='btn-list'><button class='btn btn-primary commentlookbtn' value='"+commentId+"'><i class='fe fe-eye' style='color: white'></i></button><button class='btn btn-danger commentDeletebtn' value='"+commentId+"'><i class='fe fe-trash-2' style='color: white'></i></button></div></td>")
        $(".commentlookbtn").attr("disabled",false);
        $(".commentDeletebtn").attr("disabled",false);
    })






    //权限模块
    var permissionPageIndex=1;
    var permissionPageSize;
    var permissionResidentName;
    var permissionResidentId;
    var permissionName;
    var permissionId;
          //获取权限用户队列
    function getPermissionlist(){
        var permissionFindType=$("#permissionFindType").val();
        var permissionText=$("#permissionText").val();
        getPermissionTotalcount();
        getPremission();
        $.ajax({
            url:"permission/listPermissionbypage",
            type:"post",
            dataType:"json",
            data:{
                "permissionPageIndex":permissionPageIndex,
                "permissionPageSize":permissionPageSize,
                "permissionFindType":permissionFindType,
                "permissionText":permissionText,
            },
            success:function (data) {
                $("#permissionBody").html("");
                for (var i=0;i<data.length;i++){
                    if (data[i].permissionlevel==2){
                        $("#permissionBody").append("<tr><td></td><td>"+data[i].permissionresident.residentName+"</td><td>"+data[i].permissionname+"</td></tr>");
                    } else if (data[i].permissionlevel==3){
                        $("#permissionBody").append("<tr><td></td><td>"+data[i].permissionresident.residentName+"</td><td>"+data[i].permissionname+"</td><td><div class='btn-list'><button class='btn btn-primary' id='permissionChangebtn' value='"+data[i].permissionresident.residentId+"'><i class='fe fe-settings'></i></button></div></td></tr>");
                    }
                }
            },
            error:function () {

            }
        })
    }

    //获取居民数量
    function getPermissionTotalcount(){
        var permissionFindType=$("#permissionFindType").val();
        var permissionText=$("#permissionText").val();
        var permissionTotalCount;
        $.ajax({
            url:"permission/getpermissiontotalcount",
            type:"post",
            dataType:"json",
            data:{
                "permissionFindType":permissionFindType,
                "permissionText":permissionText,
            },
            async:false,
            success:function (data) {
                permissionTotalCount=data.permissionTotalCount;
                //判断页数
                if (permissionTotalCount/10<1){
                    permissionPageSize=1;
                } else if (permissionTotalCount/10>=1){
                    if (permissionTotalCount%10==0){
                        permissionPageSize=permissionTotalCount/10;
                    } else {
                        permissionPageSize=parseInt(permissionTotalCount/10)+1;
                    }
                }
                $("#permissionPageSize").text(permissionPageSize);
                $("#permissionTotalCount").text(permissionTotalCount);
                setPermissionPageBtnNumber();
            }
        })
    }

    //获取权限表
    function getPremission() {
        $.ajax({
            url:"permission/permissionlist",
            type:"post",
            dataType:"json",
            data:{
            },
            async:false,
            success:function (data) {
                $("#permissionFindType").html("");
                $("#permissionFindType").append("<option value=''>All Permission</option>");
                for (var i=0;i<data.length;i++){
                    $("#permissionFindType").append("<option value='"+data[i].permissionLevel+"'>"+data[i].permissionName+"</option>");
                }
            }
        })
    }
    //生成按钮
    function setPermissionPageBtnNumber(){
        if (permissionPageSize>5){
            if (permissionPageSize-permissionPageIndex<3){
                $("#permissionPageBtnNumber").html("");
                for (var i=permissionPageSize-4;i<=permissionPageSize;i++){
                    $("#permissionPageBtnNumber").append("<a class='btn btn-secondary btnNumber permissionNumberbtn'>"+i+"</a>");
                }
            }else if(permissionPageIndex<=3){
                $("#permissionPageBtnNumber").html("");
                for (var i=1;i<=5;i++){
                    $("#permissionPageBtnNumber").append("<a class='btn btn-secondary btnNumber permissionNumberbtn'>"+i+"</a>");
                }
            }else{
                $("#permissionPageBtnNumber").html("");
                for(var i=permissionPageIndex-2;i<=permissionPageIndex+2;i++){
                    $("#permissionPageBtnNumber").append("<a class='btn btn-secondary btnNumber permissionNumberbtn'>"+i+"</a>");
                }
            }
        } else {
            $("#permissionPageBtnNumber").html("");
            for (var i=1;i<=permissionPageSize;i++){
                $("#permissionPageBtnNumber").append("<a class='btn btn-secondary btnNumber permissionNumberbtn'>"+i+"</a>")
            }
        }
    }
    //上一页
    $("#permissionlastpage").click(function () {
        if(permissionPageIndex>1){
            permissionPageIndex--;
            getPermissionlist();
        }
    })
    //下一页
    $("#permissionnextpage").click(function () {
        if(permissionPageIndex<permissionPageSize){
            permissionPageIndex++;
            getPermissionlist();
        }
    })

    //按名称搜索
    $("#permissionSearch").click(function () {
        permissionPageIndex=1;
        getPermissionlist();
    })

    //页码点击跳转事件
    $("#permissionPageBtnNumber").on('click','.permissionNumberbtn',function () {
        var pageIndex=$(this).html();
        permissionPageIndex=pageIndex;
        getPermissionlist();
    })
    //修改按钮
    $("#permissionBody").on('click','#permissionChangebtn',function () {
        var id=$(this).val();
        permissionResidentId=id;
        $.ajax({
            url:"resident/findresident",
            type:"post",
            dataType:"json",
            data:{
                "id":id
            },
            async:false,
            success:function (data) {
               permissionResidentName=data.resident.residentName;
                permissionId=data.resident.residentPermission;
            },
            error:function () {
            }
        })
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        tr.append("<td></td><td>"+permissionResidentName+"</td><td><select id='permissionSelect' class='custom-select'></select></td><td><div class='btn-list'><button class='btn btn-success' id='permissionChangeOK'>OK</button><button class='btn btn-secondary' id='premissionChangeNo'>NO</button></div></td>")
        $(".permissionChangebtn").attr("disabled",true);
        $.ajax({
            url:"permission/permissionlist",
            type:"post",
            dataType:"json",
            data:{
            },
            async:false,
            success:function (data) {
                $("#permissionSelect").html("");
                for (var i=0;i<data.length;i++){
                    if (data[i].permissionLevel==permissionId) {
                        $("#permissionSelect").append("<option value='"+data[i].permissionLevel+"' selected='true'>"+data[i].permissionName+"</option>");
                    }else {
                        $("#permissionSelect").append("<option value='"+data[i].permissionLevel+"'>"+data[i].permissionName+"</option>");
                    }
                }
            }
        })
    })

    //确认修改
    $("#permissionBody").on('click','#permissionChangeOK',function () {
        var permissionLevel=$("#permissionSelect").val();
        $.ajax({
            url:"permission/updateresidentpermission",
            type:"post",
            dataType:"json",
            data:{
                "residentId":permissionResidentId,
                "permissionId":permissionLevel
            },
            async:false,
            success:function (data) {

            }
        })
        getPermissionlist();
    })
    //取消修改
    $("#permissionBody").on('click','#premissionChangeNo',function () {
        var tr= $(this).parent().parent().parent('tr');
        tr.children('td').remove();
        $.ajax({
            url: "permission/findpermission",
            type: "post",
            dataType: "json",
            data: {
                "id":permissionId
            },
            async: false,
            success: function (data) {
                tr.append("<td></td><td>"+permissionResidentName+"</td><td>"+data.name+"</td><td><div class='btn-list'><button class='btn btn-primary' id='permissionChangebtn' value='"+permissionResidentId+"'><i class='fe fe-settings'></i></button></div></td>");
            }
        })
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

    // 表格切换模块
    $("#tablecommunitybtn").click(function () {
        getCommunityList();
        $("#tablecommunity").css("display","block");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","none");
    });
    $("#tableresidentbtn").click(function () {
        getAllCommunityList();
        getResidentList();
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","block");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","none");
    });
    $("#tablepermissionbtn").click(function () {
        getPermissionlist();
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","block");
        $("#tablecomment").css("display","none");
    });
    $("#tableannouncementbtn").click(function () {
        getAnnouncementList();
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","block");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","none");
    });
    $("#tablecommentbtn").click(function () {
        getCommentList();
        $("#tablecommunity").css("display","none");
        $("#tableresident").css("display","none");
        $("#tableannouncement").css("display","none");
        $("#tablepermission").css("display","none");
        $("#tablecomment").css("display","block");
    })
})