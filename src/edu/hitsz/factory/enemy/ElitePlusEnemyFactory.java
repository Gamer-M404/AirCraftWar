package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.ElitePlusEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class ElitePlusEnemyFactory extends EnemyCreator{
    private final int baseSpeedX = 2;
    private final int baseSpeedY = 6;
    private final int baseHp = 50;
    @Override
    public AbstractFlyingObject create() {
        int spx = baseSpeedX == 0 ? baseSpeedX : (baseSpeedX + EnemyCreator.updateCycle);
        int spy = baseSpeedY == 0 ? baseSpeedY : (baseSpeedY + EnemyCreator.updateCycle);
        int hp = baseHp + 5 * updateCycle;
        return new ElitePlusEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_PLUS_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                spx,
                spy,
                hp
        );
    }
}
