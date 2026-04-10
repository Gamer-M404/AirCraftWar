package edu.hitsz.shootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.BaseBullet;

import java.util.LinkedList;
import java.util.List;

public class NoneShoot implements Strategy{
    @Override
    public List<BaseBullet> shootStrategy(AbstractAircraft plane, int direction, int shootNum, int power) {
        return new LinkedList<>();
    }
}
