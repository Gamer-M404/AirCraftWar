package edu.hitsz.factory.prop;

import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.PropBullet;

public class PropBulletFactory extends PropFactory{
    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return new PropBullet(positionX, positionY, speedX, speedY);
    }
}
