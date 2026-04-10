package edu.hitsz.factory.prop;

import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.PropBomb;

public class PropBombFactory extends PropFactory{
    @Override
    public AbstractFlyingObject create(int positionX, int positionY, int speedX, int speedY) {
        return new PropBomb(positionX, positionY, speedX, speedY);
    }
}
