/**
 * Created by sunguiyong on 2018/5/17.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");
document.write("<script language=javascript src='../js/util/popup_window.js'></script>");

//输入框内容清空
function clearInput() {
    $('#txtUsername').val("");
    $('#txtAddress').val("");
}

$('#storeRegister').click(function () {
    alert("test");
    register();
});


//注册信息填写完后，与后端交互
function register() {
    var storeName = $('#txtUsername').val();
    var address = $('#txtAddress').val();
    var username = ReadCookie("name");

    axios.get('/store/register', {
            params: {
                userName:username,
                name:storeName,
                address:address
            }
        })
        .then(function (response) {
            var resData = response.data.data;
            if (resData == "开通店铺成功") {
                document.location = "http://localhost:8080/agriculture/view/my_store.html";
               
            } else {
                Toast(resData, 2000);
                clearInput();
            }
        })
        .catch(function (response) {
            alert(response);
            console.log(response);
        });
}


$(document).ready(function () {
    $("#txtUsername").focus(function () {
        if ($('#txtUsername').val() == '') {
            $('#_userid').attr('class', 'bad');
            $('#_userid').html("店铺名不可为空");
        }
    });

    $("#txtUsername").blur(function () {
        if ($('#txtUsername').val() != '') {
            $('#_userid').attr('class', 'ok');
            $('#_userid').html("");
        }
    });

});
