package edu.hitsz.factory.enemy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.basic.AbstractFlyingObject;

public interface EnemyFactory {
    public abstract AbstractFlyingObject create();
}
