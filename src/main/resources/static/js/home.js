/**
 * Created by sunguiyong on 2018/5/16.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='js/common_init.js'></script>");

$(document).ready(function () {
    function showTime() {
        var show_day = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六');
        var time = new Date();
        var year = time.getFullYear();
        var month = time.getMonth() + 1;
        var date = time.getDate();
        var day = time.getDay();
        var now_time = year + '年' + month + '月' + date + '日' + ' ' + show_day[day];//+' '+hour+':'+minutes+':'+second;
        return now_time;
    }

    setInterval(function () {
        $("#nowTime").html(showTime)
    }, 500); //显示时分秒，并且秒数可以跳动
});

$(function () {
    getList();
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
    window.open(url);
}