import processing.core.PApplet;

import java.util.ArrayList;

public class Player {
        protected int x;
        protected int y;
        protected int r;
        protected PApplet p; //make this so person can access processing
        protected final int WINDOW_SIZE = 1000;
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

        Player(PApplet p) {
            x = MIN + (int) (Math.random() * ((WINDOW_SIZE - MIN) + 1));
            y = 800 + (int) (Math.random() * ((WINDOW_SIZE - 800) + 1));
            r = computeRandom();
            this.p = p;
        }

        Player(PApplet p, int x, int y) {
            this.y = y;
            this.x = x;
            this.p = p;
            r = computeRandom();
        }

        Player() {
            x = MIN + computeRandom();
            y = MIN + computeRandom();
            r = MIN + computeRandom();
        }

        public void draw(int r, int b, int g) {
            p.fill(r,b,g);
            p.circle(x,y,this.r);
        }

        public void move() {
        }

        public int computeRandom(){
            return MIN + (int) (Math.random() * ((MAX - MIN) + 1));
        }
    }
