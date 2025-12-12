package items;

import inventory.InventorySlot;

import java.io.*;

public class SerializationClass {

    //serialize
    public static void serializeObjectArray(InventorySlot[] slots) throws IOException {
        if (slots == null) {
            throw new IllegalArgumentException("Object array cannot be null");
        }
        //try-with-ressources so not necessary to use .close()
        try (FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
             out.writeObject(slots);
             out.close();
             fileOutputStream.close();
            System.out.println("Serialized data is saved"); //TODO - skal fjernes, hvis virker
        } catch (IOException e) {
            System.out.println("Exception reached!!!");
        }
    }

    //deserialize
    public static void deserializeObjectArray(String fileName) throws IOException, ClassNotFoundException {
        if ((fileName + ".txt") == null) {
            throw new IllegalArgumentException("Byte array cannot be null");
        }
        try (FileInputStream fileInputStream = new FileInputStream(fileName + ".txt");
             ObjectInputStream in = new ObjectInputStream(fileInputStream)) {
            System.out.println("Deserialization completed");
        }
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
