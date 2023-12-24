package Threads;


class Counter{


    private int v;

    public Counter(int v){
        this.v = v;
    }

    public void setter(){
        v= v+1;
    }

    public int getV(){
        return v;
    }

}

public class ThreadsExample {
    public static void main(String[] args){

        Counter c =new Counter(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                synchronized (c){
                    while(c.getV()<=10){
                        System.out.println("called by "+Thread.currentThread().getName()+" with the value as "+c.getV());
                        c.setter();
                    }

                }


            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                synchronized (c){
                    while(c.getV()<=10){
                        System.out.println("called by "+Thread.currentThread().getName()+" with the value as "+c.getV());
                        c.setter();
                    }

                }
            }
        }).start();





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
