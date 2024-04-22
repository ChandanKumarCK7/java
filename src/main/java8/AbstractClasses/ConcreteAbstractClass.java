package AbstractClasses;



// Concrete Abstract class is a class that has no abstract methods, though constructor cant be directly called through instantiation




abstract class ConcreteAbstractClassBase {
    private String name;

    public ConcreteAbstractClassBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doSomething() {
        System.out.println("Doing something in the abstract class.");
    }
}



class ConcreteSubclass extends ConcreteAbstractClassBase {
    public ConcreteSubclass(String name) {
        super(name);
    }

    public void doSomething() {
        System.out.println("Doing something in the below sub class.");
    }
    // This subclass can provide additional methods or override existing ones
}








public class ConcreteAbstractClass {
    public static void main(String[] args) {


        ConcreteSubclass instance = new ConcreteSubclass("Example");
        System.out.println(instance.getName());      // Accessing the inherited method
        instance.doSomething();                      // Calling the inherited method
    }
}
