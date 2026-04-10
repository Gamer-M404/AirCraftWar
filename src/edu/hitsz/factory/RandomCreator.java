package edu.hitsz.factory;

import edu.hitsz.factory.enemy.*;
import edu.hitsz.factory.prop.*;
import edu.hitsz.prop.PropBullet;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCreator {

    // 随机生成一种敌人工厂
    public EnemyFactory randomlyCreateEnemy(){
        // 随机产生一个[0, 1]之间的值
        double r = ThreadLocalRandom.current().nextDouble(1);
        // 定义不同敌机的生成概率
        double ELITE_PRO_PROB = 0.05;
        double ELIE_PLUS_PROB = 0.25;
        double ELITE_PROB = 0.3;
        double MOB_PROB = 0.4;

        if(r < MOB_PROB){
            return new MobEnemyFactory();
        }else if(r < MOB_PROB + ELITE_PROB){
            return new EliteEnemyFactory();
        }else if(r < MOB_PROB + ELITE_PROB + ELIE_PLUS_PROB){
            return new ElitePlusEnemyFactory();
        }else if(r < MOB_PROB + ELITE_PROB + ELIE_PLUS_PROB + ELITE_PRO_PROB){
            return new EliteProEnemyFactory();
        }else {
            // 走不到这里
            return null;
        }
    }

    // 随机生成一个道具
    public PropFactory randomlyCreateProp(){
        // 依旧随机生成一个[0，1]之间的数
        double r = ThreadLocalRandom.current().nextDouble(1);
        // 设置一下各道具出现的概率
        double BLOOD_PROP = 0.2;
        double BOMB_PROP = 0.2;
        double BULLET_PROP = 0.2;
        double BULLET_PLUS_PROP = 0.2;
        double FREEZE_PROP = 0.2;

        if(r < BOMB_PROP){
            return new PropBloodFactory();
        }else if (r < BOMB_PROP + BOMB_PROP){
            return new PropBombFactory();
        }else if(r < BLOOD_PROP + BOMB_PROP + BULLET_PROP){
            return new PropBulletFactory();
        }else if(r < BLOOD_PROP + BOMB_PROP + BULLET_PROP + BULLET_PLUS_PROP){
            return  new PropBulletPlusFactory();
        }else if(r < BLOOD_PROP + BOMB_PROP + BULLET_PROP + BULLET_PLUS_PROP + FREEZE_PROP){
            return new PropFreezeFactory();
        }else{
            return null;
        }
    }

    public int[] randomSpeed(){
        int spx = ThreadLocalRandom.current().nextInt(1, 15);
        int spy = ThreadLocalRandom.current().nextInt(1, 15);
        return new int[]{spx, spy};
    }
}
