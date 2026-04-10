package edu.hitsz.aircraft.enemies;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;

import java.util.LinkedList;
import java.util.List;

public class EliteEnemy extends MobEnemy{
    // 子弹的伤害
    private int power = 20;

    // 子弹的方向
    private int direction = 1;

    // 发射子弹的数目
    private int shootNum = 1;

    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    public int getPower(){
        return this.power;
    }
    public void setPower(int power){
        this.power = power;
    }

    public int getShootNum() { return shootNum; }

    public void setShootNum(int shootNum) { this.shootNum = shootNum; }

    @Override
    public List<BaseBullet> shoot() {
        return this.shootStrategy.shootStrategy(this, this.direction, this.shootNum, this.power);
    }
}
