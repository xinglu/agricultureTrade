/**
 * Created by sunguiyong on 2018/5/23.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");

function init() {
    var username = ReadCookie("name");
    $("#uInfo").innerHTML = "<a href='../view/login.html'>欢迎：" + username + "</a>" +
        "<a id='logout'>退出</a>";
}

$(function () {
   init();
});