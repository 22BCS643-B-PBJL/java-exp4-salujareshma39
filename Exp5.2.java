/* Medium Level:
Create a Java program to serialize and deserialize a Student object. The program should:
Serialize a Student object (containing id, name, and GPA) and save it to a file.
Deserialize the object from the file and display the student details.
Handle FileNotFoundException, IOException, and ClassNotFoundException using exception handling. combine the code of it
*/
import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("Student Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentSerializationApp {

    private static final String FILE_NAME = "student_data.ser";

    public static void main(String[] args) {

        Student student = new Student(101, "Alice Johnson", 3.9);

        serializeStudent(student);

        Student deserializedStudent = deserializeStudent();

        if (deserializedStudent != null) {
            deserializedStudent.display();
        } else {
            System.out.println("Failed to read student data.");
        }
    }

    private static void serializeStudent(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(student);
            System.out.println("Student object serialized successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found during serialization: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException during serialization: " + e.getMessage());
        }
    }

    private static Student deserializeStudent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found during deserialization: " + e.getMessage());
        }
        return null;
    }
}
