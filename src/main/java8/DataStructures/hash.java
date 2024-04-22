package DataStructures;






class MyClass {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value; // Using value as the hash code (oversimplified for illustration)
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyClass other = (MyClass) obj;
        return value == other.value;
    }
}

public class hash {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass(5);
        MyClass obj2 = new MyClass(5);

        System.out.println(obj1.hashCode()); // Same value, different hash codes
        System.out.println(obj2.hashCode());

        System.out.println(obj1.equals(obj2)); // true (same values)
    }
}
