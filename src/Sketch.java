import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {
    Human person;
    Zombie zombie;
    ArrayList<Human> humans = new ArrayList<Human>();
    ArrayList<Zombie> zombies = new ArrayList<>();


    public void settings(){
        size(500,500);
    }

    @Override
    public void setup() {
        super.setup();
        person = new Human(this); //this sends the constructor an instance of this aka a sketch in this case
        zombie = new Zombie(this);
        humans.add(new Human());
        zombies.add(new Zombie());
    }

    @Override
    public void draw() {
        background(100);
//        zombies.draw();
        zombie.draw();
        zombie.move();
        person.draw();
        person.move();
        zombie.counter(zombies);
        person.counter(humans);
 //       person.collide(zombie);
    }




}
