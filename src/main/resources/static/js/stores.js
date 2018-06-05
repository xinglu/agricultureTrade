/**
 * Created by Amos on 2018/6/3.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/common_init.js'></script>");

$(function () {
    var perimeters = window.location.search;
    var kindName = decodeURI(perimeters.substr(1).split('&')[0]);
    kindName = kindName.split('=')[1];
    var goodsName = decodeURI(perimeters.substr(1).split('&')[1]);
    goodsName = goodsName.split('=')[1];
    var data;
    if (kindName != "") {
        data = kindName;
    }
    if (goodsName != "") {
        data = goodsName;
    }
    init();
    setTitle(data);
    makeSurePageContent(kindName, goodsName);
});

function makeSurePageContent(kindName, goodsName) {

    axios.get('/store/condition/get_goods', {
        params: {
            kindName: kindName,
            goodsName: goodsName
        }
    }).then(function (response) {
        var data = response.data.data;
        var num = response.data.other.total;
        setGoodsLIst(data, num);
    });
}

function setGoodsLIst(data, num) {
    var goodsList = document.getElementById("sell_goods_list");
    var addButton = "<div style='width: 100%; height: 200px;'>" +
        "<img style='width: 100%;height: 195px' src='../pic/noData.png'>" +
        "</div>";
    if (num != 0) {
        var html = "";
        for (var i = 0; i < data.length; i++) {
            html += "<li class='clearfix pos-rel my-checkbox big' id='item_117139'>" +
                "<a class='catname tit-bg-orange pos-abs' onclick='clickGoods(\"" + data[i].goodsName + "\")' >" + data[i].goodsName + "</a><a " +
                "href='http://www.zgncpw.com/sell/show/117139/' class='font-gray-5' target='_blank'>" +
                "<img class='big test' src='" + data[i].pic + "' " +
                "alt='' onmouseover='img_tip(this, this.src);' onmouseout='img_tip(this, '');'/>" +
                "<div class='pad-t-d-10 text-align-c clearfix'>" +
                "<h1 class='text-wid'>" + data[i].sellName + "</h1>" +
                "<span class='fxl fs-16'>价钱：" + data[i].price + "</span>" +
                "<i class='fxr zgncpwfont btn-meired line-height-20 rad3 pad5 font-white'>&#xe7ca;</i>" +
                "</div>" +
                "</a>" +
                "</li>";
        }
        goodsList.innerHTML = html;
    }
    else {
        goodsList.innerHTML = addButton;
    }
}

function setTitle(data) {
    var lay = document.getElementById("lay1");
    lay.innerHTML = "<div class='con-width-1200 pos-rel clearfix'>" +
        "<h1>供应：" + data + "</h1>" +
        "</div>";
}
function init() {
    var username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    if (username == "") {
        uInfo.innerHTML = "<a href='../view/login.html' >登录&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
            "<a href='../view/register.html' >注册</a>";
    } else {
        uInfo.innerHTML = "<a href='../view/personal_center.html' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
            "<a id='logout' href='#'>退出</a>";
    }
}

function clickGoods(data) {
    alert("test");
}