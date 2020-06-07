import processing.core.PApplet;

import java.util.ArrayList;

//import processing.sound.*;

public class Sketch extends PApplet {

    ArrayList<Human> humans = new ArrayList<Human>();
    ArrayList<Zombie> zombies = new ArrayList<>();
//    Soundfile zombie = new Soundfile(this, "zombie.mp3");
//    ParticleSystem explode = new ParticleSystem(100,100,this);

    public void settings(){
        size(500,500);
    }

    @Override
    public void setup() {
        super.setup();
        addHumans();
        addZombies();
    }

    @Override
    public void draw() {
        background(200);
        drawZombies();
        moveZombies();
        drawHumans();
        drawHumans();
        moveHumans();
        counter("Humans: ",220,450);
        counter("Zombies: ",220,50);
        collision();
        //this was a test to see if ParticleSystem was working, it is but it is making the colors be funky.
//        explode.draw();
//        explode.update();
    }

    public void addHumans(){
        for(int i=0;i<=100;++i) {
        humans.add(new Human(this));

        }
    }

    public void addZombies(){
       for(int i=0;i<=100;++i) {
            zombies.add(new Zombie(this));
        }
    }

    public void drawZombies(){
        for(int i=0;i<=zombies.size()-1;++i) {
           Zombie thisZombie = zombies.get(i);
           thisZombie.draw();
        }
    }

    public void moveZombies(){
        for(int i=0;i<=zombies.size()-1;++i) {
            Zombie thisZombie = zombies.get(i);
            thisZombie.move();
        }
    }

    public void drawHumans(){
        for(int i=0;i<=zombies.size()-1;++i) {
            Human thisHuman = humans.get(i);
            thisHuman.draw();
        }
    }

    public void moveHumans(){
        for(int i=0;i<=zombies.size()-1;++i) {
            Human thisHuman = humans.get(i);
            thisHuman.move();
        }
    }

    public void counter(String name,int x, int y) {
        textSize(20);
        fill(0, 102, 153);
        text(name + humans.size(), x, y);
    }

    public void collision() {
    //version of collision method that was not working.
        int whoWins = 1 + (int) (Math.random() * ((10 - 1) + 1));
        for(int i=0;i<=humans.size()-1;++i){
            Human thisHuman = humans.get(i);
            for(int z=0;z<=zombies.size()-1;++z){
                Zombie thisZombie = zombies.get(z);
                if (thisHuman.isHit(thisZombie)==true){
                    if (whoWins <= 7){
                        System.out.println("Collision has been made. 70% chance this is printed");
                        zombies.add(new Zombie(this, thisHuman.getX(),thisHuman.getY()));
                        humans.remove(thisHuman);
                        break;
//                        zombie.play();
                    } else if (whoWins > 7){
                        ParticleSystem explode = new ParticleSystem(thisZombie.getX(),thisZombie.getY(),this);
                        explode.draw();
                        explode.update();
                        zombies.remove(thisZombie);
                        break;
                    }
                    }
                else{
                    System.out.println("There is no collision at the moment.");
                }
            }
        }
    }
}

