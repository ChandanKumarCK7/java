import java.util.ArrayList;
import java.util.List;

class Person implements Cloneable {
    String name;
    List<String> hobbies;

    Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    // Shallow copy using clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // copies field values as-is
    }
}

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> hobbies = new ArrayList<>(List.of("Reading", "Gaming"));
        Person original = new Person("Alice", hobbies);

        Person shallowCopy = (Person) original.clone();
        System.out.println(original == shallowCopy);

        // Modifying nested object affects BOTH
        shallowCopy.hobbies.add("Cooking");

        System.out.println(original.hobbies);   // [Reading, Gaming, Cooking] ← affected!
        System.out.println(shallowCopy.hobbies); // [Reading, Gaming, Cooking]
    }
}