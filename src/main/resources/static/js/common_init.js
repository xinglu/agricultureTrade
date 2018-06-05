/**
 * Created by sunguiyong on 2018/5/24.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture';
axios.defaults.headers.post['Content-Type'] = 'text/plain';

//每个种类的商品，在页面中显示的列表
function getList() {
    axios.get('/goods/gk-list', {
        params: {}
    }).then(function (response) {
        var data = null;
        data = response.data.data;
        setHtml(data);
    }).catch(function (response) {
        alert(response);
    });
}

function setHtml(data) {
    console.log(data);
    var goodsList = document.getElementById('goods-list');
    var html = "";
    for (var i = 0; i < data.length; i++) {
        html += setKindLi(data[i].kindName, data[i].goodsList);
    }
    goodsList.innerHTML = html;
}

//左侧的种类列表
function setKindLi(kindName) {
    return "<li class='one-0' title='" + kindName + "'>" +
        "<a onclick='clickKind(\"" + kindName + "\")' target='_blank'>" +
        "<span>" + kindName + "</span>" +
        "</a>" +
        "</li>";
}

function clickKind(data) {
    var url = "http://localhost:8080/agriculture/view/stores.html?kindName="+data+"&goodsName=";
    window.open(url);
    // document.location = url;
}