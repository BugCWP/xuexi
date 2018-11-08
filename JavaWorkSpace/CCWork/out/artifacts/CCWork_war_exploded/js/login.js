$(function () {

    findCookie();
    loginbtntrue();
    $("#loginbtn").click(function () {
        var flag=$("#remberpass").is(':checked');
        var username=$("#exampleInputEmail1").val();
        var userpassword=$("#exampleInputPassword1").val();
        if (flag){
            setCookie("username",username,10);
            setCookie(username,userpassword,10);
        } else{
            setCookie("username","",10);
        }
    })

    //查找cookie
    function findCookie() {
        var username=getCookie("username");
        if(username!=""){
            $("#exampleInputEmail1").val(username);
            var userpassword=getCookie(username);
            $("#exampleInputPassword1").val(userpassword);
        }
    }

    //当有cookie时登陆按钮
    function loginbtntrue() {
        var username=$("#exampleInputEmail1").val();
        var userpassword=$("#exampleInputPassword1").val();
        if (username!=""&&userpassword!=""){
            $("#loginbtn").attr('disabled',false);
        }
    }

    //创建cookie
    function setCookie(cname,cvalue,exdays)
    {
        var d = new Date();
        d.setTime(d.getTime()+(exdays*24*60*60*1000));
        var expires = "expires="+d.toGMTString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    //获取cookie
    function getCookie(cname)
    {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++)
        {
            var c = ca[i].trim();
            if (c.indexOf(name)==0) return c.substring(name.length,c.length);
        }
        return "";
    }

    //提交检查
    $("#exampleInputEmail1").blur(function () {
        var username=$("#exampleInputEmail1").val();
        var userpassword=$("#exampleInputPassword1").val();
        if (username!=""&&userpassword!=""){
            $("#loginbtn").attr('disabled',false);
        } else {
            $("#loginbtn").attr('disabled',true);
        }
    })
    $("#exampleInputPassword1").blur(function () {
        var username=$("#exampleInputEmail1").val();
        var userpassword=$("#exampleInputPassword1").val();
        if (username!=""&&userpassword!=""){
            $("#loginbtn").attr('disabled',false);
        } else {
            $("#loginbtn").attr('disabled',true);
        }
    })
})