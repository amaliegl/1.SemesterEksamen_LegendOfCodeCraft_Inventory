package inventory;


import exceptions.ExceedingMaxSlotCapacityException;
import exceptions.InventorySlotAlreadyEmptyException;
import exceptions.InventoryWeightLimitReachedException;
import exceptions.ExceedsAvailableSlotsException;
import items.Consumable;
import items.Item;
import items.SerializationClass;

import java.io.IOException;
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
    public InventorySlot[] getItems() {
        return items;
    }

    public String serialize() throws IOException {
        SerializationClass serializationClass = new SerializationClass();
        serializationClass.serializeObjectArray(this.items);
        return "Det er vidst gjort??";
    }


    public void addItemToEmptySlot(Item item, int index) {
        items[index].addItem(item);
        addWeightToInventory(item);
    }

    //TODO Tjek om vægt kan lægges i inventory - så læg i inventory og tillæg vægt bagefter

    public void addItemToStack(Item item, int index) {
        items[index].addToStack(item);
        addWeightToInventory(item);
    }

    //TODO - kan den være private?
    public void addWeightToInventory(Item item){
        this.currentWeight += item.getWeight();
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
            //TODO - skal der være en ekstra exception, som håndterer ugyldige slots (<0 og >192)?
        }
        this.items[index].consume();
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

    public String printSlotOverview(){
        String output = "";
        for (int i = 0; i <items.length; i++){
            if (items[i].getItem() != null) {
                output += ("Slot " + (i + 1) + ": " + items[i].getItem().getName() + " (" + items[i].getQuantity() + "): " + (items[i].getItem().getWeight() * items[i].getQuantity()) +"kg\n");
            } else {
                output += "Slot " + (i + 1) + ": Empty\n";
            }
        }
        output += ("Total inventory weight: " + this.currentWeight + "kg");
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

            //adding empty slots to the newly added slots
            for (int i = items.length; i < temp.length; i++) {
                temp[i] = new InventorySlot();
            }

            //make our inventory equal the newly created array of slots
            items = temp;
        }
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