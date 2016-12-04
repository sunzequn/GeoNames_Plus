/**
 * Created by sloriac on 16-12-4.
 */

window.webapp = "/geonamesplus/";

function search_input(id) {
    var input = document.getElementById("search-input");
    window.location.href = window.webapp + "search/" + input.value + "/" + id;
}