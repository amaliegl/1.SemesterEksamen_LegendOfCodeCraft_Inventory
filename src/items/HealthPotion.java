package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public class HealthPotion extends Consumable {

    public HealthPotion() {
        super("Health Potion",5, 0.2);
        //name is always Health Potion, maxStack is always 5, weight is always 0.2
    }
}
