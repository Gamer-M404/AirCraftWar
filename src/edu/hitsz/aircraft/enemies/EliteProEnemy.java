package edu.hitsz.aircraft.enemies;

import edu.hitsz.application.Main;

import java.util.concurrent.ThreadLocalRandom;

public class EliteProEnemy extends EliteEnemy{
    public EliteProEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setPower(25);
        this.setShootNum(3);
    }

}
