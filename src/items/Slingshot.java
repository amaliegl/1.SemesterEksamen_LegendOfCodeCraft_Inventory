package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class Slingshot extends Weapon{
    //static attributes: are run as soon as the class is created as it's the same for all instances of this class
    private static final String name = "Slingshot";
    private static final WeaponHand hand = WeaponHand.TWO_HAND;
    private static final int damage = 8;
    private static final int defence = 1;
    private static final double weight = 1.2;

    public Slingshot(Rarity rarity, WeaponMaterial material) {
        super(name, rarity, material, hand, damage, defence, weight);
    }

}
