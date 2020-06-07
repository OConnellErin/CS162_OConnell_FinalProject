import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

public class Human {
    private int x;
    private int y;
    private int w;
    private int l;
    PApplet p; //make this so person can access processing

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

    Human(PApplet p) {
        x = 5 + (int) (Math.random() * ((500 - 5) + 1));
        y = 5 + (int) (Math.random() * ((50 - 5) + 1));
        w = 25;
        l = 25;
        //       Color= 10;
        this.p = p;
    }

    Human() {
        x = 5 + (int) (Math.random() * ((50 - 5) + 1));
        y = 5 + (int) (Math.random() * ((50 - 5) + 1));
        w = 50;
        l = 50;
    }

    public void draw() {
        p.fill(200, 200, 200);
        p.ellipse(x, y, w, l);

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

    public void counter(ArrayList humans) {
        p.textSize(20);
        p.text("Humans: " + humans.size(), 220, 450);
        p.fill(0, 102, 153);
    }

    public boolean isHit(Zombie zombie) {
        if (p.dist(zombie.getX(), zombie.getY(), x, y) < zombie.getW() / 2 + w / 2) {
            return true;
        } else return false;
    }
}



//        public void collide(Zombie zombie){
//            int whoWins = 1 + (int) (Math.random() * ((10 - 1) + 1));
//                 //if(whoWins<7){
//
//                //human turns into zombie
//            }
//                else{
//                //zombies.remove(this zombie);
//                //ParticleSystem = new ParticleSystem(zombie.x,zombie.y);
//            }
//        }
// }



//    public void explode(){
//        if( collide == false){
//            ParticleSystem explode = new ParticleSystem(zombie.x,zombie.y);
//        }
//    }

