var fs = require("fs");

var data = "New File Contents";

fs.writeFile("src/FrontEnd/temp.txt", data, function(err, data) {
    if (err) console.log(err);
    console.log("Successfully Written to File.");
});