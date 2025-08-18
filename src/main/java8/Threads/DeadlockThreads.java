package Threads;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockThreads {

    Queue<Integer> queue;
    int counter;

    int MAX_CAPACITY;

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public DeadlockThreads(Queue<Integer> queue, int counter, int MAX_CAPACITY) {
        this.queue = queue;
        this.counter = counter;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }


}

class Producer  implements Runnable {

    DeadlockThreads deadlockThreads;

    public Producer(DeadlockThreads deadlockThreads) {
        this.deadlockThreads = deadlockThreads;
    }

    @Override
    public void run() {
        System.out.println("trying to LOCK lock1 by PRODUCER");
        deadlockThreads.lock1.lock();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("trying to LOCK lock2 by PRODUCER");
        deadlockThreads.lock2.lock();
        while(deadlockThreads.getQueue().size() < deadlockThreads.MAX_CAPACITY)
            deadlockThreads.getQueue().add(deadlockThreads.counter++);
        System.out.println("trying to UNLOCK lock2 by PRODUCER");
        deadlockThreads.lock2.unlock();
        System.out.println("trying to UNLOCK lock1 by PRODUCER");
        deadlockThreads.lock1.unlock();
    }
}

class Consumer implements Runnable {

    DeadlockThreads deadlockThreads;

    public Consumer(DeadlockThreads deadlockThreads) {
        this.deadlockThreads = deadlockThreads;
    }

    @Override
    public void run() {
        System.out.println("trying to LOCK lock2 by CONSUMER");
        deadlockThreads.lock2.lock();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("trying to LOCK lock1 by CONSUMER");
        deadlockThreads.lock1.lock();
        while(deadlockThreads.getQueue().size() > 0)
            deadlockThreads.getQueue().poll();
        System.out.println("trying to UNLOCK lock1 by CONSUMER");
        deadlockThreads.lock1.unlock();
        System.out.println("trying to UNLOCK lock2 by CONSUMER");
        deadlockThreads.lock2.unlock();
    }
}

class DeadlockMain{
    public static void main(String[] args){

        DeadlockThreads deadlockThreads = new DeadlockThreads(new LinkedList<>(), 0, 2);

        Thread producer = new Thread(new Producer(deadlockThreads));
        Thread consumer = new Thread(new Consumer(deadlockThreads));

        producer.start();
        consumer.start();

        System.out.println(deadlockThreads.getQueue());

    }
}