package items;

import enums.Rarity;
import enums.WeaponMaterial;

public class Consumable extends Item {
    private final int maxStack;
    //private int damage;
    //private Rarity rarity = Rarity.COMMON; //TODO - er den god at have med eller ligemeget

    public Consumable(String name, int maxStack, double weight) {
        super();
        this.maxStack = maxStack;
    } //Used for HealthPotion

    //Overloaded
    public Consumable(int maxStack) {
        super();
        this.maxStack = maxStack;
    }
    //Used for Arrows

    public int getMaxStack(){
        return this.maxStack;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setWeight(double weight) {
        super.setWeight(weight);
    }

}