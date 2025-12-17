package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class Shield extends Weapon {
    //static attributes: are run as soon as the class is created as it's the same for all instances of this class
    private static final String name = "Shield";
    private static final WeaponHand hand = WeaponHand.OFF_HAND;
    private static final int baseDamage = 5;
    private static final int baseDefence = 10;
    private static final double baseWeight = 3.5;

    public Shield(Rarity rarity, WeaponMaterial material) {
        super(name, rarity, material, hand, baseDamage, baseDefence, baseWeight);
    }
}
