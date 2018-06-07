/**
 * Created by sunguiyong on 2018/5/23.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/common_init.js'></script>");
document.write("<script language=javascript src='../js/util/popup_window.js'></script>");

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

$(function () {
    getList();
    init();
    setGoodsSuggestList();
});

function setGoodsSuggestList() {
    axios.get('/goods/get/all', {
        params: {}
    }).then(function (response) {
        var data = response.data.data;
        setLi(data);
    });
}

function setLi(data) {
    var html = "";
    for (var i = 0; i < data.length; i++) {
        html += "<li><a target='_blank' onclick='clickGoods(\"" + data[i].goodsName + "\")'>" +
            "<img class='rad100' " +
            "src='" + data[i].goodsPic + "'/>" +
            "<p>" + data[i].goodsName + "</p></a>" +
            "</li>";
    }
    var goodsSug = document.getElementById("goods_sug");
    goodsSug.innerHTML = html;
}

function clickGoods(goodsName) {
    var url = "http://localhost:8080/agriculture/view/stores.html?kindName=&goodsName=" + goodsName;
    window.open(url, "_self");
}

function logout() {
    SetCookie("name", "");
    SetCookie("password", "");
    var url = "http://localhost:8080/agriculture/index";
    window.open(url, "_self");
}

$("#openStore").click(function () {
    var username = ReadCookie("name");

    if (username == "") {
        Toast("您还未登录！", 2000);
        return;
    }
    axios.get('/goods/get/storeName', {
            params: {
                userName: username
            }
        })
        .then(function (response) {
            var resCode = response.data.code;
            if (resCode == 200) {
                document.location = "http://localhost:8080/agriculture/view/my_store.html";
            } else {
                Toast("您还未开通店铺，请到个人中心开通", 2000);
            }
        })
        .catch(function (response) {

        });
});