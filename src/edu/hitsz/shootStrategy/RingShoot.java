package edu.hitsz.shootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class RingShoot implements Strategy{
    @Override
    public List<BaseBullet> heroShootStrategy(AbstractAircraft plane, int direction, int shootNum, int power) {
        List<BaseBullet> res = new LinkedList<>();
        int x = plane.getLocationX();
        int y = plane.getLocationY() + direction * 2;

        // 基础射速
        int baseSpeed = 5;
        // 前方 180° 扇形，从 -90° 到 +90°
        double startAngle = -Math.PI / 2;
        double endAngle = Math.PI / 2;
        double step = (endAngle - startAngle) / (shootNum > 1 ? shootNum - 1 : 1);

        for (int i = 0; i < shootNum; i++) {
            double angle = startAngle + i * step;

            // 真正按角度旋转速度方向
            int speedX = (int) (baseSpeed * Math.sin(angle));
            int speedY = Math.abs((int) (baseSpeed * Math.cos(angle))) * direction;

            // 发射位置稍微拉开，避免叠在一起
            int bx = x + (i - shootNum / 2) * 3;

            BaseBullet bullet = new HeroBullet(bx, y, speedX, speedY, power);
            res.add(bullet);
        }
        return res;
    }

    @Override
    public List<BaseBullet> enemyShootStrategy(AbstractAircraft plane, int direction, int shootNum, int power) {
        List<BaseBullet> res = new LinkedList<>();
        int x = plane.getLocationX();
        int y = plane.getLocationY() + direction * 2;

        // 基础射速
        int baseSpeed = 5;
        // 前方 180° 扇形，从 -90° 到 +90°
        double startAngle = -Math.PI / 2;
        double endAngle = Math.PI / 2;
        double step = (endAngle - startAngle) / (shootNum > 1 ? shootNum - 1 : 1);

        for (int i = 0; i < shootNum; i++) {
            double angle = startAngle + i * step;

            // 真正按角度旋转速度方向
            int speedX = (int) (baseSpeed * Math.sin(angle));
            int speedY = Math.abs((int) (baseSpeed * Math.cos(angle))) * direction;

            // 发射位置稍微拉开，避免叠在一起
            int bx = x + (i - shootNum / 2) * 3;

            BaseBullet bullet = new EnemyBullet(bx, y, speedX, speedY, power);
            res.add(bullet);
        }
        return res;
    }
}
