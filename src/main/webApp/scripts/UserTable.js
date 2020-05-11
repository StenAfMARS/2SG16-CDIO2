$(document).ready(function () {
    loadUsers();
});

function deleteUser(id){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO2_war_exploded/rest/user/deleteUser",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"userID":id}),
    };

    $.ajax(settings).done(function (response) {
        loadUsers()
        console.log("deletedUser");
    });
}

function loadUsers() {
    $.post('rest/user/getUserList',
        {},
        function (data, textStatus, req) {
            $("#userTable").empty();
            $.each(data, function (i, elt) {
                $('#userTable').append(generateUserTable(elt));
            });
        }
    );
}

function generateUserTable(user) {
    return '<tr><td>' + user.userID + '</td>' +
        '<td>' + user.userName + '</td>' +
        '<td>' + user.ini + '</td>' +
        '<td>' + user.cpr + '</td>' +
        '<td>' + user.password + '</td>' +
        '<td>' + user.roles + '</td>' +
        '<td onclick="updateUserByID(' + user.userID + ')"><button>opdater bruger</button></td>' +

        '<td onclick="deleteUser(' + user.userID + ')"><button>slet bruger</button></td></tr> '
}

function getUser(id){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO2_war_exploded/rest/user/getUser",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"userID":id}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

function updateUserByID(id){
    switchPage("Views/UserForm.html");
    document.uuuuserID = id;
}

function updateUser(id,userName,password,ini,cpr,roles){
    var settings = {
        "url": "http://localhost:8080/2SG16_CDIO2_war_exploded/rest/user/updateUser",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify({"userID":id,"userName":userName,"password":password,"ini":ini,"cpr":cpr,"roles":roles}),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}