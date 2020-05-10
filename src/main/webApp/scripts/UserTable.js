$(document).ready(function () {
    loadUsers();
});

function deleteUser(id) {
    $.post('rest/user/deleteUser', {"userID":id}, data => alert(JSON.stringify(data)));
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
        '<td onclick="updateUser(' + user.userID + ')">opdater bruger</td>' +

        '<td onclick="deleteUser(' + user.userID + ')"><button>slet bruger</button></td></tr> '
}