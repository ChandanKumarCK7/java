package Streams.FilterAndTheMapping;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


// sample pojo
class Person{
    String gender;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String gender, String name){
        this.gender = gender;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
public class FilterAndMappingExample {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2);
        List<String> strings = Arrays.asList("alph", "beta", "uuuuuu", "sooooooo","so");



        // Given a list of integers, filter out the even numbers and return them as a new list.
        System.out.println("q1 "+numbers.stream().filter(n -> n %2 == 0). collect(Collectors.toList()));

        // Given a list of strings, filter out the strings that have a length greater than a specified value.
//        System.out.println(strings.stream().filter(s -> s.length() > 5).collect(Collectors.toList()));

        // Given a list of Person objects (with attributes like name, age, and gender),
        // filter out all the male persons, and then map their names to a new list of strings.

        Person p_ = new Person("male","alpha");
        Person p1 = new Person("female", "alpha1");

        List<Person> persons = new ArrayList<>();
        persons.add(p_);
        persons.add(p1);
        System.out.println("q2 "+persons.toString());

        System.out.println(persons.stream().filter(p -> p.gender.equalsIgnoreCase("male"))
                .map(Person::getName).collect(Collectors.toList()));

        // Given a list of integers with duplicate values,
        // filter out the unique values (remove duplicates) and return them as a new list.

        System.out.println(numbers.stream().collect(Collectors.toSet()));

        // or

        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));

        // Given a list of strings, map each string to its length and return a list of integers representing the lengths.

        HashMap<String, Integer> h = new HashMap<>();
        strings.stream().forEach(s -> h.put(s, s.length()));

        System.out.println(h);

        // or

        System.out.println(strings.stream().collect(Collectors.toMap(s -> s, s -> s.length())));

        // or
        Function<String, String> f = new Function<String, String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };
        Function<String, Integer> f1 = new Function<String, Integer>(){
            @Override
            public Integer apply(String o) {
                return o.length();
            }
        };
        System.out.println(strings.stream().collect(Collectors.toMap(f, f1)));





    }
}
