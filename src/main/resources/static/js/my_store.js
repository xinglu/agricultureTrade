/**
 * Created by Amos on 2018/6/2.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/util/popup_window.js'></script>");
document.write("<script language=javascript src='../js/handleCookie.js'></script>");

//userInfo
function init() {
    var username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    uInfo.innerHTML = "<a href='#' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
        "<a id='logout' href='#' onclick='logout()'>退出</a>";
}

function initTitle(storename) {
    var lay1 = document.getElementById('lay1');
    lay1.innerHTML = "<div class=‘con-width-1200 pos-rel clearfix’>" +
        "<h1>店铺：" + storename + "</h1>" +
        "</div>";
}

$(function () {
    init();
    getStoreName();
    getGoodsOfStore();
});

function setSellGoodsList(data, num) {
    var goodsList = document.getElementById("sell_goods_list");
    var addButton = "<div style=‘width: 100%; height: 200px;’>" +
        "<style>" +
        ".button {" +
        "background-color: #a5dea9; /* Green */" +
        "border: none;" +
        "color: black;" +
        "padding: 15px 20px;" +
        "text-align: center;" +
        "text-decoration: none;" +
        "display: inline-block;" +
        "font-size: 16px;" +
        "margin: 80px 500px;" +
        "cursor: pointer;" +
        "-webkit-transition-duration: 0.4s; /* Safari */" +
        "transition-duration: 0.4s;" +
        "}" +
        ".button2:hover {" +
        "box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);" +
        "}" +
        "</style>" +
        "<button class=\"button button2\" onclick='clickBtn()'>点击添加商品出售</button>" +
        "</div>";
    if (num != 0) {
        var html = "";
        for(var i = 0; i< data.length; i++) {
             html += "<li class='clearfix pos-rel my-checkbox big' id='item_117139'>" +
                "<a class='catname tit-bg-orange pos-abs' href='http://www.zgncpw.com/sell/list-778.html'>"+ data[i].goodsName +"</a><a " +
                "href='http://www.zgncpw.com/sell/show/117139/' class='font-gray-5' target='_blank'>" +
                "<img class='big test' src='"+ data[i].pic +"' " +
                "alt='' onmouseover='img_tip(this, this.src);' onmouseout='img_tip(this, '');'/>" +
                "<div class='pad-t-d-10 text-align-c clearfix'>" +
                "<h1 class='text-wid'>"+ data[i].sellName +"</h1>" +
                "<span class='fxl fs-16'>价钱："+ data[i].price +"</span>" +
                "<i class='fxr zgncpwfont btn-meired line-height-20 rad3 pad5 font-white'>&#xe7ca;</i>" +
                "</div>" +
                "</a>" +
                "</li>";
        }
        html += addButton;
        goodsList.innerHTML = html;
    }
    else{
         goodsList.innerHTML = addButton;
    }
}

//注册信息填写完后，与后端交互
function getStoreName() {
    var username = ReadCookie("name");

    axios.get('/goods/get/storeName', {
            params: {
                userName:username
            }
        })
        .then(function (response) {
            var resCode = response.data.code;
            var resData = response.data.data;
            if (resCode == 200) {
                initTitle(resData);
            } else {
                Toast("operation fail",2000);
            }
        })
        .catch(function (response) {
            alert(response);
            console.log(response);
        });
}

//获取对应用户的店铺中的商品列表
function getGoodsOfStore() {
    var username = ReadCookie("name");

    axios.get('/store/goods', {
            params: {
                userName:username
            }
        })
        .then(function (response) {
            var resCode = response.data.code;
            var resData = response.data.data;
            var num = response.data.other.total;
            setSellGoodsList(resData, num);

        })
        .catch(function (response) {
            alert(response);
            console.log(response);
        });
}

function clickBtn(){
    document.location = "http://localhost:8080/agriculture/view/sell_goods.html";
}

function logout(){
    SetCookie("name", "");
    SetCookie("password", "");
    var url = "http://localhost:8080/agriculture/index";
    window.open(url, "_self");
}