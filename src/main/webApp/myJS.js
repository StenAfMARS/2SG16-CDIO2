let LogForm = document.getElementById("logOnForm");

LogForm.addEventListener("submit", (e => {
     e.preventDefault();

     console.log("from has been submitted");
     validateLogOn();
}));

function validateLogOn() {
     var userName = document.logOnForm.username.value;
     var password = document.logOnForm.password.value;

     if (userName==null || userName==""){
          alert("Name can't be blank");
          return false;
     }else if(password.length<6){
          alert("Password must be at least 6 characters long.");
          return false;
     }
     switchPage("Views/userAdminstrationPage.html");
}