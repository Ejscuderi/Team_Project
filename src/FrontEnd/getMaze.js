var fs = require('fs');

function text(file) {
    return fs.readFileSync('src/FrontEnd/' + file, 'utf8');
}

function fuck(){
    return '5';
}

var fuxk = fuck();