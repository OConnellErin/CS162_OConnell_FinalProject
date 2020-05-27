import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {
    Human person;
    Zombie zombie;
    ArrayList<Human> humans = new ArrayList<Human>();


    public void settings(){
        size(500,500);
    }

    @Override
    public void setup() {
        super.setup();
        person = new Human(this); //this sends the constructor an instance of this aka a sketch in this case
        zombie = new Zombie(this);
        humans.add(new Human());
    }

    @Override
    public void draw() {
        background(100);
        zombie.draw();
        zombie.move();
        person.draw();
        person.move();
    }

/*
    public void collide(){
        int whoWins = 1 + (int) (Math.random() * ((10 - 1) + 1));
        if(zombie.x == person.x && person.y = zombie.y){
            if(whoWins<7){
                //human turns into zombie
            }
            else{
                //zombies.remove(this zombie);
            }

        }
    }
*/
}
