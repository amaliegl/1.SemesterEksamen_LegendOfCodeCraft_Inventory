package items;

import inventory.Inventory;
import inventory.InventorySlot;

import java.io.*;

public class SerializationClass {

    //serialize
    public void serializeInventory(String fileName, Inventory inventory) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(inventory);
        out.close();
        fileOutputStream.close();
        System.out.println("Serialization complete");
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


/*import java.io.*;

// Example class that must implement Serializable
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class SerializeArrayExample {

    // Serialize an object array to byte[]
    public static byte[] serializeObjectArray(Object[] objects) throws IOException {
        if (objects == null) {
            throw new IllegalArgumentException("Object array cannot be null");
        }
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(objects);
            return bos.toByteArray();
        }
    }

    // Deserialize byte[] back to Object[]
    public static Object[] deserializeObjectArray(byte[] data) throws IOException, ClassNotFoundException {
        if (data == null) {
            throw new IllegalArgumentException("Byte array cannot be null");
        }
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (Object[]) ois.readObject();
        }
    }

    public static void main(String[] args) {
        try {
            // Create an array of serializable objects
            Person[] people = {
                    new Person("Alice", 30),
                    new Person("Bob", 25)
            };

            // Serialize to byte[]
            byte[] serializedData = serializeObjectArray(people);
            System.out.println("Serialized byte array length: " + serializedData.length);

            // Deserialize back to object array
            Object[] deserializedObjects = deserializeObjectArray(serializedData);

            // Print deserialized objects
            for (Object obj : deserializedObjects) {
                System.out.println(obj);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}*/
