package edu.hitsz.shootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class ScatterShoot implements Strategy{
    @Override
    public List<BaseBullet> shootStrategy(AbstractAircraft plane, int direction, int shootNum, int power) {
        List<BaseBullet> res = new LinkedList<>();
        int x = plane.getLocationX();
        int y = plane.getLocationY() + direction*2;
        int speedX = plane.getSpeedX();
        int speedY = plane.getSpeedY() + direction*5;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            bullet = new HeroBullet(x + (i*2 - shootNum + 1)*10, y, speedX + (i * 2 - shootNum + 1), speedY, power);
            res.add(bullet);
        }
        return res;
    }
}
