package items;

import enums.*;

public class ChestPlate extends Wearable {

    public ChestPlate(Rarity rarity, WearableMaterial material) {
        super("Chest Plate", rarity, material, BodyPart.CHEST, 10, 1.8);
        //name is always Chest Plate, bodyPart is always CHEST, baseDefence always 10 and baseWeight always 1.8
    }

}
