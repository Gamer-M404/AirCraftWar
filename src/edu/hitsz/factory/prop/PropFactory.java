package edu.hitsz.factory.prop;

import edu.hitsz.prop.*;

public class PropFactory{
    public AbstractProp create(int positionX, int positionY, int speedX, int speedY, String type){
        return switch (type) {
            case "PropBlood" -> new PropBlood(positionX, positionY, speedX, speedY);
            case "PropBomb" -> new PropBomb(positionX, positionY, speedX, speedY);
            case "PropBullet" -> new PropBullet(positionX, positionY, speedX, speedY);
            case "PropBulletPlus" -> new PropBulletPlus(positionX, positionY, speedX, speedY);
            case "PropFreeze" -> new PropFreeze(positionX, positionY, speedX, speedY);
            default -> null;
        };
    }
}
