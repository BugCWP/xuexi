$(function () {
    //$(".Leftbtn").hover(function () {
    //    $(this).css("background-color", "black");
    //    $(this).find("a").css("color", "white");
    //}, function () {
    //    $(this).css("background-color", "white");
    //    $(this).find("a").css("color", "black");
    //});
    var pageIndex = 1;
    var pageSize = 9;
    var pagecount;
    //var NumberBegin = 1;
    var baiseimgsrc = $("#ThingImgShow").attr("src");
    getpage();
    getThingLiShi();
    
    function getpage() {
        var UserId;
        $.post("../ashx/FindShopThing.ashx", { "pageIndex": pageIndex, "pageSize": pageSize }, function (data) {
            $("div").remove(".ShopTianJiaing");
          for (var i = 0; i < data.length; i++) {
            var ThingId = data[i].ThingId;
            var ThingName = data[i].ThingName;
            var ThingType = data[i].ThingType;
            var ThingIntroduction = data[i].ThingIntroduction;
          
            UserId = data[i].UserId;
            $("#ShopTianJia").append("<div class='ShopTianJiaing'><input type='hidden' value='" + ThingId + "'/><div class='ShopTianJiaImg' id='" + ThingId + "'></div ><span class='ShopThingName'>" + ThingName + "</span> <br /> <span class='ShopThingType'>" + ThingType + "</span> <div class='ShopThingIntroduction'>" + ThingIntroduction + "</div><div class='btn btn-default ShopThingBtnXiuGai'>修改</div> <div class='btn btn-default ShopThingBtnShanChu'>删除</div></div>");
            //$("#ShopTianJia").append("<div class='ShopTianJiaing'><div class='ShopTianJiaImg'> </div ><span class='ShopThingName'>" + ThingName + "</span> <br /> <span class='ShopThingType'>" + ThingType + "</span> <div class='ShopThingIntroduction'>" + ThingIntroduction + "</div><div class='btn btn-default ShopThingBtnXiuGai'>修改</div> <div class='btn btn-default ShopThingBtnShanChu'>删除</div></div>");
            $.post("../ashx/FindShopThing.ashx", { "ThingId": ThingId }, function (data2) {
                $("#" + data2.ThingId + "").append("<img src='" + data2.ImgUrl[0] + "'/>");
            }, "json");
          }
          $.post("../ashx/FindShopThingCount.ashx", { "UserId": UserId }, function (datacount) {
              $("div").remove(".pageBTN");
              var count = parseInt(datacount);
              pagecount = count / pageSize + 1;
              if (pageIndex < 3) {
                  for (i = 1; i <= pagecount; i++) {
                      $("#pagebtn").append("<div class='pageBTN'>" + i + "</div>");
                  }
              } else if (pagecount - pageIndex < 2) {
                  for (var i = pagecount - 5; i < pagecount; i++) {
                      $("#pagebtn").append("<div class='pageBTN'>" + i + "</div>");
                  }
              } else {
                  for (var i = pageIndex - 2; i <= pageIndex + 2; i++) {
                     $("#pagebtn").append("<div class='pageBTN'>" + i + "</div>");
                  }
              }
            
              for (i = 0; i <= 5; i++) {
                  if ($("#pagebtn").eq(i).text() == pageIndex) {
                      $("#pagebtn").eq(i).css("color", "gray");
                  }
              }
              
          });
       }, "json");
    }

   

    $("#pageup").click(function () {
        if (pageIndex > 1) {
            pageIndex = pageIndex - 1;
            getpage();
        }  
    });
    $("#pagedown").click(function () {
        if (pageIndex < pagecount-1) {
            pageIndex = pageIndex + 1;
            getpage();
        }
    });

    $("#pagebtn").delegate(".pageBTN", "click", function () {
        var index = ($(this).text());
        if (pageIndex != index) {
          pageIndex = index;
          getpage();
        }
    });

    $(".Leftbtn").click(function () {
        $(this).css("background-color", "black");
        $(this).find("a").css("color", "white");
        $(this).siblings(".Leftbtn").css("background", "white");
        $(this).siblings(".Leftbtn").find("a").css("color", "black");
    });
    $("#LeftTianJia").click(function () {
        $("#ShopTianJia").css("display", "block");
        $("#ShopTianJia").siblings().css("display", "none");
    });
    $("#LeftLiShi").click(function () {
        $("#ShopLiShi").css("display", "block");
        $("#ShopLiShi").siblings().css("display", "none");
    });
    $("#LeftSelf").click(function () {
        $("#ShopSelf").css("display", "block");
        $("#ShopSelf").siblings().css("display", "none");
    });

    function getThingLiShi() {
        $("#ShopLiShi").children().remove();
        $.post("../ashx/FindShopThingLiShi.ashx", {}, function (dataLiShi) {
            
            for (var i = 0; i < dataLiShi.length; i++) {
                var ThingId = dataLiShi[i].ThingId;
                var ThingName = dataLiShi[i].ThingName;
                var ThingType = dataLiShi[i].ThingType;
                var ThingTime = dataLiShi[i].ThingTime;
                var ThingDelect = dataLiShi[i].ThingDelect;
                var UserId = dataLiShi[i].UserId;
                //console.log(ThingDelect);
                if (ThingDelect == "True") {
                    $("#ShopLiShi").append("<div class='ShopLiShibtn'><input type='hidden' value='" + ThingId + "' class='input1'/><input type='hidden' value='" + UserId + "' class='input2'><div class='ShopLiShiimg' id='Li" + ThingId + "'></div ><div class='ShopLiShiName'>" + ThingName + "</div><div class='ShopLiShiType'>" + ThingType + "</div><div class='ShopLiShiTimetext'>上传时间:</div><div class='ShopLiShiTime'>" + ThingTime + "</div> <div class='ShopLiShiDeleteZhuangtai'>物品状态：</div> <div class='ShopLiShiDelete'>在售</div><div class='btn btn-default ShopLiShiXiangQing'>详情</div></div >");
                } else {
                    $("#ShopLiShi").append("<div class='ShopLiShibtn'><input type='hidden' value='" + ThingId + "' class='input1'/><input type='hidden' value='" + UserId + "' class='input2'><div class='ShopLiShiimg' id='Li" + ThingId + "'></div ><div class='ShopLiShiName'>" + ThingName + "</div><div class='ShopLiShiType'>" + ThingType + "</div><div class='ShopLiShiTimetext'>上传时间:</div><div class='ShopLiShiTime'>" + ThingTime + "</div> <div class='ShopLiShiDeleteZhuangtai'>物品状态：</div> <div class='ShopLiShiDeletered'>已售</div><div class='btn btn-default ShopLiShiXiangQing'>详情</div></div >");
                }
                $.post("../ashx/FindShopThing.ashx", { "ThingId": ThingId }, function (data2) {
                    $("#Li" + data2.ThingId + "").append("<img src='" + data2.ImgUrl[0] + "' />")
                }, "json");
            }
        }, "json");
    }
    $("#ShopLiShi").delegate(".ShopLiShiXiangQing", "click", function () {
        var ThingId = $(this).siblings(".input1").val();
        var UserId = $(this).siblings(".input2").val();
        window.location.href = "../Views/ThingInformation.aspx?ThingId=" + ThingId + "&UserId=" + UserId + "";
    });
    var imgfile = new Array();
    var imgi = 0;
    $("#TianJiapageClose").click(function () {
        $("#TianJiapage").css("display", "none");
        imgfile.splice(0, imgfile.length);
        imgi = 0;
        $("#Thingname").val("");
        $("#ThingType").val("");
        $("#ThingIntroduction").val("");
        $("#ThingImgJia").children().remove();
        $("#ThingImgShow").attr("src", "../Images/start.png");
        getThingLiShi();

    });
    $("#ShopTianJiabtn").click(function () {
        $("#TianJiapage").css("display", "block");
       
        $.post("../ashx/FingShopThingType.ashx", {}, function (dataType) {
            $("#ThingType").children().remove();
            for (var i = 0; i < dataType.length; i++) {
                $("#ThingType").append("<option value='" + dataType[i] + "'>" + dataType[i] + "</option>");
               
            }
        }, "json");
    });
    

    $("#TingImgFile").change(function (e) {
        var imgbox = e.target;
        uploadImg($("#ThingImgJia"), imgbox);
        
       
    })

    function uploadImg(element,tag) {
        var file = tag.files[0];
        var imgsrc;
        if (!/image\/\w+/.test(file.type)) {
            alert("此文件不是图片！")
            return false;
        }
        imgfile[imgi] = file;
        imgi++;
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            imgsrc = this.result;
            //var imgs = document.createElement("img");
            //$(imgs).attr("src", imgsrc);
            var divs = document.createElement("div");
            var imgs = document.createElement("img");
            var spans = document.createElement("span");
            $(imgs).attr("src", imgsrc);
            $("#ThingImgShow").attr("src", imgsrc);
            $(".ThingimgSuoimg").removeClass("ThingimgBorder");
            $(divs).addClass("ThingimgSuo");
            $(imgs).addClass("ThingimgSuoimg");
            $(imgs).addClass("ThingimgBorder");
            $(spans).addClass("ThingimgDelect");
            $(divs).append(imgs);
            $(divs).append(spans);
            element.append(divs);
        }
    }

    
    $("#ThingImgJia").delegate(".ThingimgSuo", "click", function () {
        var imgsrc = $(this).children("img").attr("src");
        $(this).children("img").addClass("ThingimgBorder");
        $(this).siblings().children("img").removeClass("ThingimgBorder");
        $("#ThingImgShow").attr("src", imgsrc);

    });
    
    $("#ThingImgJia").delegate(".ThingimgDelect", "click", function () {
       var index= $(this).parent(".ThingimgSuo").index();
        $(this).parent(".ThingimgSuo").remove();
        $("#ThingImgShow").attr("src","../Images/start.png");
        imgfile[index] = null;
    });


    //$.post("../ashx/FingShopThingType.ashx", {}, function (dataType) {
    //    for (var i = 0; i < dataType.length; i++) {
    //        $("#ThingType").append("<option value=" + dataType[i] + ">" + dataType[i] + "</option>");
    //        $("#XiuGaiType").append("<option value=" + dataType[i] + ">" + dataType[i] + "</option>");
    //    }
    //},"json");

    $("#ThingTiJiaobtn").click(function () {
        var ThingName = $("#Thingname").val();
        var ThingType = $("#ThingType").val();
        var ThingId = Math.random().toString(36).substr(2);
        var ThingIntroduction = $("#ThingIntroduction").val();
        $.post("../ashx/ShopThingAdd.ashx", { "ThingId": ThingId, "ThingName": ThingName, "ThingType": ThingType, "ThingIntroduction": ThingIntroduction }, function (dataShopThing) {
            if (dataShopThing == "1") {
                for (var i = 0; i < imgi; i++) {
                    if (imgfile[i] != null) {
                    var file = imgfile[i];
                    console.log(file);
                    var formdata = new FormData();
                    formdata.append("file", file);
                    formdata.append("ThingId", ThingId);
                    formdata.append("ThingName", ThingName);
                   // $.post("../ashx/ThingImgUrlAdd.ashx", { "file": file, "ThingId": ThingId, "ThingName": ThingName }, function (dataimg) {                 
                   //});
                    $.ajax({
                        url: "../ashx/ThingImgUrlAdd.ashx",
                        type: "post",
                        cache: false,
                        data: formdata,
                        processData: false,
                        contentType: false,
                        success: function (dataimg) {
                            if (dataimg == "") {
                                alert("失败");
                            } else {
                                $("#TianJiapageClose").click();
                                getpage();
                            }
                        },
                        error: function () { }
                    });
                    }
                   
                }
            }
        });
    })
    //function imgview(file) {
    //    var ThingImgJia = document.getElementById("ThingImgJia");
    //    if (file.files && file.files[0]) {
    //        var reader = new FileReader();
    //        reader.onload = (function (evt) {
    //            ThingImgJia.innerHTML = "<img src='" + evt.target.result + "'/>";
    //        })(file);
    //        reader.readAsDataURL(file.files[0]);
    //    }
    //}


    $("#ShopTianJia").delegate(".ShopThingBtnShanChu", "click", function () {
        var ThingId = $(this).siblings("input").attr("value");
        //$(this).parent(".ShopTianJiaing").remove();
        $.post("../ashx/DelectShopThing.ashx", { "ThingId": ThingId }, function (data) {
            if (data == "1") {
                getpage();
                getThingLiShi();
            }
        });
    });

    $("#ShopTianJia").delegate(".ShopThingBtnXiuGai", "click", function () {
        $("#ThingXiuGaipage").css("display", "block");
        var ThingId = $(this).siblings("input").attr("value");
        $("#XiuGaiId").attr("value", ThingId);
        $.post("../ashx/FindShopThingByThingId.ashx", { "ThingId": ThingId }, function (Alldata) {
            $("#XiuGainame").val(Alldata.ThingName);
            $("#XiuGaiIntroduction").text(Alldata.ThingIntroduction);
            $.post("../ashx/FingShopThingType.ashx", {}, function (dataType) {
                $("#XiuGaiType").children().remove();
                for (var i = 0; i < dataType.length; i++) {
                   $("#XiuGaiType").append("<option value='" + dataType[i] + "'>" + dataType[i] + "</option>");
                }
            $.post("../ashx/FindThingImgUrl.ashx", { "ThingId": ThingId }, function (dataurl) {
               console.log(dataurl);
               for (var i = 0; i < dataurl.length; i++) {
                $("#XiuGaiimg").append("<div class='XiuGaiimgdiv'><img src='" + dataurl[i] + "'><span class='XiuGaiimgspan'></span></div>");
                //$("#XiuGaiimg").append("<img src='" + dataurl[i] + "'>");
            }
        },"json");
        }, "json");
        }, "json");
        
      
       
    });
    var xiugaiFile = new Array();
    var xiugaii = 0;
    $("#XiuGaiImgFile").change(function (e) {
        var imgbox = e.target;
        uploadImg2($("#XiuGaiimg"), imgbox);


    })

    function uploadImg2(element, tag) {
        var file = tag.files[0];
        var imgsrc;
        if (!/image\/\w+/.test(file.type)) {
            alert("此文件不是图片！")
            return false;
        }
        xiugaiFile[xiugaii] = file;
        xiugaii++;
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            imgsrc = this.result;
            //var imgs = document.createElement("img");
            //$(imgs).attr("src", imgsrc);
            var divs = document.createElement("div");
            var imgs = document.createElement("img");
            var spans = document.createElement("span");
            $(imgs).attr("src", imgsrc);
            $("#ThingImgShow").attr("src", imgsrc);
            $(divs).addClass("XiuGaiimgdivx");
            $(spans).addClass("XiuGaiimgspanx");
            $(divs).append(imgs);
            $(divs).append(spans);
            element.append(divs);
        }
    }
    $("#XiuGaiimg").delegate(".XiuGaiimgspanx", "click", function () {
        var index = $(this).parent(".XiuGaiimgdivx").index();
        $(this).parent(".XiuGaiimgdivx").remove();
        xiugaiFile[index] = null;
    });
    $("#XiuGaiimg").delegate(".XiuGaiimgspan", "click", function () {  
        var url = $(this).siblings("img").attr("src");
        var Thingid = $("#XiuGaiId").val();
        $(this).parent(".XiuGaiimgdiv").remove();
        $.post("../ashx/DelectThingImg.ashx", { "url": url, "id": Thingid }, function (data) {
            if (data == "1") {
                
            }
        });
    });
    $("#XiuGaiTiJiaobtn").click(function () {
        var ThingName = $("#XiuGainame").val();
        var ThingType = $("#XiuGaiType").val();
        var ThingIntroduction = $("#XiuGaiIntroduction").text();
        var ThingId = $("#XiuGaiId").val();
        $.post("../ashx/UpdateShopThing.ashx", { "ThingId": ThingId, "ThingName": ThingName, "ThingType": ThingType, "ThingIntroduction": ThingIntroduction }, function (dataok) {
            if (dataok == "1") {
                for (var i = 0; i < xiugaii; i++) {
                    if (xiugaiFile[i] != null) {
                        var file = xiugaiFile[i];
                        var formdata = new FormData();
                        formdata.append("file", file);
                        formdata.append("ThingId", ThingId);
                        formdata.append("ThingName", ThingName);
                        $.ajax({
                            url: "../ashx/ThingImgUrlAdd.ashx",
                            type: "post",
                            cache: false,
                            data: formdata,
                            processData: false,
                            contentType: false,
                            success: function (dataimg) {
                                if (dataimg == "") {
                                    alert("失败");
                                } else {
                                    $("#XiuGaiClose").click();
                                    getpage();
                                    getThingLiShi();
                                }
                            },
                            error: function () { }
                        });
                    }

                }
            }
        });
       
    });

    $("#XiuGaiClose").click(function () {
        $("#ThingXiuGaipage").css("display", "none");
        $("#XiuGaiimg").children().remove();
        $("#XiuGainame").val("");
        $("#XiuGaiIntroduction").text("");
        xiugaiFile.splice(0, xiugaiFile.length);
        xiugaii = 0;
    });

    $("#ChangeUser").click(function () {
        console.log(1);
        var name = $("#ChangeName").val();
        var pwd = $("#ChangePwd").val();
        var phone = $("#ChangePhone").val();
        var email = $("#ChangeEmail").val();
        var adress = $("#UAdress").text();
        var id = $("#UID").val();
        $.post("../ashx/UpdateShopUserInfo.ashx", { "name": name, "pwd": pwd, "phone": phone, "email": email, "adress": adress, "id": id }, function (data) {
            if (data == "1") {
                alert("修改成功");
            }
        })
    })
});