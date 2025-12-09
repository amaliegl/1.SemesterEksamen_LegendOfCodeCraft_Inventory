package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class Shield extends Weapon {

    public Shield(Rarity rarity, WeaponMaterial material) {
        super("Shield", rarity, material, WeaponHand.OFF_HAND, 5,10, 5);
        //name is always Shield, hand is always OFF_HAND, baseDamage is always 5, baseDefence is always 10, baseWeight is always 5
    }
}
