package edu.hitsz.factory.prop;

import edu.hitsz.prop.PropBlood;
import edu.hitsz.basic.AbstractFlyingObject;

public class PropBloodFactory extends PropFactory{


    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return new PropBlood(positionX, positionY, speedX, speedY);
    }
}
