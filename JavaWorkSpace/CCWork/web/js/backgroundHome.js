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
        $.ajax({
            url:"community/CommunityTotalCount",
            type:"post",
            dataType:"json",
            data:{},
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
          tr.append("<td></td><td><input id='communityChangeName' type='text' value='"+communityName+"' class='form-control'></td><td><input id='communityChangeAdress' type='text' value='"+communityAdress+"' class='form-control'></td><td><input id='communityChangeIntroduction' type='text' value='"+communityIntroduction+"' class='form-control'></td><td><div class='btn-list'><button id='communityChangeOK' class='btn btn-success'>OK</button><button id='communityChangeNO' class='btn btn-secondary' value='"+communityId+"'>NO</button></div></td>");
        $(".coummunityChangebtn").attr("disabled",true);
        $(".communityDeletebtn").attr("disabled",true);
    })

    //取消修改
    $("#communityBody").on('click','#communityChangeNO',function () {
        var id=$(this).val();
        var communityId;
        var communityName;
        var communityAdress;
        var communityIntroduction;
        var communityPicture;
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

    })




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