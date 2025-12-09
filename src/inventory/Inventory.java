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

    public InventorySlot[] getItems() {
        return items;
    }



    public void addItemToEmptySlot(Item item, int index) {
        items[index].addItem(item);
    }

    public void addItemToStack(Item item, int index) {
        items[index].addToStack(item);
    }

    /*public boolean addItemToInventoryCapacity(Item item) {
        //tjek om der er ledig plads i eksisterende stack - hvis ja så tilføj
        //ellers: er der ledig slot - hvis ja så tilføj
        int stackIndex = slotWhereItemCanAddToStack(item);
        if (stackIndex != -1) {
            int currentStackSize = items[stackIndex].getQuantity();
            items[stackIndex].setQuantity(currentStackSize + 1);
            return true;
        }
        int index = hasAvailableSlot();
        if (index != -1) {
            items[index].addItem(item);
            return true;
        }
        return false;
        //exception "inventory fuld" (eller lignende)
    }*/


    //TODO kig på navn
    //slotAvailableForStacking
    //slotAvailableForStackableItem
    //isStackableWithItem
    //occupiedSlotWithRoomForStackableItem
    //slotWithExtraRoomForItem
    //slotWithNotFullStack
    //findSlotWithStackOfItemThatIsNotFull
    //findSlotStackWithRoomForItem
    //slotWhereItemCanAddToStack
    //slotWithExistingItemStack

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

    //check if a slot is empty
    public int hasAvailableSlot() {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i].isEmpty()) {
                return i;
            }
        }
        return -1;
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

