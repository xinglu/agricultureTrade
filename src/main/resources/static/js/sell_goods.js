/**
 * Created by Amos on 2018/6/4.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/util/popup_window.js'></script>");
document.write("<script language=javascript src='../js/handleCookie.js'></script>");


var kind = [];
var goods = [
    ["请选择"]
];
var kindLen = 0;
var goodsLen = 1;
//每个种类的商品，在页面中显示的列表
function getKindsList() {
    axios.get('/goods/gk-list', {
        params: {}
    }).then(function (response) {
        var data = response.data.data;
        setValue(data);
    }).catch(function (response) {
        alert(response);
    });
}

function setValue(data) {
    for (var i = 0; i < data.length; i++) {
        kind[kindLen++] = data[i].kindName;
        goods[i] = new Array(data[i].goodsList.length);
        for (var j = 0; j < data[i].goodsList.length; j++) {
            goods[i][j] = data[i].goodsList[j];
        }
    }
}
$("#jia").click(function () {
    var selJia = document.getElementById("jia");
    //申请空间
    selJia.length = kind.length;
    //添加元素
    for (var i = 0; i < kind.length; i++) {
        selJia.options[i].text = kind[i];
        selJia.options[i].value = kind[i];
    }
});
window.onload = function () {
    kind = [];
    kindLen = 0;
    init();
    getKindsList();
};

function ChangeExampleSelect(index) {
    var selExa = document.getElementById("example");
    selExa.length = goods[index].length;

    for (var i = 0; i < goods[index].length; i++) {
        selExa.options[i].text = goods[index][i];
        selExa.options[i].value = goods[index][i];
    }
}

$("#showthumb2").click(function () {

    var html = "<div id='Dtop' style='z-index: 999; position: absolute; width: 250px; left: 290px; top: 202px;'>" +
        "<div class='dbody'>" +
        "<div class='dhead' ondblclick='cDialog();' onmousedown='dragstart(\"Dtop\", event);' onmouseup='dragstop(event);'" +
        "onselectstart='return false;'><span onclick='cDialog();' title='关闭[快捷键Esc]'></span>上传图片" +
        "</div>" +
        "<div class='dbox'>" +
        "<input type='hidden' name='fid' value='2'>" +
        "<input type='hidden' name='moduleid' value='5'>" +
        "<input type='hidden' name='from' value='album'>" +
        "<input type='hidden' name='old' value=''> " +
        "<form  enctype='multipart/form-data' id='fileForm'>" +
        "<table cellpadding='3'> " +
        "<tbody> " +
        "<tr id='local_url'> " +
        "<td>" +
        "<input id='upalbum' type='file' size='20' name='fileField' >" +
        "</td>" +
        "</tr>" +
        "<tr style='display:none'>" +
        "<td>宽度 <input type='text' size='3' name='width' value='460'> px &nbsp;&nbsp;&nbsp;高度 <input " +
        "type='text' size='3' name='height' value='320'> px " +
        "</td>" +
        "</tr>" +
        "<tr>" +
        "<td><input type='button' class='btn' value='上传' onclick='uploadPic();cDialog()'>&nbsp;&nbsp;<input " +
        "type='button' class='btn' value='取 消' id='cancelBtn' onclick='cDialog();'></td>" +
        "</tr>" +
        "</tbody>" +
        "</table>" +
        "</form>" +
        "</div>" +
        "<div class='dsize'>" +
        "<div onmousedown='resizestart(\"Dtop\", event);' onmouseup='resizestop(event);'></div>" +
        "</div>" +
        "</div>" +
        "</div>";
    var tr_test = document.getElementById("tr_test");
    tr_test.innerHTML = html;
});

var picPath = null;
$("#submitBtn").click(function () {
    var userName = ReadCookie("name");
    var title = document.getElementById("title").value;
    var goodsName = document.getElementById("example").value;
    var price = document.getElementById("price").value;
    var quantity = document.getElementById("totalQuantity").value;
    var goodsUnit = document.getElementById("goodsUnit").value;

    price = price +"/"+goodsUnit;
    quantity = quantity+"("+goodsUnit+")";

    axios.get('/sell/add/sellGoods', {
        params: {
            sellName: title,
            userName: userName,
            goodsName: goodsName,
            picPath: picPath,
            price: price,
            quantity: quantity
        }
    }).then(function (response) {
        var data = response.data.data;
        if(data == "添加商品成功"){
            document.location = "http://localhost:8080/agriculture/view/my_store.html";
        }else{
            Toast(data, 2000);
        }
    }).catch(function (response) {
    });
});

function uploadPic() {
    var fileM=document.querySelector("#upalbum");
    var fileObj = fileM.files[0];

    var formData = new FormData();
    formData.append('file', fileObj);

    $.ajax({
        url: "http://localhost:8080/agriculture/sell/upload/pic",
        type: "post",
        dataType: "json",
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            picPath = data.data;
            var goodsPic = document.getElementById("showthumb2");
            goodsPic.src = picPath;
            var tr_test = document.getElementById("tr_test");
            tr_test.innerHTML = "";
        }
    });
}

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

function logout(){
    SetCookie("name", "");
    SetCookie("password", "");
    var url = "http://localhost:8080/agriculture/index";
    window.open(url, "_self");
}