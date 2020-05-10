$(document).ready(function () {
    loadUser();
});
function deleteUser(id) {
    if (!id && id != 0) {
        id = $('#deleteid').val();
    }
    event.preventDefault();
    $.ajax({
        url: 'rest/user/' + id,
        method: 'DELETE',
        success: function (data) {
            alert(JSON.stringify(data));
            loadUsers();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
            loadUsers();

        }
    });
}

function loadUsers() {
    $.get('rest/users', function (data, textStatus, req) {
        $("#userTable").empty();
        $.each(data, function (i, elt) {
            $('#userTable').append(generateUserTable(elt));
        });
    });
}


function generateUserTable(user) {
    return '<tr><td>' + User.id + '</td>' +
        '<td>' + UserName.name + '</td>' +
        '<td>' + Initialer.initial + '</td>' +
        '<td>' + CPR.name + '</td>' +
        '<td>' + Password.password + '</td>' +
        '<td>' + Roles.role + '</td>' +
        '<td onclick="updateUser(' + User.id + ')">' + update.update + '</td>' +

        '<td onclick="deleteUser(' + User.id + ')"><button>slet bruger</button></td></tr> '
}