//CS 132 FINAL: ZOMBIE SIMULATOR
//ERIN OCONNELL
//IN THIS PROGRAM A GROUP OF ZOMBIES AND A GROUP OF HUMANS WILL COLLIDE. WHO WILL SURVIVE?? DUH..DUH..DUHHHHHHHHH.

import processing.core.PApplet;

import java.util.ArrayList;

import processing.sound.*;

public class Sketch extends PApplet {

    private ArrayList<Human> humans = new ArrayList<Human>();
    private ArrayList<Zombie> zombies = new ArrayList<>();
    private SoundFile zombie;
    private ArrayList<ParticleSystem>explosions = new ArrayList<>();

    private final int WINDOW_SIZE = 1000;
    private final int BACKGROUND = 200;
    private final int NUM_OF_ZOMBIES= 74;
    private final int NUM_OF_HUMANS= 99;
    private int PROBABILITY_FACTOR = 5;

    public boolean timeToExplode = false;

    public void settings(){
        size(WINDOW_SIZE,WINDOW_SIZE);
    }

    public void setup() {
        addHumans();
        addZombies();
        zombie = new SoundFile(this, "zombie.mp3");
    }

    public void draw() {
        background(BACKGROUND);
        drawZombies();
        moveZombies();
        drawHumans();
        drawHumans();
        moveHumans();
        counter(humans,"Humans: ",WINDOW_SIZE/2,50);
        counter(zombies,"Zombies: ",WINDOW_SIZE/2,WINDOW_SIZE-50);
        collision();
        explode();
    }

    public void addHumans(){
        for(int i=0;i<=NUM_OF_HUMANS;++i) {
        humans.add(new Human(this));

        }
    }

    public void addZombies(){
       for(int i=0;i<=NUM_OF_ZOMBIES;++i) {
            zombies.add(new Zombie(this));
        }
    }

    public void drawZombies(){
        for(int i=0;i<=zombies.size()-1;++i) {
           Zombie thisZombie = zombies.get(i);
           thisZombie.draw(255,179,0);
        }
    }

    public void moveZombies(){
        for(int i=0;i<=zombies.size()-1;++i) {
            Zombie thisZombie = zombies.get(i);
            thisZombie.move();
        }
    }

    public void drawHumans(){
        for(int i=0;i<=humans.size()-1;++i) {
            Human thisHuman = humans.get(i);
            thisHuman.draw();
        }
    }

    public void moveHumans(){
        for(int i=0;i<=humans.size()-1;++i) {
            Human thisHuman = humans.get(i);
            thisHuman.move();
        }
    }

    public void counter(ArrayList array, String name,int x, int y) {
        textSize(20);
        fill(0, 102, 153);
        text(name + array.size(), x, y);
    }

    public void explode() {
        if (timeToExplode == true) {
            for (int e = 0; e <= explosions.size() - 1; ++e) {
                ParticleSystem explode = explosions.get(e);
                explode.draw();
                explode.update();
            }
        }

    }

    public void collision() {
        int whoWins = 1 + (int) (Math.random() * ((10 - 1) + 1));
        for(int i=0;i<=humans.size()-1;++i){
            Human thisHuman = humans.get(i);
            for(int z=0;z<=zombies.size()-1;++z){
                Zombie thisZombie = zombies.get(z);
                if (thisHuman.isHit(thisZombie)==true){
                    if(thisHuman.getR()<thisZombie.getR()) {
                        higherProbability();
                    }else if(thisHuman.getR()>thisZombie.getR()){
                        lowerProbability();
                    }
                    if (whoWins <= PROBABILITY_FACTOR){
                        zombies.add(new Zombie(this, thisHuman.getX(),thisHuman.getY()));
                        humans.remove(thisHuman);
                        //I do not have speakers on my computer so I really hope this works!!!
                        zombie.play();
                        resetProbabilityFactor();
                        break;
                    } else if (whoWins > PROBABILITY_FACTOR) {
                        explosions.add(new ParticleSystem(thisZombie.getX(), thisZombie.getY(), this));
                        timeToExplode = true;
                    }
                        zombies.remove(thisZombie);
                        resetProbabilityFactor();
                    }
                }
            }
        }

        public void resetProbabilityFactor(){
            PROBABILITY_FACTOR = 5;
        }

        public void higherProbability(){
            PROBABILITY_FACTOR = PROBABILITY_FACTOR + 2;
        }

        public void lowerProbability(){
            PROBABILITY_FACTOR = PROBABILITY_FACTOR-2;
        }
    }