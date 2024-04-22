package AbstractClasses;




// if an interface will be implemented by abstract class then that abstract class need not provide implementation to
// all of the abstract methods though the concrete subclasses of abstract class have to provide








// Interface with abstract methods
interface MyInterface {
    void method1();
    void method2();
}

// Abstract class implementing the interface
abstract class MyAbstractClass implements MyInterface {
    // Abstract class can provide partial implementation
    // Concrete subclasses will need to provide concrete implementations for the remaining methods
    @Override
    public void method1() {
        System.out.println("Abstract class implementing method1.");
    }
}

// Concrete subclass extending the abstract class
class MyConcreteClass extends MyAbstractClass {
    // Concrete subclass provides implementation for the remaining abstract method
    @Override
    public void method2() {
        System.out.println("Concrete class implementing method2.");
    }
}





public class CanAbstractClassImplemenetInterface {
    public static void main(String[] args) {
        MyConcreteClass instance = new MyConcreteClass();
        instance.method1(); // Output: Abstract class implementing method1.
        instance.method2(); // Output: Concrete class implementing method2.
    }
}
