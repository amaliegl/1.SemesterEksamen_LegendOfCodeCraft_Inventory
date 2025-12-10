import enums.ConsumableMaterial;
import enums.Rarity;
import enums.WeaponMaterial;
import enums.WearableMaterial;
import inventory.Inventory;
import items.*;

public class Main {
    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager();

        //TODO - lav metode i inventoryManager til at oprette inventory med navn, der kan bruges
        Inventory inventory = new Inventory();

        //inventoryManager.addItem(inventory); //tilføj sværd

        //lav 10 tilfældige items
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, new Arrow(ConsumableMaterial.WOOD));
        inventoryManager.addItem(inventory, new Arrow(ConsumableMaterial.WOOD));
        inventoryManager.addItem(inventory, new Arrow(ConsumableMaterial.STEEL));

        //lav 10 items
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));
        inventoryManager.addItem(inventory, createItem(createRandomItemType()));


        System.out.println(inventoryManager.printAll(inventory));
    }



    public static Item createItem(String type){
        switch (type.toLowerCase()){
            case "arrow": return new Arrow(createRandomConsumableMaterial());
            case "boots": return new Boots(createRandomRarity(),createRandomWearableMaterial());
            case "bow": return new Bow(createRandomRarity(), createRandomWeaponMaterial());
            case "chestplate" : return new ChestPlate(createRandomRarity(), createRandomWearableMaterial());
            case "gloves" : return new Gloves(createRandomRarity(), createRandomWearableMaterial());
            case "healthpotion" : return new HealthPotion();
            case "helmet" : return new Helmet(createRandomRarity(), createRandomWearableMaterial());
            case "leggings" : return new Leggings(createRandomRarity(), createRandomWearableMaterial());
            case "pellet" : return new Pellet(createRandomConsumableMaterial());
            case "shield" : return new Shield(createRandomRarity(), createRandomWeaponMaterial());
            case "slingshot" : return new Slingshot(createRandomRarity(), createRandomWeaponMaterial());
            case "sword" : return new Sword(createRandomRarity(), createRandomWeaponMaterial());
            default: return null;
        }
    }

    public static String createRandomItemType() {
        String itemType;

        //create random number
        int min = 1;
        int max = 12;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;

        switch (randomNumber) {
            case 1: itemType = "Arrow"; break;
            case 2: itemType = "Boots"; break;
            case 3: itemType = "Bow"; break;
            case 4: itemType = "ChestPlate"; break;
            case 5: itemType = "Gloves"; break;
            case 6: itemType = "HealthPotion"; break;
            case 7: itemType = "Helmet"; break;
            case 8: itemType = "Leggings"; break;
            case 9: itemType = "Pellet"; break;
            case 10: itemType = "Shield"; break;
            case 11: itemType = "Slingshot"; break;
            case 12: itemType = "Sword"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
                //IntelliJ foreslog ovenstående
        }
        return itemType;
    }

    public static WeaponMaterial createRandomWeaponMaterial() {
        WeaponMaterial material;

        //create random number
        int min = 1;
        int max = 4;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;

        switch (randomNumber) {
            case 1: material = WeaponMaterial.WOOD; break;
            case 2: material = WeaponMaterial.STONE; break;
            case 3: material = WeaponMaterial.IRON; break;
            case 4: material = WeaponMaterial.STEEL; break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
                //IntelliJ foreslog ovenstående
        }
        return material;
    }

    public static WearableMaterial createRandomWearableMaterial() {
        WearableMaterial material;

        //create random number
        int min = 1;
        int max = 4;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;

        switch (randomNumber) {
            case 1: material = WearableMaterial.LEATHER; break;
            case 2: material = WearableMaterial.IRON; break;
            case 3: material = WearableMaterial.STEEL; break;
            case 4: material = WearableMaterial.CHAINMAIL; break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
                //IntelliJ foreslog ovenstående
        }
        return material;
    }

    public static ConsumableMaterial createRandomConsumableMaterial() {
        ConsumableMaterial material;

        //create random number
        int min = 1;
        int max = 4;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;

        switch (randomNumber) {
            case 1: material = ConsumableMaterial.WOOD; break;
            case 2: material = ConsumableMaterial.STONE; break;
            case 3: material = ConsumableMaterial.STONE; break;
            case 4: material = ConsumableMaterial.STEEL; break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
                //IntelliJ foreslog ovenstående
        }
        return material;
    }

    public static Rarity createRandomRarity() {
        Rarity rarity;

        //create random number
        int min = 1;
        int max = 100;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;

        if(randomNumber < 51) {
            rarity = Rarity.COMMON;
        } else if (randomNumber < 81) {
            rarity = Rarity.UNCOMMON;
        } else if (randomNumber < 96) {
            rarity = Rarity.RARE;
        } else {
            rarity = Rarity.LEGENDARY;
        }

        return rarity;
    }
}