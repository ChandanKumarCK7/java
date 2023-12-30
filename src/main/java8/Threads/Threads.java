package Threads;


public class Threads {




    public static void main(String[] args) {
        // Create a new thread and start it



//        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new Thread(new Thread1Task());
        thread1.start();

        // Thread2 finishes execution and thread1 continues execution
        System.out.println("Thread1 State: " + thread1.getState());

        // Thread2 finishes execution and thread1 continues execution
        System.out.println("Thread1 State: " + thread1.getState());

        // Exit the program
        System.exit(0);
    }


    static class Thread1Task implements Runnable {
        @Override
        public void run() {
            // Create a new thread and start it
            Thread thread2 = new Thread(new Thread2Task());
            thread2.start();

            // Wait for thread2 to complete before continuing

            // Thread2 finishes execution and thread1 continues execution
            System.out.println("Thread2 State: " + thread2.getState());

            // Thread2 finishes execution and thread1 continues execution
            System.out.println("Thread2  State: " + thread2.getState());
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread1 is in waiting state until thread2 finishes execution
        }
    }

    static class Thread2Task implements Runnable {
        @Override
        public void run() {
            try {
                // Sleep for 2 seconds to simulate some work being done
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
