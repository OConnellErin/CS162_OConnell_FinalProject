import processing.core.PApplet;

import java.util.ArrayList;

public class Zombie {
    int x;
    int y;
    int w;
    int l;
    PApplet p; //make this so person can access processing

    Zombie(PApplet p) {
        x = 5 + (int) (Math.random() * ((50 - 5) + 1));
        y = 400 + (int) (Math.random() * ((499 - 400) + 1));
        w = 50;
        l = 50;
        this.p = p;
    }

    Zombie() {
        x = 5 + (int) (Math.random() * ((50 - 5) + 1));
        y = 5 + (int) (Math.random() * ((50 - 5) + 1));
        w = 50;
        l = 50;
    }

    public void draw() {
        p.ellipse(x, y, w, l);
    }



    public void move() {
        int direction = 1 + (int) (Math.random() * ((10 - 1) + 1));
        if (direction <= 6) {
            --y;
        } else if (direction == 7) {
            ++x;
        } else if (direction == 8) {
            --x;
        } else {
            ++y;
        }
    }


    public void counter(ArrayList zombies){
        p.textSize(20);
        p.text("Zombies: " + zombies.size(), 220, 50);
        p.fill(0, 102, 153);
    }

}
