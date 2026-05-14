package edu.hitsz.aircraft.enemies;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.observer.PropObserver;

import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;

/**
 * 普通敌机
 * 不可射击、不掉落道具
 * @author hitsz
 */
public class MobEnemy extends AbstractAircraft implements PropObserver {
    public MobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot() {
        return this.shootStrategy.enemyShootStrategy(this, 0,0, 0);
    }

    @Override
    public void onBombPicked() {
        // 坠毁
        this.vanish();
    }

    @Override
    public void onFreezePicked() {
        // 永久静止
        this.freeze(-1, true, true);
    }
}
