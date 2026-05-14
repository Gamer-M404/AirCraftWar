package edu.hitsz.bullet;

import edu.hitsz.application.ImageManager;
import edu.hitsz.observer.PropObserver;

import java.awt.image.BufferedImage;

/**
 * 敌机子弹
 * @Author hitsz
 */
public class EnemyBullet extends BaseBullet implements PropObserver {

    public EnemyBullet(int locationX, int locationY, int speedX, int speedY, int power) {
        super(locationX, locationY, speedX, speedY, power);
    }

    @Override
    public void onBombPicked() {
        // 消失
        this.vanish();
    }

    @Override
    public void onFreezePicked() {
        // 静止5s后恢复
        freeze(5, true, false);
    }
}
