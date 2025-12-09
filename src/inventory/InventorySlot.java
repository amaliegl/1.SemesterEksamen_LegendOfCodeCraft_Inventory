package inventory;

import items.Arrow;
import items.Consumable;
import items.HealthPotion;
import items.Item;

public class InventorySlot {
    private Item item;
    private int quantity;

    public InventorySlot() {

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
            if (item instanceof HealthPotion && this.item instanceof HealthPotion) {
                return true;
            } else if (item instanceof Arrow && this.item instanceof Arrow) {
                //Downcasting of arrow
                Arrow itemArrow = (Arrow)item;
                Arrow thisItemArrow = (Arrow)item;
                if (itemArrow.getMaterial() == thisItemArrow.getMaterial()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false; //TODO - kig på returnering
            }
        } else {
            return false;
        }
    }

    public boolean isStackFull(){
        //Downcasting consumables
        if (this.item instanceof Consumable) {
            if (this.item instanceof Arrow) {
                Arrow myArrow = (Arrow) this.item;
                if (myArrow.getMaxStack() == this.quantity) {
                    return true;
                } else {
                    return false;
                }
            } else if (this.item instanceof HealthPotion) {
                HealthPotion myHealthPotion = (HealthPotion) this.item;
                if (myHealthPotion.getMaxStack() == this.quantity) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true; //TODO - kig på returnering
            }
        } else {
            return true;
        }
    }

    public void consume() {
        if (isEmpty()) {
            //TODO - exception
        } else {
            this.quantity -= 1;
        }
    }
    /*
    consume()
    1. tjek isEmpty -- hvis true så exception (kan ikke consume, hvis ikke der er noget)
    2. reducér quantity med 1
     */

    public void clearSlot() {
        if (isEmpty()) {
            //TODO - exception
        } else {
            this.quantity = 0;
        }
    }
    /*
    clearSlot()
    1. tjek isEmpty -- hvis true så exception
    2. set quantity = 0
     */

}
