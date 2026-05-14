package edu.hitsz.aircraft.enemies;

import edu.hitsz.application.Main;
import edu.hitsz.observer.PropObserver;

import java.util.concurrent.ThreadLocalRandom;

public class EliteProEnemy extends EliteEnemy  {
    public EliteProEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setPower(25);
        this.setShootNum(3);
    }

    @Override
    public void onBombPicked() {
        // 掉血
        this.decreaseHp(this.hp / 2);
    }

    @Override
    public void onFreezePicked() {
        // 减速5s后恢复
        freeze(5, false, false);
    }

}
