package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class Shield extends Weapon {

    public Shield(String name, Rarity rarity, WeaponMaterial material) {
        super("Shield", rarity, material, WeaponHand.ONE_HAND, 5,10, 5);
        //name is always Shield, WeaponHand is always ONE_HAND, baseDamage is always 5, baseDefence is always 10, baseWeight is always 5
    }
}
