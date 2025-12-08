package items;

import enums.*;

public class Gloves extends Wearable {

    public Gloves(Rarity rarity, WearableMaterial material) {
        super("Gloves", rarity, material, BodyPart.HANDS, 3, 0.5);
        //name is always Gloves, bodyPart is always HANDS, baseDefence always 3 and baseWeight always 0.5
    }
}
