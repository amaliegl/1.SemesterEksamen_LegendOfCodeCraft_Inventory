package inventory;

import exceptions.InventorySlotAlreadyEmptyException;
import interfaces.ConsumableWithMaterial;
import items.Consumable;
import items.Item;

import java.io.Serializable;

public class InventorySlot implements Serializable {
    private Item item;
    private int quantity;

    public InventorySlot() {

    }

    public int getQuantity() {
        return this.quantity;
    }

    public Item getItem() {
        return this.item;
    }

    public void addItem(Item item) {
        if (isEmpty()) {
            this.item = item;
            this.quantity = 1;
        }
    }

    public void addToStack(Item item){
        if (canStackWith(item) && !isStackFull()){
            this.quantity += 1;
        }
    }

    public boolean isEmpty(){
        if (quantity == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canStackWith(Item item) {
        if (item instanceof Consumable && this.item instanceof Consumable) {
            if (item.getClass().equals(this.item.getClass())) {
                if (item instanceof ConsumableWithMaterial) {
                    //Downcasting to ItemWithMaterial
                    ConsumableWithMaterial consumableWithMaterial = (ConsumableWithMaterial) item;
                    ConsumableWithMaterial thisconsumableWithMaterial = (ConsumableWithMaterial) this.item;
                    //Checks if the material of the objects are the same
                    if (consumableWithMaterial.getMaterial() == thisconsumableWithMaterial.getMaterial()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isStackFull(){
        if (this.item instanceof Consumable) {
            //Downcasting
            Consumable myConsumable = (Consumable)this.item;
            if (myConsumable.getMaxStack() == this.quantity) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.item != null) { //if there is a non-consumable item in the slot
                return true;
            }
            return false;
        }
    }

    public void consume() {
        if (quantity > 1) {
            this.quantity -= 1;
        } else {
            clearSlot();
        }
    }

    public void clearSlot() {
        if (isEmpty()) {
            throw new InventorySlotAlreadyEmptyException("Trying to remove item from an empty slot");
        } else {
            this.quantity = 0;
            this.item = null;
        }
    }
}
