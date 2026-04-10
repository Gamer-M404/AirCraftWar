package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.ElitePlusEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class ElitePlusEnemyFactory extends EnemyFactory{
    @Override
    public AbstractFlyingObject create() {
        return new ElitePlusEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_PLUS_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                2,
                5,
                30
        );
    }
}
