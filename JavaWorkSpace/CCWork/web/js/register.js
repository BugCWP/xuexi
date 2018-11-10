$(function () {

    // 获取社区列表
    $.post("/community/listAllCommunity",{},function (data) {
        for (var i=0;i<data.length;i++){
           $("select").append("<option value='"+data[i].communityId+"'>"+data[i].communityName+"</option>");
       }
    },"json")

    //同意条款事件
    $("#agreecb").click(function () {
        var name=$("#residentName").val();
        var account=$("#residentAccount").val();
        var password=$("#residentPassword").val();
        var community=$("#residentCommunity").val();
        var flag=$("#agreecb").is(':checked');
        if (flag==true){
            if (name!=""&&account!=""&&password!=""&&community!="") {
                $("#registerbtn").attr('disabled',false);
            }
        }else {
            $("#registerbtn").attr('disabled',true);
        }
    })

    //判断是否填空
   $("#residentName").blur(function () {
       var name=$("#residentName").val();
       var account=$("#residentAccount").val();
       var password=$("#residentPassword").val();
       var community=$("#residentCommunity").val();
       var flag=$("#agreecb").is(':checked');
       if(name==""){
           $("#registerbtn").attr('disabled',true);
       }else if(name!=""&&account!=""&&password!=""&&community!=""&&flag==true){
           $("#registerbtn").attr('disabled',false);
       }
   })
    $("#residentAccount").blur(function () {
        var name=$("#residentName").val();
        var account=$("#residentAccount").val();
        var password=$("#residentPassword").val();
        var community=$("#residentCommunity").val();
        var flag=$("#agreecb").is(':checked');
        if(account==""){
            $("#registerbtn").attr('disabled',true);
        }else if(name!=""&&account!=""&&password!=""&&community!=""&&flag==true){
            $("#registerbtn").attr('disabled',false);
        }
    })
    $("#residentPassword").blur(function () {
        var name=$("#residentName").val();
        var account=$("#residentAccount").val();
        var password=$("#residentPassword").val();
        var community=$("#residentCommunity").val();
        var flag=$("#agreecb").is(':checked');
        if(password==""){
            $("#registerbtn").attr('disabled',true);
        }else if(name!=""&&account!=""&&password!=""&&community!=""&&flag==true){
            $("#registerbtn").attr('disabled',false);
        }
    })
    $("#residentCommunity").blur(function () {
        var name=$("#residentName").val();
        var account=$("#residentAccount").val();
        var password=$("#residentPassword").val();
        var community=$("#residentCommunity").val();
        var flag=$("#agreecb").is(':checked');
        if(community==""){
            $("#registerbtn").attr('disabled',true);
        }else if(name!=""&&account!=""&&password!=""&&community!=""&&flag==true){
            $("#registerbtn").attr('disabled',false);
        }
    })
})