
// A $( document ).ready() block.
$("#logOnForm").submit(function(e) {
    e.preventDefault();
});
function logOn() {
    if($('#lUserName') == ''){
        alert("fuck det her lort")
    }
}
function switchPage(page){
    return $("body").load(page);
}


function login() {
    var data = $('#logOnForm').serializeJSON();
    $.ajax({
        url: 'rest/login',
        method: 'POST',

        contentType: "application/json", // det vi sender er json
        data: data,
        success: function (data) {
            alert(JSON.stringify(data));
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
            alert(textStatus);
            alert(errorThrown);
        }
    });
}