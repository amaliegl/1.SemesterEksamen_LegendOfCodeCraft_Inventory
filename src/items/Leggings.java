package items;

import enums.*;

public class Leggings extends Wearable {

    public Leggings(Rarity rarity, WearableMaterial material) {
        super("Leggings", rarity, material, BodyPart.LEGS, 6, 1.2);
        //name is always Leggings, bodyPart is always LEGS, baseDefence always 6 and baseWeight always 1.2
    }

}
