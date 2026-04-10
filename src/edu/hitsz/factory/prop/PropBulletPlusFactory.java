package edu.hitsz.factory.prop;

import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.PropBulletPlus;


public class PropBulletPlusFactory extends PropFactory{
    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return new PropBulletPlus(positionX, positionY, speedX, speedY);
    }
}
