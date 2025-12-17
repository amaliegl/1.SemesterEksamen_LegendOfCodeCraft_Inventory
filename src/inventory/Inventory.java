package inventory;

import exceptions.ExceedingMaxSlotCapacityException;
import exceptions.InventorySlotAlreadyEmptyException;
import exceptions.InventoryWeightLimitReachedException;
import exceptions.ExceedsAvailableSlotsException;
import items.Consumable;
import items.Item;
import java.io.Serializable;

public class Inventory implements Serializable {
    private final int maxSlots = 192;
    private final int defaultUnlockedSlots = 32;
    private int unlockedSlots = defaultUnlockedSlots;
    private final double maxWeight = 50;
    private final double defaultWeight = 0;
    private double currentWeight = defaultWeight;
    private InventorySlot[] items;

    public Inventory() {
        this.items = new InventorySlot[unlockedSlots];
        //add inventorySlots to all indicies
        for (int i = 0; i < this.items.length; i++) {
            items[i] = new InventorySlot();
        }
    }

    public InventorySlot[] getItems() {
        return items;
    }

    public void addItemToEmptySlot(Item item, int index) {
        items[index].addItem(item);
        addWeightToInventory(item);
    }

    public void addItemToStack(Item item, int index) {
        items[index].addToStack(item);
        addWeightToInventory(item);
    }

    private void addWeightToInventory(Item item){
        this.currentWeight += item.getWeight();
    }

    private void removeWeightFromInventory(double weight) {
        this.currentWeight -= weight;
    }

    public boolean checkIfItemWillExceedWeightLimit(Item item) {
        if (item.getWeight() + currentWeight <= maxWeight) {
            return true;
        } else {
            throw new InventoryWeightLimitReachedException("Adding item " + item + " will exceed inventory weight limit.");
        }
    }

    public void removeItemFromSlot(int index) throws InventorySlotAlreadyEmptyException {
        if (index > unlockedSlots || index < 0) {
            throw new ExceedsAvailableSlotsException("Attempting to remove an item from a locked slot");
        }
        //save weight of the item at items[index] to remove if consume() is successful
        double itemWeight = 0;
        if (items[index].getItem() != null) {
            itemWeight = items[index].getItem().getWeight();
        }
        this.items[index].consume(); //removes item
        removeWeightFromInventory(itemWeight); //remove the stored weight from inventory now that the item has been removed
    }

    //return index for available slot, else return -1
    public int slotWhereItemCanAddToStack(Item item) {
        if (item instanceof Consumable) {
            for (int i = 0; i < this.items.length; i++) {
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

    public String printSlotOverview(){
        String output = "";
        for (int i = 0; i < this.items.length; i++){
            if (items[i].getItem() != null) {
                String formattedItemWeight = String.format("%.2f", (items[i].getItem().getWeight() * items[i].getQuantity()));
                output += ("Slot " + (i + 1) + ": " + items[i].getItem().getName() + " (" + items[i].getQuantity() + "): " + formattedItemWeight +"kg\n");
            } else {
                output += "Slot " + (i + 1) + ": Empty\n";
            }
        }
        String formattedInventoryWeight = String.format("%.2f", this.currentWeight);
        output += ("Total inventory weight: " + formattedInventoryWeight + "kg");
        return output;
    }

    public void addSlots(int amount) {
        if ((this.unlockedSlots + amount) > maxSlots) {
            throw new ExceedingMaxSlotCapacityException("Cannot add " + amount + " slots as this will exceed maxSlots");
        } else {
            //create new temporary array with "amount" extra slots
            InventorySlot[] temp = new InventorySlot[this.items.length + amount];

            //copying contents of current array of slots into new array of slots
            for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }

            //adding extra empty slots to the temp inventory
            for (int i = items.length; i < temp.length; i++) {
                temp[i] = new InventorySlot();
            }

            //make our inventory become the newly created array of slots
            items = temp;
        }
    }

    public void factoryResetInventory(){
        for (int i = 0; i < this.items.length; i++) {
            if (items[i].getItem() != null) { //Checking if slot contains an item
                items[i].clearSlot();
            }
        }
        this.currentWeight = defaultWeight;
        this.unlockedSlots = defaultUnlockedSlots;
    }
}