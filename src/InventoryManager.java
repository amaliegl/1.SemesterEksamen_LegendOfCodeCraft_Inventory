import enums.Rarity;
import enums.WeaponMaterial;
import exceptions.ExceedingMaxSlotCapacityException;
import exceptions.InventoryWeightLimitReachedException;
import exceptions.NoEmptySlotsAvailableException;
import inventory.Inventory;
import inventory.InventorySlot;
import items.*;

import java.io.IOException;
import java.util.Arrays;

public class InventoryManager {
    private Inventory inventory;

    public InventoryManager() {
        this.inventory = new Inventory();
    }


    public void deserializeInventory(String fileName) throws IOException, ClassNotFoundException {
        SerializationClass serializationClass = new SerializationClass();
        Inventory tempInventory = serializationClass.deserializeInventory(fileName);
        if (tempInventory != null) {
            this.inventory = tempInventory;
        }
    }

    public void serializeInventory(String fileName) throws IOException {
        SerializationClass serializationClass = new SerializationClass();
        serializationClass.serializeInventory(fileName, this.inventory);
    }

    public String printSlotOverview() {
        return this.inventory.printSlotOverview();
    }

    public void addItem(Item item) throws InventoryWeightLimitReachedException {
        this.inventory.checkIfItemWillExceedWeightLimit(item);
        int stackIndex = this.inventory.slotWhereItemCanAddToStack(item);

        if (stackIndex != -1) {
            this.inventory.addItemToStack(item, stackIndex);
        } else if (this.inventory.hasAvailableSlot() != -1) {
            int index = this.inventory.hasAvailableSlot();
            this.inventory.addItemToEmptySlot(item, index);
        } else {
            throw new NoEmptySlotsAvailableException("Cannot find an empty slot in which to add " + item);
        }
    }

    public void removeItemFromSlot(int slot) {
        int index = slot - 1;
        inventory.removeItemFromSlot(index);
    }

    public String searchForItem(String searchParameter) {
        InventorySlot[] items = this.inventory.getItems();
        int amountInInventory = 0;
        String startMessage = ("You are searching for: " + searchParameter) + " and the system found "; //TODO evt lav en bedre promt
        String list = "";
        for (int i = 0; i < items.length; i++) {
            if (items[i].getItem() != null) {
                if (items[i].getItem().getName().contains(searchParameter)) {
                    amountInInventory += 1;
                    if (items[i].getItem() instanceof Consumable) {
                        list += ("Slot " + (i+1) + ": " + items[i].getItem().getName() + " (" + items[i].getQuantity() + ")\n");
                    } else {
                        list += ("Slot " + (i+1) + ": " + items[i].getItem().getName() + "\n");
                    }
                }
            }
        }
        return startMessage + amountInInventory + "\n" + list;
    }


    void dataSortAlphabetical() {
        InventorySlot[] items = this.inventory.getItems();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < items.length - 1; i++) { //-1 because you have to stop at the second to last item, to be able to compare with next
                //If item[i] and item[i+1] both contain an Item
                if (items[i].getItem() != null && items[i+1].getItem() != null) {
                    String itemName1 = items[i].getItem().getName();// the current item
                    String itemName2 = items[i + 1].getItem().getName(); // the item we compare with
                    if (itemName1.compareTo(itemName2) > 0) { //swap - the compareTo method sorts strings alphabetically by sending -1 if item2 is closer to A 0 if item2 os teh same as item1 and 1 if item2 s closer to z
                        swapped = true;
                        //swapping item1 and item2
                        InventorySlot item1 = items[i];
                        InventorySlot item2 = items[i + 1];
                        items[i] = item2;
                        items[i + 1] = item1;
                    }
                //If item[i] contains an Item and item[i+1] doesn't:
                } else if (items[i].getItem() != null && items[i+ 1].getItem() == null){
                    if (swapped) {
                        swapped = true;
                    } else {
                        swapped = false;
                    }
                //If item[i] doesn't contain an Item and item[i+1] does contain an Item:
                } else if (items[i].getItem() == null && items[i + 1].getItem() != null){
                    swapped = true;
                    //swapping item1 and item2
                    InventorySlot item1 = items[i];
                    InventorySlot item2 = items[i + 1];
                    items[i] = item2;
                    items[i + 1] = item1;
                //If item[i] and item[i+1] both don't contain an Item:
                } else {
                    if (swapped) {
                        swapped = true;
                    } else {
                        swapped = false;
                    }
                }
            }
        }
    }


    //TODO - find ud af, om det kan fungere med undersortering af weapon, wearable, consumable
    //
    public void dataSortByItem() {
        InventorySlot[] items = this.inventory.getItems();
        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < items.length - 1; i++) {

                boolean bothConsumables = items[i].getItem() instanceof Consumable && items[i + 1].getItem() instanceof Consumable;
                boolean bothWearables = items[i].getItem() instanceof Wearable && items[i + 1].getItem() instanceof Wearable;
                boolean bothWeapons = items[i].getItem() instanceof Weapon && items[i + 1].getItem() instanceof Weapon;

                // if (items[i].getItem() == null && items[i + 1].getItem() == null) -> no swap
                // if (items[i].getItem() instanceof Wearable && (items[i + 1].getItem() instanceof Weapon || items[i + 1].getItem() instanceof Consumable)) -> no swap
                // if (items[i].getItem() instanceof Wearable && items[i + 1].getItem() instanceof Consumable) -> no swap
                if (items[i].getItem() == null && items[i + 1].getItem() != null) {
                    swapped = true;
                    //swapping Item[i] and Item[i+1]
                    swapItems(i);
                } else if (items[i].getItem() instanceof Consumable && (items[i + 1].getItem() instanceof Wearable || items[i + 1].getItem() instanceof Weapon)) {
                    swapped = true;
                    //swapping Item[i] and Item[i+1]
                    swapItems(i);
                } else if (items[i].getItem() instanceof Weapon && items[i + 1].getItem() instanceof Wearable) {
                    swapped = true;
                    //swapping Item[i] and Item[i+1]
                    swapItems(i);
                } else if (bothWearables || bothWeapons || bothConsumables) {
                    if (items[i].getClass() == items[i+1].getClass()){
                        if (items[i].getItem().getName().compareTo(items[i + 1].getItem().getName()) > 0) {
                            swapped = true;
                            //swapping Item[i] and Item[i+1]
                            swapItems(i);
                        }
                    } /*else {
                        String item1name = items[i].getClass().getSimpleName();
                        String item2name = items[i + 1].getClass().getSimpleName();
                        if (item1name.compareTo(item2name) > 0) {
                            swapped = true;
                            //swapping Item[i] and Item[i+1]
                            swapItems(i);
                        }
                    }*/
                    //TODO - Ovenstående troede vi ville sortere klassenavne alfabetisk, men det gør den ikke
                        //items[i].getClass().getSimpleName().toString().compareTo(items[i + 1].getClass().getSimpleName().toString()
                        //sorter efter klassenavn
                }
            }
        } while (swapped);
    }

    private void swapItems(int i) {
        InventorySlot[] items = this.inventory.getItems();
        InventorySlot item1 = items[i];
        InventorySlot item2 = items[i + 1];
        items[i] = item2;
        items[i + 1] = item1;
    }

    public void addSlots(int amount) throws ExceedingMaxSlotCapacityException {
        this.inventory.addSlots(amount);
    }

    public void factoryResetInventory() {
        inventory.factoryResetInventory();
    }
}