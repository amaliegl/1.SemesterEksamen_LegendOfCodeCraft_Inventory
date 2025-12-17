package items;

import inventory.Inventory;

import java.io.*;

public class SerializationClass {

    //serialize
    public void serializeInventory(String fileName, Inventory inventory) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(inventory);
        out.close();
        fileOutputStream.close();
    }

    //deserialize
    public Inventory deserializeInventory(String fileName) throws IOException, ClassNotFoundException {
        Inventory tempInventory = null;

        FileInputStream fileInputStream = new FileInputStream(fileName + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        tempInventory = (Inventory) in.readObject();
        in.close();
        fileInputStream.close();
        return tempInventory;
    }
}
