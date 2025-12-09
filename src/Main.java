import enums.Rarity;
import enums.WeaponMaterial;
import inventory.Inventory;
import items.Item;
import items.Sword;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Sword(Rarity.COMMON, WeaponMaterial.WOOD);

        System.out.println("Forventet output: Wood Sword");
        System.out.println(item1.getName());


        InventoryManager inventoryManager = new InventoryManager();

        //TODO - lav metode i inventoryManager til at oprette inventory med navn, der kan bruges
        Inventory inventory = new Inventory();

        inventoryManager.addItem(inventory); //tilføj sværd
        System.out.println(inventoryManager.printAll(inventory));
        System.out.println();
    }
}