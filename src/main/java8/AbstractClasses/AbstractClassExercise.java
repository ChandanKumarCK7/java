package AbstractClasses;


class CustomRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started");
    }
}

abstract class Parent extends CustomRunnable {

    public Parent(){
        System.out.println("parent instantiated");

    }


    abstract void doSomething();
}

class Child extends Parent{

    public Child(){
        System.out.println("child instantiated");
    }

    public void doSomething(){
        System.out.println("here");
    }
}
public class AbstractClassExercise {
    public static void main(String[] args){

        Parent parent = new Child();

        Thread t = new Thread(parent);
        t.start();
        parent.doSomething();

    }
}
