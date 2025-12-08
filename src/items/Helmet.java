package items;

import enums.*;

public class Helmet extends Wearable {

    public Helmet(Rarity rarity, WearableMaterial material) {
        super("Helmet", rarity, material, BodyPart.HEAD, 8, 0.8);
        //name is always Helmet, bodyPart is always HEAD, baseDefence always 8 and baseWeight always 0.8
    }

}
