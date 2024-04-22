package FunctionalInterface;


public class MultiThreadingExercises {





    static int v =0;
    public static void main(String[] args){
        Thread t1 = new Thread(() ->{                 // without lambda or functional interfaces
            for(int i =0; i < 5; i++){
                System.out.println(Thread.currentThread()+" "+v++);
            }
        }
      );
        Thread t8 = new Thread(() -> func());           // lambda expression to pass argument using functional interface



        try{
            t1.start();
            t1.join();
            t8.start();
            t8.join();
        }catch(Exception e){

        }


    }

    public static void func(){
        for(int i =0; i < 5; i++){
            System.out.println(Thread.currentThread()+" "+ v++);
        }
    }
}
