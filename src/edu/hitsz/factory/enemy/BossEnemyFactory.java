package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.BossEnemy;
import edu.hitsz.aircraft.enemies.EliteProEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class BossEnemyFactory extends EnemyFactory{
    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return new BossEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.BOSS_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                8,
                0,
                30
        );
    }
}
