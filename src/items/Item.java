package items;

public abstract class Item {
    private String name;
    private double weight;
    //private Rarity rarity;

    public Item() {
    }

    public String getName() {
        return this.name;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
