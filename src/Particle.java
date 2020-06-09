import processing.core.PApplet;
class Particle {

    private PApplet p;

    private final double ACCELERATION = 0.1;

    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private int c;
    private float size;

    public Particle(PApplet p) {
        x = p.mouseX;
        y = p.mouseY;
        this.p=p;
        xVelocity = p.random(-5, 5);
        yVelocity = p.random(-4, 0);
        c = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        size = p.random(10, 20);
    }

    public Particle(int x, int y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p=p;
        xVelocity = p.random(-2, 2);
        yVelocity = p.random(-4, 0);
        c = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        size = p.random(2, 10);
    }

    public void draw() {
        p.stroke(150);
        p.fill(c);
        p.ellipse(x, y, size, size);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
        yVelocity += ACCELERATION;
    }

}