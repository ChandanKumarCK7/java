import java.util.ArrayList;
import java.util.List;

class Person_212 implements Cloneable {
    String name;
    List<String> hobbies;

    public Person_212(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person_212 deepCopy = (Person_212) super.clone();
        deepCopy.hobbies = new ArrayList<>(this.hobbies); // create new list
        return deepCopy;
    }
}

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> hobbies = new ArrayList<>(List.of("Reading", "Gaming"));
        Person_212 original = new Person_212("Alice", hobbies);

        Person_212 deepCopy = (Person_212) original.clone();

        System.out.println(original == deepCopy);

        // Modifying nested object does NOT affect original
        deepCopy.hobbies.add("Cooking");

        System.out.println(original.hobbies);  // [Reading, Gaming] ← unchanged
        System.out.println(deepCopy.hobbies);  // [Reading, Gaming, Cooking]

    }
}