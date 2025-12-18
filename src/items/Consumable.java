package items;

public abstract class Consumable extends Item {
    private final int maxStack;

    public Consumable(String name, int maxStack, double weight) {
        super();
        this.maxStack = maxStack;
        super.setName(name);
        super.setWeight(weight);
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