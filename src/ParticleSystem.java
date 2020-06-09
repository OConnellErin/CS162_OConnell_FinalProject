import processing.core.PApplet;

import java.util.ArrayList;

class ParticleSystem {

    private final int NUMBER_OF_PARTICLES = 10;
    private ArrayList<Particle> particles;
    private int x;
    private int y;

    public ParticleSystem(PApplet p) {
        particles = new ArrayList<Particle>();
        x = p.width / 2;
        y = p.height / 2;
        for (int i = 0; i < NUMBER_OF_PARTICLES; ++i) {
            particles.add(new Particle(x, y,p));
        }
    }

    public ParticleSystem(int x, int y, PApplet p) {
        this.x = x;
        this.y = y;
        particles = new ArrayList<Particle>();
        for (int i = 0; i < NUMBER_OF_PARTICLES; ++i) {
            particles.add(new Particle(x, y,p));
        }
    }

    public void update() {
        for (Particle p : particles) {
            p.move();
        }
    }

    public void draw() {
        for (Particle p : particles) p.draw();
    }
}