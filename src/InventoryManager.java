import enums.Rarity;
import enums.WeaponMaterial;
import inventory.Inventory;
import items.Item;
import items.Sword;

public class InventoryManager {


    public InventoryManager(){

    }

    //TODO -
    public String printAll(Inventory inventory) {
        return inventory.toString();
    }

    public void addItem(Inventory inventory) {
        Item item = createSword();
        int stackIndex = inventory.slotWhereItemCanAddToStack(item);

        if (stackIndex != -1) {
            inventory.addItemToStack(item, stackIndex);
        } else if (inventory.hasAvailableSlot() != -1) {
            int index = inventory.hasAvailableSlot();
            inventory.addItemToEmptySlot(item, index);
        }
        // TODO - exception "din inventory er fuld" (eller lignende)
    }

    private Item createSword() {
        Rarity rarity = Rarity.LEGENDARY;
        WeaponMaterial material = WeaponMaterial.STEEL;
        Item testSword = new Sword(rarity, material);

        return testSword;
    }

    /*public Inventory createInventory(){
        return new Inventory();
    }
    //Hvordan får man lavet en inventory med et navn, man kan henvise til senere?
    */

}