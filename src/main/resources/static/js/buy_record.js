/**
 * Created by Amos on 2018/6/7.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/util/popup_window.js'></script>");
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/common_init.js'></script>");

var username;
$(function () {
    init();
    getBuyRecord();
});

function init() {
    username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    if (username == "") {
        Toast("您还没有登录！", 2000);
    } else {
        uInfo.innerHTML = "<a href='../view/personal_center.html' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
            "<a id='logout' href='#' onclick='logout()'>退出</a>";
    }
}

function getBuyRecord() {
    axios.get('/sell/get/orders', {
        params: {
            userName: username
        }
    }).then(function (response) {
        var data = response.data.data;
        var len = response.data.other.total;
        setDetailHtml(data, len);
    });
}

function setDetailHtml(data, len) {

    var html = "";
    var detailContent = document.getElementById("detailContent");

    if (len == 0) {
        html = "您还没有购买东西";
        detailContent.innerHTML = html;
        return;
    }

    for (var i = 0; i < data.length; i++) {
        html += "<div class='index-mod__order-container___1ur4- js-order-container'>" +
            "<div data-id='163280694797480695'" +
            " class='bought-wrapper-mod__trade-order___2lrzV bought-wrapper-mod__closed___3pIh6'>" +
            "<table class='bought-table-mod__table___3u4gN bought-wrapper-mod__table___3xFFM'>" +
            "<colgroup>" +
            "<col class=\bought-table-mod__col1___17JqJ'>" +
            "<col class='bought-table-mod__col2___1Y_Kl'>" +
            "<col class='bought-table-mod__col3___SzfHd'>" +
            "<col class='bought-table-mod__col4___3pLN6'>" +
            "<col class='bought-table-mod__col5___3dqJ_'>" +
            "<col class='bought-table-mod__col6___ImeZT'>" +
            "<col class='bought-table-mod__col7___RQijo'>" +
            "</colgroup>" +
            "<tbody class='bought-wrapper-mod__head___2vnqo'>" +
            "<td class='bought-wrapper-mod__head-info-cell___29cDO' colspan='7'><label" +
            " class='bought-wrapper-mod__checkbox-label___3Va60'><span " +
            "class='bought-wrapper-mod__checkbox___11anQ'></span><span " +
            "class='bought-wrapper-mod__create-time___yNWVS' id='orderTime'>"+ data[i].addTime +"</span></label>" +
            "<span><span>订单号</span><span>: </span><span id='orderSign'>" + data[i].orderNum + "</span></span>" +
            "</td>" +
            "</tr>" +
            "</tbody>" +
            "<tbody>" +
            "<tr>" +
            "<td class='sol-mod__no-br___1PwLO'>" +
            "<div class='ml-mod__container___dVhLg production-mod__production___1MKah suborder-mod__production___3WebF'>" +
            "<div class='ml-mod__media___ZSIgz'><a>" +
            "<img id='goodsPic' src='" + data[i].pic + "'><span></span></a>" +
            "</div>" +
            "<div style='margin-left:20px; float: left;'><p><span></span>" +
            "</p><p>" + data[i].sellName + "</p>" +
            "</div>" +
            "</div>" +
            "</td>" +
            "<td class='sol-mod__no-br___1PwLO'>" +
            "<div class='price-mod__price___157jz'>" +
            "<p><span>￥</span><span id='coast'>" + data[i].price + "</span>" +
            "</p> </div>" +
            "</td>" +
            "<td colspan = '2' >" +
            "<div> <p id = 'buyNum' > " + data[i].quantity + " </p>" +
            "</div>" +
            "</td>" +
            "<td>" +
            "<strong> <span> ￥ </span> <span id = 'relCoast' > " + data[i].price + " </span> </strong>" +
            "</td>" +
            "<td colspan = '2' ><p id = 'tradeStatus' > 交易成功 </p>" +
            "</td>" +
            "</tr>" +
            "</tbody>" +
            "</table>" +
            "</div>" +
            "</div>";
    }

    detailContent.innerHTML = html;
}

function logout() {
    SetCookie("name", "");
    SetCookie("password", "");
    var url = "http://localhost:8080/agriculture/index";
    window.open(url, "_self");
}