/**
 * Created by Amos on 2018/6/6.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/util/popup_window.js'></script>");
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/common_init.js'></script>");

var sellName;
var price;

$(function () {
    var getInfo = window.location.search;
    getInfo = decodeURI(getInfo.split('=')[1]);
    getInfo = getInfo.split(',');
    var picPath = getInfo[0];
    sellName = getInfo[1];
    price = getInfo[2];
    var sellNum = getInfo[3];
    var goodsUnit = price.split('/')[1];
    var goodsId = getInfo[4];
    var storeId = getInfo[5];
    initDetail(picPath, sellName, price, sellNum, goodsUnit, goodsId, storeId);
    init();
});

function init() {
    var username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    if (username == "") {
        uInfo.innerHTML = "<a href='../view/login.html' >登录&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
            "<a href='../view/register.html' >注册</a>";
    } else {
        uInfo.innerHTML = "<a href='../view/personal_center.html' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
            "<a id='logout' href='#' onclick='logout()'>退出</a>";
    }
}

function initDetail(picPath, sellName, price, sellNum, goodsUnit, goodsId, storeId) {
    document.getElementById("title").value = sellName;
    document.getElementById("price").value = price;
    document.getElementById("sellNum").value = sellNum;
    document.getElementById("goodsId").value = goodsId;
    document.getElementById("storeId").value = storeId;
    document.getElementById("userName").value = ReadCookie("name");
    ;
    document.getElementById("unit").innerHTML = goodsUnit;
    document.getElementById("J_ImgBooth").src = picPath;
}

function logout() {
    SetCookie("name", "");
    SetCookie("password", "");
    var url = "http://localhost:8080/agriculture/index";
    window.open(url, "_self");
}

//jQuery提交  
$("#buyBtn").click(function () {
    var username = ReadCookie("name");
    if (username == "") {
        Toast("您还没有登录，请先登录", 2000);
    } else {
        $("#myForm").submit();
    }
});

$("#cancelBtn").click(function () {
   window.history.back(-1);
});