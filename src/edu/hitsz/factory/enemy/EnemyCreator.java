package edu.hitsz.factory.enemy;

import edu.hitsz.basic.AbstractFlyingObject;

public class EnemyCreator implements EnemyFactory{
    public static int updateCycle = 0;
    protected static boolean IsupdateBossHp = false;

    public static void setupdateBossHp(boolean update){
        IsupdateBossHp = update;
    }

    @Override
    public AbstractFlyingObject create() {
        return null;
    }

    @Override
    public void updateProperty() {
        updateCycle += 1;
    }
}
