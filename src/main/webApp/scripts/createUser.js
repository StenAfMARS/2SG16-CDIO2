function createUser(data) {
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO2_war_exploded/rest/user/createUser",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify(data),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}