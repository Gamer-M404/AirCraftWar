package edu.hitsz.aircraft.enemies;

import edu.hitsz.bullet.BaseBullet;

import java.util.LinkedList;
import java.util.List;

public class BossEnemy extends EliteEnemy{
    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setPower(10);
        this.setShootNum(20);
    }


}
