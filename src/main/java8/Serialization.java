import java.io.*;








class StudentSerialization implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name;
    private transient int age;

    // Constructors, getters, setters, etc.

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Serialization {
    public static void main(String[] args) {
        // Serialization
        serializeObject();

        // Deserialization
        StudentSerialization deserializedStudent = deserializeObject();
        System.out.println("Deserialized Student: " + deserializedStudent);
    }

    private static void serializeObject() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            // Creating a new Student object
            StudentSerialization student = new StudentSerialization();
            student.setName("John Doe");
            student.setAge(20);

            // Serializing the object to a file
            outputStream.writeObject(student);

            System.out.println("Serialization completed. Object saved to student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StudentSerialization deserializeObject() {
        StudentSerialization student = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.ser"))) {
            // Deserializing the object from the file
            student = (StudentSerialization) inputStream.readObject();

            System.out.println("Deserialization completed.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }
}
