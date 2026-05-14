package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.EliteEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class EliteEnemyFactory extends EnemyCreator {
    private final int baseSpeedX = 0;
    private final int baseSpeedY = 7;
    private final int baseHp = 30;
    @Override
    public AbstractFlyingObject create() {
        int spx = baseSpeedX == 0 ? baseSpeedX : (baseSpeedX + EnemyCreator.updateCycle);
        int spy = baseSpeedY == 0 ? baseSpeedY : (baseSpeedY + EnemyCreator.updateCycle);
        int hp = baseHp + 5 * updateCycle;
        return new EliteEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                spx,
                spy,
                hp
        );
    }
}
