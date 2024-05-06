let stars = [];

let speed;

function setup() {
    createCanvas(2000, 1000);
    for (let i = 0; i < 800; i++) {
        stars[i] = new Star();
    }
}

function draw() {
    speed = map(mouseX, 0, width, 0, 50);
    background(0);
    translate(width / 2, height / 2);
    for (let i = 0; i < stars.length; i++) {
        stars[i].update();
        stars[i].show();
    }
}