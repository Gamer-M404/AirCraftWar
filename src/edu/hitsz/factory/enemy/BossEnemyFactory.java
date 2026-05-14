package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.enemies.BossEnemy;
import edu.hitsz.aircraft.enemies.EliteProEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

public class BossEnemyFactory extends EnemyCreator{
    private final int baseSpeedX = 1;
    private final int baseSpeedY = 0;
    private final int baseHp = 300;
    @Override
    public AbstractFlyingObject create() {
        int spx = baseSpeedX == 0 ? baseSpeedX : (baseSpeedX + EnemyCreator.updateCycle);
        int spy = baseSpeedY == 0 ? baseSpeedY : (baseSpeedY + EnemyCreator.updateCycle);
        int hp = EnemyCreator.IsupdateBossHp ? baseHp + 10 * EnemyCreator.updateCycle : baseHp;
        return new BossEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.BOSS_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                spx,
                spy,
                hp
        );
    }
}
