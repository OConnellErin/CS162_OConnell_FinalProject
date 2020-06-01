import processing.core.PApplet;

import java.util.ArrayList;

public class Human {
    int x;
    int y;
    int w;
    int l;
    PApplet p; //make this so person can access processing

    Human(PApplet p) {
        x = 5 + (int) (Math.random() * ((50 - 5) + 1));
        y = 5 + (int) (Math.random() * ((50 - 5) + 1));
        w = 50;
        l = 50;
        this.p = p;
    }

    Human() {
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
            ++y;
        } else if (direction == 7) {
            ++x;
        } else if (direction == 8) {
            --x;
        } else {
            --y;
        }
    }
    public void counter(ArrayList humans){
        p.textSize(20);
        p.text("Humans: " + humans.size(), 220, 450);
        p.fill(0, 102, 153);
    }

        public void collide(Zombie zombie){
            int whoWins = 1 + (int) (Math.random() * ((10 - 1) + 1));
             if(this.x == zombie.x && this.y == zombie.y){
                 if(whoWins<7){

                //human turns into zombie
            }
                else{
                //zombies.remove(this zombie);
                //ParticleSystem = new ParticleSystem(zombie.x,zombie.y);
            }
        }
    }

//    public void explode(){
//        if( collide == false){
//            ParticleSystem explode = new ParticleSystem(zombie.x,zombie.y);
//        }
//    }
}
