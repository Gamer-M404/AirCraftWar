package edu.hitsz.shootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.BaseBullet;

import java.util.List;

public interface Strategy {
    public abstract List<BaseBullet> shootStrategy(AbstractAircraft plane, int direction, int shootNum, int power);
}
