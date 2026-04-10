package edu.hitsz.aircraft.enemies;

import edu.hitsz.application.Main;

import java.util.concurrent.ThreadLocalRandom;

public class ElitePlusEnemy extends EliteEnemy{
    public ElitePlusEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setPower(30);
        this.setShootNum(2);
    }

}
