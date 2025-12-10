package items;

import enums.Rarity;
import enums.WeaponHand;
import enums.WeaponMaterial;

public abstract class Weapon extends Item{
    private final WeaponHand hand;
    private final WeaponMaterial material;
    private final int defence; //TODO spørg Mor eller Far -- skal vi lave gettere og settere på de attributter som spillet måske vil bruge udenfor vores inventory
    private final int damage;
    private final Rarity rarity;

    //Used for Bow
    public Weapon(String name, Rarity rarity, WeaponMaterial material, WeaponHand hand, int baseDamage, int baseDefence, double baseWeight){
        super();
        this.rarity = rarity;
        this.material = material;
        this.hand = hand;
        this.damage = calculateDamage(baseDamage);
        this.defence = calculateDefence(baseDefence);
        super.setWeight(calculateWeight(baseWeight));
        super.setName(createName(name));
    }

    public String createName(String name) {
        String materialName = this.material.name().charAt(0) + this.material.name().substring(1).toLowerCase();
        String rarityName = this.rarity.name().charAt(0) + this.rarity.name().substring(1).toLowerCase();
        return materialName + " " + name + " [" + rarityName + "]";
    }

    private int calculateDamage(int baseDamage) {
        int result;
        int rarityScore;
        //Sets the score of rarity
        if (this.rarity == Rarity.COMMON) {
            rarityScore = 0;
        } else if (this.rarity == Rarity.UNCOMMON) {
            rarityScore = 1;
        } else if (this.rarity == Rarity.RARE) {
            rarityScore = 2;
        } else if (this.rarity == Rarity.LEGENDARY) {
            rarityScore = 3;
        } else {
            rarityScore = 0; //TODO tjek else
        }
        //calculates damage by combining the scores of rarity and material and base damage
        if (this.material == WeaponMaterial.WOOD) {
            result = baseDamage + rarityScore; //WOOD gives 0 extra damage
        } else if (this.material == WeaponMaterial.STONE) {
            result = baseDamage + rarityScore + 1;
        } else if (this.material == WeaponMaterial.IRON) {
            result = baseDamage + rarityScore + 2;
        } else if (this.material == WeaponMaterial.STEEL) {
            result = baseDamage + rarityScore + 3;
        } else {
            result = baseDamage + rarityScore; //TODO tjek else
        }
        return result;
    }

    private int calculateDefence(int baseDefence) {
        int addedDefence = 0;
        //Calculate added defence from rarity
        if (this.rarity == Rarity.COMMON) {
            addedDefence += 0;
        } else if (this.rarity == Rarity.UNCOMMON) {
            addedDefence += 1;
        } else if (this.rarity == Rarity.RARE) {
            addedDefence += 2;
        } else if (this.rarity == Rarity.LEGENDARY) {
            addedDefence += 3;
        } else {
            addedDefence += 0;
            // TODO - tjek "else"
        }

        //Calculate added defence from material
        if (this.material == WeaponMaterial.WOOD) {
            addedDefence += 0;
        } else if (this.material == WeaponMaterial.STONE) {
            addedDefence += 1;
        } else if (this.material == WeaponMaterial.IRON) {
            addedDefence += 2;
        } else if (this.material == WeaponMaterial.STEEL) {
            addedDefence += 3;
        } else {
            addedDefence += 0;
            // TODO - tjek "else"
        }

        return baseDefence + addedDefence;
    }

    public double calculateWeight(double baseWeight) {
        double result;
        if (this.material == WeaponMaterial.WOOD) {
            result = baseWeight + 0;
        } else if (this.material == WeaponMaterial.STONE) {
            result = baseWeight + 1;
        } else if (this.material == WeaponMaterial.IRON) {
            result = baseWeight + 2;
        } else if (this.material == WeaponMaterial.STEEL) {
            result = baseWeight + 3;
        } else {
            result = baseWeight;
            // TODO - tjek "else"
        }
        return result;
    }
}

