package Threads;







import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Counter1 {
    private int v;

    public Counter1(int v) {
        this.v = v;
    }

    public void setter() {
        v = v + 1;
    }

    public synchronized int getV() {
        return v;
    }
}

class CallableHelper implements Callable<String> {
    Counter1 c = new Counter1(0);

    public int getV() {
        return c.getV();
    }

    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        while (c.getV() < 99) {
            System.out.println("Current Thread " + Thread.currentThread().getName() + " " + c.getV());
            c.setter();
            if (Thread.currentThread().getName().equalsIgnoreCase("pool-1-thread-1")) {
                Thread.sleep(5);
            }

            if (Thread.currentThread().getName().equalsIgnoreCase("pool-1-thread-2")) {
                Thread.sleep(25);
            }

        }
        long e = System.currentTimeMillis();
        return ("Completed the particular operation from " + Thread.currentThread().getName() + " in " + (e - start) + " milliseconds");
    }
}

public class MyCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableHelper c = new CallableHelper();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<String>> listFuture = new ArrayList<>();
        int numberOfThreads = 2;
        for (int i = 0; i < numberOfThreads; i++) {
            Future<String> future = executorService.submit(c);
            listFuture.add(future);
        }

        for (int i = 0; i < listFuture.size(); i++) {
            System.out.println(listFuture.get(i).get().toString());
        }

        System.out.println(c.getV());
        executorService.shutdown();
    }
}
