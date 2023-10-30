package Streams.Others.GroupingBy;






import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    public String name;
    public String gender;

    Person(String name, String gender){
        this.name = name;
        this.gender = gender;
    }
}
public class GroupingBy {



    public static void main(String[] args){
        List<Person> p = new ArrayList<>();
        p.add(new Person("alpha", "male"));
        p.add(new Person("sigma", "female"));

        System.out.println(p.stream().collect(Collectors.groupingBy(person -> person.gender)));

    }
}
