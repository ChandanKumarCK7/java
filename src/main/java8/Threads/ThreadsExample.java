package Threads;


class Counter{

    private int v;
    private static Counter counter;

    public Counter(int v){
        this.v = v;
    }

    public synchronized void setter(){
        v= v+1;
    }

    public synchronized int getV(){
        return v;
    }

    public static Counter getInstance(){
        if (counter == null){
            counter = new Counter(0);
            return counter;
        }
        return counter;
    }
}

class RunnableImpl implements Runnable{
    Counter c = Counter.getInstance();

    public void run() {
        int i =0;
            while(c.getV()<=10){
                System.out.println("called by "+Thread.currentThread().getName()+" with the value as "+c.getV());
                c.setter();
            }

    }
}
public class ThreadsExample {
    public static void main(String[] args){



        new Thread(new RunnableImpl()).start();
        new Thread(new RunnableImpl()).start();





    }
}







//
//class Threads.Threads.Counter {
//    private int v;
//
//    public Threads.Threads.Counter(int v) {
//        this.v = v;
//    }
//
//    public synchronized void increment() {
//        v = v + 1;
//    }
//
//    public synchronized int getV() {
//        return v;
//    }
//}
//
//public class Threads.Threads.ThreadsExample {
//    public static void main(String[] args) {
//        Threads.Threads.Counter c = new Threads.Threads.Counter(0);
//
//        new Thread(() -> {
//            while (c.getV() <= 10) {
//                System.out.println("called by " + Thread.currentThread().getName() + " with the value as " + c.getV());
//                c.increment();
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (c.getV() <= 10) {
//                System.out.println("called by " + Thread.currentThread().getName() + " with the value as " + c.getV());
//                c.increment();
//            }
//        }).start();
//    }
//}
