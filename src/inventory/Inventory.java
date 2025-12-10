package inventory;


import items.Consumable;
import items.Item;

import java.util.Arrays;

public class Inventory {
    private final int maxSlots = 192;
    private int unlockedSlots = 32;
    private final double maxWeight = 50;
    private double currentWeight = 0;
    private InventorySlot[] items;

    public Inventory() {
        this.items = new InventorySlot[unlockedSlots];
        //add inventorySlots to all indicies
        for (int i = 0; i < this.items.length; i++) {
            items[i] = new InventorySlot();
        }
    }
//TODO slet??
    /*public InventorySlot[] getItems() {
        return items;
    }*/



    public void addItemToEmptySlot(Item item, int index) {
        items[index].addItem(item);
        addWeightToInventory(item);
    }

    public void addItemToStack(Item item, int index) {
        items[index].addToStack(item);
        addWeightToInventory(item);
    }

    public void addWeightToInventory(Item item){
        this.currentWeight += item.getWeight();
    }


    //return index for available slot, else return -1
    public int slotWhereItemCanAddToStack(Item item) {
        if (item instanceof Consumable) {
            for (int i = 0; i < this.items.length; i++) {
                //TODO - find ud af, om det giver mening at tjekke quantity!=0 først
                if (this.items[i].canStackWith(item)) {
                    if (!this.items[i].isStackFull()) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    //return index of first empty slot, else return -1
    public int hasAvailableSlot() {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    public String printAll(){
        String output = "";
        for (int i = 0; i <items.length; i++){
            if (items[i].getItem() != null) {
                //output += ("Slot " + (i + 1) + ": " + items[i].getItem().getName() + " (" + items[i].getQuantity() + ")\n");
                output += ("Slot " + (i + 1) + ": " + items[i].getItem().getName() + " (" + items[i].getQuantity() + "): " + (items[i].getItem().getWeight() * items[i].getQuantity()) +"kg\n");
            } else {
                output += "Slot " + (i + 1) + ": Empty\n";
            }
        }
        output += ("Total inventory weight: " + this.currentWeight + "kg");
        return output;
    }

    //TODO - KUN TIL TEST!!
    @Override
    public String toString() {
        return "Inventory{" +
                "maxSlots=" + maxSlots +
                ", unlockedSlots=" + unlockedSlots +
                ", maxWeight=" + maxWeight +
                ", currentWeight=" + currentWeight +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}

