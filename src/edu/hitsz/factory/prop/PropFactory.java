package edu.hitsz.factory.prop;

import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.factory.AircraftFactory;

public class PropFactory implements AircraftFactory {
    @Override
    public AbstractFlyingObject create() {
        return null;
    }

    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return null;
    }
}
