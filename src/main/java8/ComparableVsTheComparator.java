






import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





import java.util.Comparator;

class Person1 implements Comparable<Person1> , Comparator<Person1> {
    private String name;
    private int age;

    public Person1(){

    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters, setters, and other methods...


    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person1 other) {
        // Compare based on name
        return this.name.compareTo(other.name);
    }

    @Override
    public int compare(Person1 person1, Person1 person2) {
        // Compare based on age
        return Integer.compare(person1.age, person2.age);
    }
}



public class ComparableVsTheComparator {







        public static void main(String[] args) {
            List<Person1> people = new ArrayList<>();



            people.add(new Person1("Bob", 30));
            people.add(new Person1("Alice", 25));

            people.add(new Person1("Charlie", 22));

            // Using Comparable (natural ordering based on name)
            Collections.sort(people);
            System.out.println("Sorted by name: " + people);

            // Using Comparator (ordering based on age)

//            Collections.sort(people, new Person1());
//            System.out.println("Sorted by age: " + people);



            // or

            Comparator<Person1> ageComparator = new Person1();
            Collections.sort(people, ageComparator);
            System.out.println("Sorted by age: " + people);




        }

}
