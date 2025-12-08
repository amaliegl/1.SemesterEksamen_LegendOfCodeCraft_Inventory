package items;
import enums.WeaponMaterial;

public class Arrow extends Consumable {
    private final WeaponMaterial material;
    private int damage = 1;
    //base damage is 1, more damage is added based on material in calculateDamage() method

    public Arrow(WeaponMaterial material) {
        super(30);
        //maxStack is always 30
        this.material = material;
        super.setWeight(calculateWeight(0.1));
        //baseWeight is always 0.1
        this.damage = calculateDamage();
        super.setName(createName());
    }

    public String createName() {
        String materialName = this.material.name();
        return materialName.charAt(0) + materialName.substring(1).toLowerCase() + " " + "Arrow";
        //name always ends in Arrow but first part of name depends on material
    }


    public double calculateWeight(double baseWeight) {
        double result;
        if (this.material == WeaponMaterial.WOOD) {
            result = baseWeight + 0;
        } else if (this.material == WeaponMaterial.STONE) {
            result = baseWeight + 0.1;
        } else if (this.material == WeaponMaterial.IRON) {
            result = baseWeight + 0.2;
        } else if (this.material == WeaponMaterial.STEEL) {
            result = baseWeight + 0.3;
        } else {
            result = baseWeight;
            // TODO - tjek "else"
        }
        return result;
    }

    private int calculateDamage(){
        int result;
        //calculates damage by combining the scores of rarity and material and base damage
        if (this.material == WeaponMaterial.WOOD){
            result = this.damage; //WOOD gives 0 extra damage
        } else if (this.material == WeaponMaterial.STONE){
            result = this.damage + 1;
        } else if (this.material == WeaponMaterial.IRON){
            result = this.damage + 2;
        } else if (this.material == WeaponMaterial.STEEL){
            result = this.damage + 3;
        } else {
            result = this.damage; //TODO tjek else
        }

        return result;
    }

    public WeaponMaterial getMaterial(){
        return this.material;
    }

    public int getMaxStack(){
        return super.getMaxStack();
    }


}
