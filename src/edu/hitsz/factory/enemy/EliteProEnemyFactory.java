package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.EliteProEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class EliteProEnemyFactory extends EnemyCreator{
    private final int baseSpeedX = 4;
    private final int baseSpeedY = 8;
    private final int baseHp = 60;
    @Override
    public AbstractFlyingObject create() {
        int spx = baseSpeedX == 0 ? baseSpeedX : (baseSpeedX + EnemyCreator.updateCycle);
        int spy = baseSpeedY == 0 ? baseSpeedY : (baseSpeedY + EnemyCreator.updateCycle);
        int hp = baseHp + 5 * updateCycle;
        return new EliteProEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_PRO_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                spx,
                spy,
                hp
        );
    }

}
