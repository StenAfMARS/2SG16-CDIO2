
// A $( document ).ready() block.
$( document ).ready(function() {
    console.log( "ready!" );
    $("body").load("C:/Users/mathias/IdeaProjects/2SG16-CDIO2/src/Frontend/frontpage.html");
});
function switchPage(page){
    $("body").load(page);
}

