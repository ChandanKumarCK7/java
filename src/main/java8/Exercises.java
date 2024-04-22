import java.util.Comparator;






class Student implements Cloneable{
    String name;

    public Student(String name) {
        this.name = name;
    }

    public void sampleapi(){
        System.out.println("sampleapi");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class Exercises{
    public static void main(String[] args) throws CloneNotSupportedException {

        Student s1 = new Student("here");
        Student s2 = s1;      // Shallow Copy

//        Student s2 = (Student) s1.clone();        // Deep Copy

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        s1.name ="nnnnnn";

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println();



    }

}
