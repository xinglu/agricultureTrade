/**
 * Created by sunguiyong on 2018/5/17.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");

function getAuth() {
    var radioValue = $('input:radio[name="mtype"]:checked').val();
    if (radioValue == "买家用户") {
        return 3;
    } else if (radioValue == "经销商") {
        return 2;
    } else if (radioValue == "农业专家") {
        return 1;
    }
}

//输入框内容清空
function clearInput() {
    $('#txtUsername').val("");
    $('#txtPassword').val("");
    $('#userpwdok').val("");
    $('#txtAddress').val("");
    $('#uname').val("");
    $('#phone').val("");
    $('#email').val("");
}

//模拟用户点击
function openWin(url) {
    $('body').append($('<a href="' + url + '" target="_blank" id="openWin"></a>'))
    document.getElementById("openWin").click();//点击事件
    $('#openWin').remove();
}

//注册信息填写完后，与后端交互
function register() {
    var auth = getAuth();
    var userName = $('#txtUsername').val();
    var password = $('#txtPassword').val();
    var address = $('#txtAddress').val();
    var realName = $('#uname').val();
    var gender = $('input:radio[name="sex"]:checked').val();
    var phone = $('#phone').val();
    var email = $('#email').val();

    axios.get('/user/register', {
        params: {
            auth: auth,
            name: userName,
            password: password,
            address: address,
            realName: realName,
            gender: gender,
            phone: phone,
            email: email
        }
    })
        .then(function (response) {
            var resData = response.data.data;
            if (resData == "注册成功") {

                alert("注册成功，页面将跳转");
                SetCookie("name", userName);
                SetCookie("password", password);
                if (auth == 3) {//买家
                    document.location = "http://localhost:8080/agriculture/view/buyer.html";
                } else if (auth == 2) {//卖家

                } else if (auth == 1) {//专家

                }
            } else {
                alert(resData);
                clearInput();
            }
        })
        .catch(function (response) {
            alert(response);
            console.log(response);
        });
}

$('#register').click(function () {
    register();
});


function checkpwd() {
    if ($('#txtPassword').val() == '') {
        $('#_userpwdok').attr('class', 'bad');
        $('#_userpwdok').html("还未输入密码！");
    } else if ($('#txtPassword').val().length < 6) {
        $('#_userpwdok').attr('class', 'bad');
        $('#_userpwdok').html("密码不能小于6位");
    } else if ($('#userpwdok').val() != '' && $('#userpwdok').val() != $('#txtPassword').val()) {
        $('#_pwd').attr('class', 'bad');
        $('#_pwd').html("请输入确认密码");
    } else {
        $('#_userpwdok').attr('class', 'ok');
        $('#_userpwdok').html("");
    }
    if ($('#userpwdok').val() != '' && $('#userpwdok').val() == $('#txtPassword').val()) {
        $('#_pwd').attr('class', 'ok');
        $('#_pwd').html("");
    }
}

function checkpwdd() {
    if ($("#userpwdok").val() == '') {
        $('#_pwd').attr('class', 'bad');
        $('#_pwd').html("请再次输入密码");
    } else if ($('#userpwdok').val() == $('#txtPassword').val() && $('#userpwdok').val() != '') {
        $('#_pwd').attr('class', 'ok');
        $('#_pwd').html("");
    } else {
        $('#_pwd').attr('class', 'bad');
        $('#_pwd').html("两次输入密码不一致");
    }
}

$(document).ready(function () {
    $("#txtUsername").focus(function () {
        if ($('#txtUsername').val() == '') {
            $('#_userid').attr('class', 'bad');
            $('#_userid').html("用户名不可为空");
        }
    });

    $("#txtUsername").blur(function () {
        if ($('#txtUsername').val() != '') {
            $('#_userid').attr('class', 'ok');
            $('#_userid').html("");
        }
    });

    //密码判断
    $("#txtPassword").focus(function () {
        $('#_userpwdok').attr('class', 'bad');
        $('#_userpwdok').html("请设置密码");
        var timer = window.setInterval("checkpwd()", 2000);
    });

    $("#userpwdok").focus(function () {
        $('#_pwd').attr('class', 'bad');
        $('#_pwd').html("请输入确认密码");
        var timer = window.setInterval("checkpwdd()", 2000);
    });

    //email判断
    $("#email").focus(function () {
        $('#_email').attr('class', 'bad');
        $('#_email').html("请填写邮箱");
    });

    $("#email").blur(function () {
        var sEmail = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        if ($('#email').val() == '') {
            $('#_email').attr('class', 'bad');
            $('#_email').html("还没有填写邮箱！");
        } else if (!sEmail.exec($("#email").val())) {
            $('#_email').attr('class', 'bad');
            $('#_email').html("邮箱格式不正确");
        } else {
            $('#_email').attr('class', 'ok');
            $('#_email').html("");
        }
    });

    //真实姓名填写
    $("#uname").focus(function () {
        $('#_uname').attr('class', 'bad');
        $('#_uname').html("请如实填写真实姓名");
    });
    $("#uname").blur(function () {
        if ($('#uname').val() == '') {
            $('#_uname').attr('class', 'bad');
            $('#_uname').html("真实姓名还没填!");
        } else if ($('#uname').val().length < 2 || $('#uname').val().length > 4) {
            $('#_uname').attr('class', 'bad');
            $('#_uname').html("姓名为2-4个汉字");
        } else {
            $('#_uname').attr('class', 'ok');
            $('#_uname').html("");
        }
    });

    //手机号填写
    $("#phone").focus(function () {
        $('#_phone').attr('class', 'bad');
        $('#_phone').html("请填写您常用的手机号");
    });
    $('#phone').blur(function () {
        var sPhone = /^[1][3,4,5,7,8][0-9]{9}$/;
        if ($('#phone').val() == '') {
            $('#_phone').attr('class', 'bad');
            $('#_phone').html("手机号还没有填！");
        } else if ($('#phone').val().length != 11) {
            $('#_phone').attr('class', 'bad');
            $('#_phone').html("手机号错误");
        } else if ((!sPhone.test($("#phone").val()))) {
            $('#_phone').attr('class', 'bad');
            $('#_phone').html("手机号格式错误");
        } else {
            $('#_phone').attr('class', 'ok');
            $('#_phone').html("");
        }
    });
});
