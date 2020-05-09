function createIngredient() {
    event.preventDefault();
    var data = $('#ingredientform').serializeJSON();
    $.ajax({
        url: 'rest/User',
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