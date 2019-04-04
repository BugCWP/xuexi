$(function () {
    $("#MainOrder").children(".changeThing").first().css("display", "block");
    $("#MainOrder").children(".myThing").first().addClass("borderblack");
    $("#MainOrder").delegate(".myThing", "click", function () {
        $(this).siblings(".myThing").removeClass("borderblack");
        $(this).addClass("borderblack");
        $(".changeThing").css("display", "none");
        $(this).next().css("display", "block");
    });
    $("#MainOrder").delegate(".jiaohuanbtn", "click", function () {
        var changethingid = $(this).siblings(".input1").val();
        var mythingid = $(this).siblings(".input2").val();

        $.post("../ashx/DelectShopChar.ashx", { "myid": mythingid, "changeid": changethingid }, function (data) {
            if (data == "1") {
                window.location.href = "../Views/MyOrder.aspx";
            }
        });
    });
});