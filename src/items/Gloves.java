package items;

import enums.*;

public class Gloves extends Wearable {
    /*private final BodyPart bodyPart = BodyPart.HANDS;
    private final int baseDefence = 3;
    private final double baseWeight = 0.5;*/

    public Gloves(Rarity rarity, WearableMaterial material) {
        super("Gloves", rarity, material, BodyPart.HANDS, 3, 0.5);
        //name is always Gloves, bodyPart is always HANDS, baseDefence always 3 and baseWeight always 0.5
    }

    /*public Gloves(Rarity rarity, WearableMaterial material) {
        super("Gloves", rarity, material, this.bodyPart, this.baseDefence, this.baseDefence);
    }
    */
}
