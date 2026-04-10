package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.BossEnemy;
import edu.hitsz.aircraft.enemies.EliteProEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class BossEnemyFactory extends EnemyFactory{
    @Override
    public AbstractFlyingObject create() {
        return new BossEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.BOSS_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                2,
                0,
                300
        );
    }
}
