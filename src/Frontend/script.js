
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
    $("body").load(page);
}

