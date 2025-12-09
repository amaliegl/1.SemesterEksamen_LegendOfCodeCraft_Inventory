package items;

import enums.*;

public class Wearable extends Item {
    BodyPart bodyPart;
    WearableMaterial material;
    int defence;
    Rarity rarity;

    public Wearable(String name, Rarity rarity, WearableMaterial material, BodyPart bodyPart, int baseDefence, double baseWeight) {
        super();
        this.rarity = rarity;
        this.material = material;
        this.bodyPart = bodyPart;
        this.defence = calculateDefence(baseDefence);
        super.setWeight(calculateWeight(baseWeight));
        super.setName(createName(name));
    }

    public String createName(String name) {
        String materialName = this.material.name();
        return materialName.charAt(0) + materialName.substring(1).toLowerCase() + " " + name;
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
        if (this.material == WearableMaterial.LEATHER) {
            addedDefence += 0;
        } else if (this.material == WearableMaterial.IRON) {
            addedDefence += 1;
        } else if (this.material == WearableMaterial.STEEL) {
            addedDefence += 2;
        } else if (this.material == WearableMaterial.CHAINMAIL) {
            addedDefence += 3;
        } else {
            addedDefence += 0;
            // TODO - tjek "else"
        }

        return this.defence + addedDefence;
    }

    private double calculateWeight(double baseWeight) {
        double result;
        if (this.material == WearableMaterial.LEATHER) {
            result = baseWeight + 0;
        } else if (this.material == WearableMaterial.IRON) {
            result = baseWeight + 1;
        } else if (this.material == WearableMaterial.STEEL) {
            result = baseWeight + 2;
        } else if (this.material == WearableMaterial.CHAINMAIL) {
            result = baseWeight + 1.7;
        } else {
            result = baseWeight;
            // TODO - tjek "else"
        }
        return result;
    }

}
