/**
 * Created by sloriac on 16-12-4.
 */

window.webapp = "/geonamesplus/";

function search_input() {
    var input = document.getElementById("search-input").value;
    if (input != "") {
        window.location.href = window.webapp + "search/" + input;
    } else {
        alert("请输入您想查询的实体");
    }
}

function search_enter(event) {
    event = event || window.event;
    if (event.keyCode == 13) {
        search_input();
    }
}

function feed_input(id) {
    var input = document.getElementById("feed-input").value;
    if (input != "") {
        $.get(window.webapp + "feed/" + id + "/" + input, function (data, status) {
            if (status == "success") alert("反馈提交成功! 谢谢您!");
        });
    } else {
        alert("请输入反馈信息");
    }
}

function feed_enter(event) {
    event = event || window.event;
    if (event.keyCode == 13) {
        feed_input();
    }
}