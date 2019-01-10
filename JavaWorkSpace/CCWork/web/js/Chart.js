var ws = new WebSocket("ws://localhost:8080/webSocket");
/*
 *监听三种状态的变化 。js会回调
 */
ws.onopen = function(message) {

};
ws.onclose = function(message) {

};
ws.onmessage = function(message) {
    showMessage(message.data);
};
//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
    ws.close();
};
//关闭连接
function closeWebSocket() {
    ws.close();
}
//发送消息
function send() {
    var input = document.getElementById("msg");
    var text = input.value;
    ws.send(text);
    input.value = "";
}
function showMessage(message) {
    var text = document.createTextNode(message);
    var br = document.createElement("br")
    var div = document.getElementById("showChatMessage");
    div.appendChild(text);
    div.appendChild(br);
}



$(function () {
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

})