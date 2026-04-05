package DefaultMethods;




interface InterfaceA {
    default void printMessage() {
        System.out.println("Hello from Interface A");
    }
}

interface InterfaceB {
    default void printMessage() {
        System.out.println("Hello from Interface B");
    }
}

class MyClass implements InterfaceA, InterfaceB {
    // This class will not compile without overriding printMessage()
    @Override
    public void printMessage() {
        // You must provide your own implementation.
        System.out.println("Hello from MyClass");

        //  OR Below line will execute from InterfaceA if uncommented.
        // InterfaceA.super.printMessage();
    }
}


public class DiamondProblem {
    public static void main(String[] args){
        InterfaceA obj = new MyClass();
        obj.printMessage();

    }
}
