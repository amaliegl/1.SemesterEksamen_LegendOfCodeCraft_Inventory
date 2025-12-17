package items;

import enums.ConsumableMaterial;
import interfaces.ConsumableWithMaterial;

public class Pellet extends Consumable implements ConsumableWithMaterial {
    //static attributes: are run as soon as the class is created as it's the same for all instances of this class
    private static final String name = "Pellet";
    private final ConsumableMaterial material;
    private int damage = 1; //base damage is 1, more damage is added based on material in calculateDamage() method
    private static final double baseWeight = 0.05;
    private static final int maxStack = 50;

    public Pellet(ConsumableMaterial material) {
        super(maxStack);
        this.material = material;
        super.setWeight(calculateWeight(baseWeight));
        this.damage = calculateDamage();
        super.setName(createName());
    }

    public ConsumableMaterial getMaterial(){
        return this.material;
    }

    private String createName() {
        String materialName = this.material.name();
        return materialName.charAt(0) + materialName.substring(1).toLowerCase() + " " + this.name;
        //name always ends in class name but first part of name depends on material
    }

    public double calculateWeight(double baseWeight) {
        double result;
        if (this.material == ConsumableMaterial.WOOD) {
            result = baseWeight + 0;
        } else if (this.material == ConsumableMaterial.STONE) {
            result = baseWeight + 0.1;
        } else if (this.material == ConsumableMaterial.FLINT) {
            result = baseWeight + 0.2;
        } else { //if this.material == ConsumableMaterial.STEEL
            result = baseWeight + 0.25;
        }
        return result;
    }

    private int calculateDamage(){
        int result;
        //calculates damage by combining the scores of rarity and material and base damage
        if (this.material == ConsumableMaterial.WOOD){
            result = this.damage; //WOOD gives 0 extra damage
        } else if (this.material == ConsumableMaterial.STONE){
            result = this.damage + 1;
        } else if (this.material == ConsumableMaterial.FLINT){
            result = this.damage + 2;
        } else { //if this.material == ConsumableMaterial.STEEL
            result = this.damage + 3;
        }
        return result;
    }
}
