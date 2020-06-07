import processing.core.PApplet;

import java.util.ArrayList;

public class Zombie {
    private int x;
    private int y;
    private int w;
    private int l;
    private PApplet p; //make this so person can access processing

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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    Zombie(PApplet p) {
        x = 5 + (int) (Math.random() * ((500 - 5) + 1));
        y = 400 + (int) (Math.random() * ((499 - 400) + 1));
        w = 25;
        l = 25;
        this.p = p;
    }

    Zombie(PApplet p, int x, int y) {
        this.y = y;
        this.x = x;
        w = 25;
        l = 25;
        this.p = p;
    }

    Zombie() {
        x = 5 + (int) (Math.random() * ((50 - 5) + 1));
        y = 5 + (int) (Math.random() * ((50 - 5) + 1));
        w = 50;
        l = 50;
    }

    public void draw() {
        p.fill(100,100,100);
        p.ellipse(x, y, w, l);
    }



    public void move() {
        int direction = 1 + (int) (Math.random() * ((10 - 1) + 1));
        if (direction <= 5) {
            --y;
        } else if (direction == 6){
            y=y;
        } else if (direction == 7) {
            ++x;
        } else if (direction == 8) {
            --x;
        } else {
            ++y;
        }
    }

}
