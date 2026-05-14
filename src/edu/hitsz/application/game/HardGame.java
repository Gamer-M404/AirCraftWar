package edu.hitsz.application.game;

import edu.hitsz.factory.enemy.EnemyCreator;

import javax.swing.*;

public class HardGame extends Game{
    private long lastUpdateTime = 0;        // 上次升级时间
    private final long DIFFICULTY_INTERVAL = 20 * 1000; // 20秒
    @Override
    protected void updateDifficulty() {
        EnemyCreator.setupdateBossHp(true);
        long now = System.currentTimeMillis();
        // 判断：距离上次升级 是否满 20 秒
        if (now - lastUpdateTime >= DIFFICULTY_INTERVAL) {
            this.enemySpawnCycle = this.enemySpawnCycle == 0 ? 0 : this.enemySpawnCycle - 1;
            this.shootCycle = this.shootCycle == 0 ? 0 : this.shootCycle - 1;
            this.enemyFactory.updateProperty();
            System.out.println("游戏难度升级，已来到第" + EnemyCreator.updateCycle + "级");

            // 更新最后升级时间
            lastUpdateTime = now;
        }
    }

}
