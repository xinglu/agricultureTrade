/**
 * Created by Amos on 2018/6/2.
 */

function msgbox(title, content, func, cancel, focus) {
    /*
     参数列表说明:
     title :弹出对话框的标题,标题内容最好在25个字符内,否则会导致显示图片的异常
     text  :弹出对话框的内容,可以使用HTML代码,例如<font color='red'>删除么?</font>,如果直接带入函数,注意转义
     func  :弹出对话框点击确认后执行的函数,需要写全函数的引用,例如add(),如果直接带入函数,注意转义。
     cancel:弹出对话框是否显示取消按钮,为空的话不显示,为1时显示
     focus :弹出对话框焦点的位置,0焦点在确认按钮上,1在取消按钮上,为空时默认在确认按钮上
     */
    var temp = "<div id='popup_div' style=\"width:300px;border: 2px solid #37B6D1;background-color: #fff; font-weight: bold;font-size: 12px;\" >"
        + "<div style=\"line-height:25px; padding:0px 5px;    background-color: #37B6D1;\">" + title + "</div>"
        + "<table  cellspacing=\"0\" border=\"0\"><tr><td style=\" padding:0px 0px 0px 20px; \"></td>"
        + "<td ><div style=\"background-color: #fff; font-weight: bold;font-size: 12px;padding:20px 0px ; text-align:left;\">" + content
        + "</div></td></tr></table>"
        + "<div style=\"text-align:center; padding:0px 0px 20px;background-color: #fff;\"><input type='button'  style=\"border:1px solid #CCC; background-color:#CCC; width:50px; height:25px;\" value='确定' id=\"msgconfirmb\"   onclick=\"sureRemove()\">";
    if (null != cancel) {
        temp += "   <input type='button' style=\"border:1px solid #CCC; background-color:#CCC; width:50px; height:25px;\" value='取消'  id=\"msgcancelb\"   onClick='cancelRemove()'>";
    }
    temp += "</div></div>";
    create_msgbox(400, 200, temp);
    if (focus == 0 || focus == "0" || null == focus) {
        document.getElementById("msgconfirmb").focus();
    }
    else if (focus == 1 || focus == "1") {
        document.getElementById("msgcancelb").focus();
    }
}

function create_msgbox(w, h, t) {//创建弹出对话框的函数
    var info = document.getElementById("info");
    info.innerHTML = t;
}

function cancelRemove() {
    var popup_div = document.getElementById("popup_div");
    popup_div.style.display = "none";
    window.location.reload(true);
}
function sureRemove() {
    var popup_div = document.getElementById("popup_div");
    popup_div.style.display = "none";
    window.location.reload(true);
    document.location = "http://localhost:8080/agriculture/view/store_register.html";
}
