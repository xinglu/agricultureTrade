/**
 * Created by sunguiyong on 2018/5/23.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/common_init.js'></script>");

function init() {
    var username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    uInfo.innerHTML = "<a href='../view/personal_center.html' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
        "<a id='logout' href='#'>退出</a>";
}

$(function () {
    getList();
    init();
});