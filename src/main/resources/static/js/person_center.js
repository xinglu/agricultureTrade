/**
 * Created by sunguiyong on 2018/5/25.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");

function init() {
    var username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    uInfo.innerHTML = "<a href='#' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
        "<a id='logout' href='#'>退出</a>";
}

//获取用户信息
function getUserInfo() {
    var username = ReadCookie("name");
    axios.get('/user/look/', {
        params: {
            userName: username
        }
    }).then(function (response) {
        console.log(response.data.data);
        var data = response.data.data;
        setTable(data);
    }).catch(function (response) {
    });
}

function setTable(data) {
    var allInfo = document.getElementById('user-all-info');
    var name = data.userName;
    var phone = data.phone;
    var address = data.address;
    var email = data.email;

    var html = "";
    html += "<table>" +
        "<tr>" +
        "<th class='keyname'>昵称：</th>" +
        "<th class='value'>" + name + "</th>" +
        "<th class='keyname'>电话：</th>" +
        "<th class='value'>" + phone + "</th>" +
        "</tr>" +
        "<tr>" +
        "<th class='keyname'>住址：</th>" +
        "<th class='value'>" + address + "</th>" +
        "<th class='keyname'>邮箱：</th>" +
        "<th class='value'>" + email + "</th>" +
        "</tr>" +
        "<tr>" +
        "<th></th>" +
        "</tr>" +
        "<tr>" +
        "<th class='keyname'></th>" +
        "<th class='keyname'></th>" +
        "<th class='keyname'></th>" +
        "<th style='float: right;'><input id='edit' type='button' value='编辑'></th>" +
        "</tr>" +
        "</table>";

    allInfo.innerHTML = html;
}

$(function () {
    init();
    getUserInfo();
});
