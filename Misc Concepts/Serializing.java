import java.io.*;

// Implementation of Marker interface like Serializable.
// Serializable interface is basically used to save the object or any other instance into any file in local disk.

// Step 1: Make class serializable
class Student implements Serializable {
    int id;
    String name;
}

public class Serializing {
    public static void main(String[] args) {
        // Step 2: Create object and assign values
        Student s = new Student();
        s.id = 101;
        s.name = "Jhon";

        // Step 3: Serialize and write to file
        try {
            FileOutputStream fos = new FileOutputStream("student.ser"); // file will be saved in project root
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s); // write object to file
            oos.close();
            fos.close();
            System.out.println("Object successfully saved to disk.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
