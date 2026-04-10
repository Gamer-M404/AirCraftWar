package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.basic.AbstractFlyingObject;

public interface AircraftFactory {
    public abstract AbstractFlyingObject create();

    public abstract AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY);
}
