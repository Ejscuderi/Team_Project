var socket = io.connect({transports: ['websocket']});
socket.on('gameState', parseGameState);

const tileSize = 30;

var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");
context.globalCompositeOperation = 'source-over';

function parseGameState(event) {
    // console.log(event);
    const gameState = JSON.parse(event);

    drawGameBoard(gameState['gridSize']);

    placeSquare(gameState['start']['x'], gameState['start']['y'], '#fd2d32'); //#ca0005

    placeSquare(gameState['base']['x'], gameState['base']['y'], '#8b007f');

    for (let player of gameState['players']) {
        console.log("place circle");
        placeCircle(player['x'], player['y'], player['id'] === socket.id ? '#0acc00' : '#c4f200', 2.0); //'#9ec400'
    }

    for (let wall of gameState['walls']) {
        placeSquare(wall['x'], wall['y'], 'black');
        //placeRect(wall['x'], wall['y'])
    }
}

function cleanInt(input) {
    const value = Math.round(input);
    const asString = value.toString(16);
    return value > 15 ? asString : "0" + asString;
}

function rgb(r, g, b) {
    return "#" + cleanInt(r) + cleanInt(g) + cleanInt(b);
}


function drawGameBoard(gridSize) {

    const gridWidth = gridSize['x'];
    const gridHeight = gridSize['y'];

    context.clearRect(0, 0, gridWidth * tileSize, gridHeight * tileSize);

    canvas.setAttribute("width", gridWidth * tileSize);
    canvas.setAttribute("height", gridHeight * tileSize);

    context.strokeStyle = '#bbbbbb';
    for (let j = 0; j <= gridWidth; j++) {
        context.beginPath();
        context.moveTo(j * tileSize, 0);
        context.lineTo(j * tileSize, gridHeight * tileSize);
        context.stroke();
    }
    for (let k = 0; k <= gridHeight; k++) {
        context.beginPath();
        context.moveTo(0, k * tileSize);
        context.lineTo(gridWidth * tileSize, k * tileSize);
        context.stroke();
    }

}


function placeSquare(x, y, color) {
    context.fillStyle = color;
    context.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
    context.strokeStyle = 'black';
    context.strokeRect(x * tileSize, y * tileSize, tileSize, tileSize);
}

function placeRect(x, y) {
    context.fillStyle = '#000000';
    context.fillRect(x * tileSize, y * tileSize, 2, tileSize);
    context.strokeStyle = 'black';
    context.strokeRect(x * tileSize, y * tileSize, 2, tileSize);

    context.fillStyle = '#000000';
    context.fillRect(x * tileSize, y * tileSize, tileSize, 2);
    context.strokeStyle = 'black';
    context.strokeRect(x * tileSize, y * tileSize, tileSize, 2);

    context.fillStyle = '#000000';
    context.fillRect(x * tileSize, (y + 28) * tileSize, tileSize, 10);
    context.strokeStyle = 'black';
    context.strokeRect(x * tileSize, (y + 28) * tileSize, tileSize, 10);

    context.fillStyle = '#000000';
    context.fillRect((x + 28) * tileSize, y  * tileSize, 10, tileSize);
    context.strokeStyle = 'black';
    context.strokeRect((x + 28) * tileSize, y  * tileSize, 10, tileSize);

    context.fillStyle = '#000000';
    context.fillRect(x * 28 * tileSize, y * 28 * tileSize, 2, tileSize);
    context.strokeStyle = 'black';
    context.strokeRect(x * 28 * tileSize, y * 28 * tileSize, 2, tileSize);

}


function placeCircle(x, y, color, size) {
    context.fillStyle = color;
    context.beginPath();
    context.arc(x * tileSize,
        y * tileSize,
        size / 10.0 * tileSize,
        0,
        2 * Math.PI);
    context.fill();
    context.strokeStyle = 'black';
    context.stroke();

    context.lineWidth = 5;
    context.stroke();
    context.lineWidth = 1;
    context.fill();
}
