import processing.core.PApplet;

import java.util.ArrayList;

public class Zombie {
    private int x;
    private int y;
    private int r;
    private PApplet p;
    private final int WINDOW_SIZE = 1000;
    private final int TOP_CUSHION = 800;
    private final int BOTTOM_CUSHION = 50;
    private  final int MAX = 50;
    private  final  int MIN = 5;


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


    Zombie(PApplet p) {
        x = MIN + (int) (Math.random() * ((WINDOW_SIZE - MIN) + 1));
        y = 800 + (int) (Math.random() * ((WINDOW_SIZE - 800) + 1));
        r = computeR();
        this.p = p;
    }

    Zombie(PApplet p, int x, int y) {
        this.y = y;
        this.x = x;
        this.p = p;
        r = computeRandom(50,5);
    }

    Zombie() {
        x = MIN + computeRandom(50,5);
        y = MIN + computeRandom(50,5);
        r = MIN + computeRandom(50,5);
        r = computeRandom(50,5);
    }

    public void draw(int r, int b, int g) {
        p.fill(r,b,g);
        p.circle(x,y,this.r);
    }


    public void move() {
        int direction = computeRandom(10,1);
        if (direction <= 5) {
            --this.y;
        } else if (direction == 6){
            this.y=this.y;
        } else if (direction == 7) {
            ++this.x;
        } else if (direction == 8) {
            --this.x;
        } else {
            ++this.y;
        }
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
