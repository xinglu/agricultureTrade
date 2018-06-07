/**
 * Created by sunguiyong on 2018/5/25.
 */

axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/util/popup_button.js'></script>");

function init() {
    var username = ReadCookie("name");
    var uInfo = document.getElementById('uInfo');
    uInfo.innerHTML = "<a href='#' >欢迎：" + username + "&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</a>" +
        "<a id='logout' href='#' onclick='logout()'>退出</a>";
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
        "<th class='value_immutable'>" + name + "</th>" +
        "<th class='keyname'>电话：</th>" +
        "<th class='value_immutable'>" + phone + "</th>" +
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
        "<th style='float: right;'><input id='edit' type='button' value='编辑' onclick='editInput()'></th>" +
        "</tr>" +
        "</table>";

    allInfo.innerHTML = html;
}

$(function () {
    init();
    getUserInfo();
});

var statu = 0;

function editInput() {
    var edit = document.getElementById('edit');

    var item = document.getElementsByClassName("value");
    var immutable_item = document.getElementsByClassName("value_immutable");
    var item_length = item.length;
    var item_value = new Array(item_length);

    for (i = 0; i < item_length; i++) {
        item_value[i] = item[i].innerHTML;
    }
    if (statu == 0) {
        edit.value = '保存';
        for (i = 0; i < item_length; i++) {
            item[i].innerHTML = '<input type="txt" class="item_input" value="' + item_value[i] + '" />';
        }
        statu = 1;
    } else {
        var item_input = document.getElementsByClassName('item_input');
        edit.value = '编辑';
        var name = immutable_item[0].innerHTML;
        var phone = immutable_item[1].innerHTML;
        var address = item_input[0].value;
        var email = item_input[1].value;

        var sEmail = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;

        if (!sEmail.exec(email)) {
            alert("邮箱格式不正确");
            return false;
        }
        axios.get('/user/change/', {
            params: {
                name: name,
                phone: phone,
                address: address,
                email: email
            }
        }).then(function (response) {
            var data = response.data.data;
            if(data == "修改用户信息成功"){
                alert(data);
                statu = 0;
                window.location.reload(true);
            }
        });
    }
    return true;
}

$("#myStore").click(function () {
    lookMyStore();
});

//查看我的店铺
function lookMyStore() {
    var username = ReadCookie("name");

    axios.get('/goods/get/storeName', {
            params: {
                userName:username
            }
        })
        .then(function (response) {
            var resCode = response.data.code;
            if (resCode == 200) {
                document.location = "http://localhost:8080/agriculture/view/my_store.html";
            } else {
                msgbox('注册店铺?','请确认是否注册店铺',null,1,1);
            }
        })
        .catch(function (response) {

        });
}

function logout(){
    SetCookie("name", "");
    SetCookie("password", "");
    var url = "http://localhost:8080/agriculture/index";
    window.open(url, "_self");
}