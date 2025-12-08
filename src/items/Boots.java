package items;

import enums.BodyPart;
import enums.WeaponMaterial;
import enums.Rarity;
import enums.WearableMaterial;

public class Boots extends Wearable {

    public Boots(Rarity rarity, WearableMaterial material) {
        super("Boots", rarity, material, BodyPart.FEET, 5, 1.5);
        //name is always Boots, bodyPart is always FEET, baseDefence always 5 and baseWeight always 1.5
    }

}
