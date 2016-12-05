/**
 * Created by sloriac on 16-12-4.
 */

window.webapp = "/geonamesplus/";

function search_input(id) {
    var input = document.getElementById("search-input").value;
    if (input != "") {
        window.location.href = window.webapp + "search/" + input + "/" + id;
    } else {
        alert("请输入您想查询的实体");
    }
}