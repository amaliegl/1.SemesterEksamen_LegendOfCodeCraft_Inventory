package inventory;

import interfaces.ConsumableWithMaterial;
import items.Consumable;
import items.Item;

public class InventorySlot {
    private Item item;
    private int quantity;
    //TODO - "ikke objektorienteret nok" - skal det ligge som array i stedet for?

    public InventorySlot() {

    }

    public int getQuantity() {
        return this.quantity;
    }

    public Item getItem() {
        return this.item;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void addItem(Item item) {
        if (isEmpty()) {
            this.item = item;
            this.quantity = 1;
        } else {
            //TODO - exception "slot er optaget"
        }
    }

    public void addToStack(Item item){
        if (canStackWith(item) && !isStackFull()){
            this.quantity += 1;
        } else {
            //TODO - exception "kan ikke tilføje til stack" (eller lignende)
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
            return true; //TODO - kig på returnering

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
            //TODO - exception
        } else {
            this.quantity = 0;
            this.item = null;
        }
    }

    //TODO -KUN TIL TEST
    @Override
    public String toString() {
        return "InventorySlot{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
