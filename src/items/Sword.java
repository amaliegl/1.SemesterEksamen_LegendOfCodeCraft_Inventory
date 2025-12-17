package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class Sword extends Weapon {
    //static attributes: are run as soon as the class is created as it's the same for all instances of this class
    private static final String name = "Sword";
    private static final WeaponHand hand = WeaponHand.ONE_HAND;
    private static final int baseDamage = 15;
    private static final int baseDefence = 5;
    private static final double baseWeight = 2.5;

    public Sword(Rarity rarity, WeaponMaterial material) {
        super(name, rarity, material, hand, baseDamage, baseDefence, baseWeight);
    }
}
