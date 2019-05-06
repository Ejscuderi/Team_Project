var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;



const Http = new XMLHttpRequest();
const url='http://localhost:8080';
Http.open("GET", url);
Http.send();
Http.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        action_on_response(Http.responseText)
    }
};


function action_on_response(response){
    console.log("The server responded with: " + response);
}
