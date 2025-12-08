package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class Sword extends Weapon {

    public Sword(Rarity rarity, WeaponMaterial material) {
        super("Sword", rarity, material, WeaponHand.ONE_HAND, 5,15, 3);
        //name is always Sword, hand is always ONE_HAND, baseDamage always 5, baseDefence always 15 and baseWeight always 3
    }
}
