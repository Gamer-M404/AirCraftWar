package edu.hitsz.factory.prop;

import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.PropFreeze;


public class PropFreezeFactory extends PropFactory{
    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return new PropFreeze(positionX, positionY, speedX, speedY);
    }
}
