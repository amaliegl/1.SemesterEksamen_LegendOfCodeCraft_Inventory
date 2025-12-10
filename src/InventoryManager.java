import enums.Rarity;
import enums.WeaponMaterial;
import inventory.Inventory;
import items.Item;
import items.Sword;

public class InventoryManager {


    public InventoryManager(){

    }

    //TODO - LAV PÆNERE!!!!!
    public String printAll(Inventory inventory) {
        return inventory.printAll();
    }

    public void addItem(Inventory inventory, Item item) {
        //Item item = createSword(); //SKAL SLETTES - TIL TEST TODO
        int stackIndex = inventory.slotWhereItemCanAddToStack(item);

        if (stackIndex != -1) {
            inventory.addItemToStack(item, stackIndex);
        } else if (inventory.hasAvailableSlot() != -1) {
            int index = inventory.hasAvailableSlot();
            inventory.addItemToEmptySlot(item, index);
        }
        // TODO - exception "din inventory er fuld" (eller lignende)
    }

    //TODO TIL TEST! SLEEEEEEET
    /*private Item createSword() {
        Rarity rarity = Rarity.LEGENDARY;
        WeaponMaterial material = WeaponMaterial.STEEL;
        Item testSword = new Sword(rarity, material);

        return testSword;
    }*/

    /*public Inventory createInventory(){
        return new Inventory();
    }
    //Hvordan får man lavet en inventory med et navn, man kan henvise til senere?
    */

}