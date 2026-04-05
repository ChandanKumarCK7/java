import java.util.Objects;
import java.util.*;

// final class makes sure no inheritance, if no inheritance no overriding and getting values in different way
final class Employee{
    // final fields so that once initialized, they cant be set again through object
    final private int id;
    final private String name;
    // private fields so that Collection or Custom class variables cant be modified like - employee.languages.add("english");
    final private List<String> languages;

    public Employee(int id, String name, List<String> languages) {
        this.id = id;
        this.name = name;
        this.languages = List.copyOf(languages);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(languages, employee.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, languages);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", languages=" + languages +
                '}';
    }

    //    Age age;
}
//class Age{
//    int age;
//}
public class ImmutableClasses {
    public static void main(String[] args){

        Employee employee = new Employee(5, "alpha", new ArrayList<String>(Arrays.asList("hindi")));

        // below will fail
//        // final will help here
//        employee.id = 6;
//
//        // private will help here
//        employee.languages.add("english");
//
//        // List.copyOf will help here
//        employee.getLanguages().add("english");
//
//        System.out.println(employee.toString());



    }
}
