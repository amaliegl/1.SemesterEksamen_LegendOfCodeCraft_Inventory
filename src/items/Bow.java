package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;
import enums.WearableMaterial;

public class Bow extends Weapon {

    public Bow(String name, Rarity rarity, WeaponMaterial material) {
        super("Bow", rarity, material, WeaponHand.ONE_HAND, 7,1, 7);
        //name is always Bow, hand is always ONE_HAND, baseDamage always 7, baseDefence always 1 and baseWeight always 7
    }
}
