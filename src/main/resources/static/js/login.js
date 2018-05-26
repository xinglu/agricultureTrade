/**
 * Created by sunguiyong on 2018/5/26.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/';
axios.defaults.headers.post['Content-Type'] = 'text/plain';
document.write("<script language=javascript src='../js/handleCookie.js'></script>");

function userLogin() {
    var userName = $('#txtUsername').val();
    var password = $('#txtPassword').val();

    var res = checksubmit(userName, password);
    if (res == false) {
        return;
    }
    axios.get('/user/login/', {
        params: {
            loginName: userName,
            password: password
        }
    }).then(function (response) {
        var data = response.data.data;
        if (data != "登录失败") {
            alert("登录成功");
            SetCookie("name", userName);
            SetCookie("password", password);
            if (data.auth == 3) {//买家
                document.location = "http://localhost:8080/agriculture/view/buyer.html";
            } else if (data.auth == 2) {//卖家

            } else if (data.auth == 1) {//专家

            }
        }

    }).catch(function (response) {

    });
}
function checksubmit(name, password) {
    if (name == '') {
        alert('请输入手机号/会员');
        $('#txtUsername').focus();
        return false;
    } else if (password == '') {
        alert('请输入密码');
        $('#txtPassword').focus();
        return false;
    }
    return true;
}