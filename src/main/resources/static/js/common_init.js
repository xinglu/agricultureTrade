/**
 * Created by sunguiyong on 2018/5/24.
 */
axios.defaults.baseURL = 'http://localhost:8080/agriculture/goods';
axios.defaults.headers.post['Content-Type'] = 'text/plain';

//每个种类的商品，在页面中显示的列表
function getList() {
    axios.get('/gk-list', {
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

function setKindLi(kindName, goodsList) {
    return "<li class='one-0' title='" + kindName + "'>" +
        "<a href='http://www.zgncpw.com/sell/list-13.html' target='_blank'>" +
        "<span>" + kindName + "</span>" +
        "</a>" +
        "</li>";
}

function getGoodsListHtml(goodsList) {
    var len = goodsList.length;
    var html = "";
    for (var i = 0; i < len; i++) {
        console.log(goodsList[i]);
        html += "<a target='_blank' class='four-bold'" +
            " href='http://www.zgncpw.com/sell/list-86.html'>" + goodsList[i] + "</a>";
    }
    console.log(html);
    return html;
}