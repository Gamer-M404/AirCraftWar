package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.EliteEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class EliteEnemyFactory extends EnemyCreator {
    @Override
    public AbstractFlyingObject create() {
        return new EliteEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                0,
                10,
                30
        );
    }
}
