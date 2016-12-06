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
        var input = document.getElementById("search-input").value;
        window.location.href = window.webapp + "search/" + input;
    }
}