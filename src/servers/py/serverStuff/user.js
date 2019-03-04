

function ajaxGetRequest(path, callback){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200){
            callback(this.response);
        }
    };
    request.open("GET", path);
    request.send();
}

function ajaxPostRequest(path, data, callback){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200){
            callback(this.response);
        }
    };
    request.open("POST", path);
    request.send(data);
}


function renderUser(response){
    var user = "";
    for(var data of JSON.parse(response).reverse()){
        user = user + data.message + "</br>";
    }
    document.getElementById("users").innerHTML = user;
}

function loadUsers(){
    ajaxGetRequest("/join", renderUser);
}

function addUser(){
    var element = document.getElementById("user");

    var user = element.value;
    element.value = "";
    var toSend = JSON.stringify({"user": user});

    ajaxPostRequest("/join", toSend, renderUser());

}