import processing.core.PApplet;

import java.awt.*;

import java.util.ArrayList;

public class Human{
    private int x;
    private int y;
    private int r;
    PApplet p; //make this so person can access processing
    private final int WINDOW_SIZE = 1000;
    protected final int TOP_CUSHION = 800;
    protected final int BOTTOM_CUSHION = 50;
    protected  final int MAX = 50;
    protected  final  int MIN = 5;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }


    Human(PApplet p) {
        x = MIN + (int) (Math.random() * ((WINDOW_SIZE - MIN) + 1));
        y = BOTTOM_CUSHION + (int) (Math.random() * ((WINDOW_SIZE - TOP_CUSHION) + 1));
        r = computeR();
        this.p = p;

    }

    Human() {
        x = MIN + computeRandom(50,5);
        y = MIN + computeRandom(50,5);
        r = MIN + computeR();
    }

    public void draw() {
        p.fill(0,213,255);
        p.circle(x, y, r);

    }

    public void move() {
        int direction = 1 + (int) (Math.random() * ((10 - 1) + 1));
        if (direction <= 5) {
            ++y;
        } else if (direction == 6) {
            y = y;
        } else if (direction == 7) {
            ++x;
        } else if (direction == 8) {
            --x;
        } else {
            --y;
        }
    }

    public boolean isHit(Zombie zombie) {
        if (p.dist(zombie.getX(), zombie.getY(), x, y) < zombie.getR() / 2 +  r/2) {
            return true;
        } else return false;
    }

    public int computeRandom(int MAX, int MIN){
        return MIN + (int) (Math.random() * ((MAX - MIN) + 1));
    }

    public int computeR(){
        int size = computeRandom(10,1);
        if (size < 3){
            r = computeRandom(15,5);
        }
        else if (size < 6){
            r= computeRandom(30,10);
        }
        else if (size>=6){
            r = computeRandom(50,20);
        }
        return r;
    }
}
