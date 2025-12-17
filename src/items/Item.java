package items;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String name;
    private double weight;

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
