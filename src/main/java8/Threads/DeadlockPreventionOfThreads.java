package Threads;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadlockPreventionOfThreads {

    Queue<Integer> queue;
    int counter;

    int MAX_CAPACITY;

    Lock lock1 = new ReentrantLock();

    Condition notFull = lock1.newCondition();
    Condition notEmpty = lock1.newCondition();

    public DeadlockPreventionOfThreads(Queue<Integer> queue, int counter, int MAX_CAPACITY) {
        this.queue = queue;
        this.counter = counter;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }


}

class Producer1  implements Runnable {

    DeadlockPreventionOfThreads deadlockThreads;
    String name;

    public Producer1(DeadlockPreventionOfThreads deadlockThreads, String name) {
        this.deadlockThreads = deadlockThreads;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){

            deadlockThreads.lock1.lock();
            System.out.println("LOCK acquired by PRODUCER "+this.name);
            try {
                while (deadlockThreads.getQueue().size() >= deadlockThreads.MAX_CAPACITY){
                    deadlockThreads.notEmpty.await();
                }
                deadlockThreads.getQueue().add(deadlockThreads.counter++);
                System.out.println("produced "+ deadlockThreads.counter+" by "+this.name+" STATE -  " +Thread.currentThread().getState());
                deadlockThreads.notFull.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                deadlockThreads.lock1.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }
}

class Consumer1 implements Runnable {

    DeadlockPreventionOfThreads deadlockThreads;
    String name;

    public Consumer1(DeadlockPreventionOfThreads deadlockThreads, String name) {
        this.deadlockThreads = deadlockThreads;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){

            deadlockThreads.lock1.lock();
            System.out.println("LOCK acquired by CONSUMER "+this.name);
            try {
                while(deadlockThreads.getQueue().size() == 0){
                    deadlockThreads.notFull.await();
                }
                int v = deadlockThreads.getQueue().poll();
                System.out.println("consumed "+ v+" by "+this.name+" STATE -  " +Thread.currentThread().getState());
                deadlockThreads.notEmpty.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                deadlockThreads.lock1.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class DeadlockMain1{
    public static void main(String[] args){

        DeadlockPreventionOfThreads deadlockThreads = new DeadlockPreventionOfThreads(new LinkedList<>(), 0, 1);

        Thread producer = new Thread(new Producer1(deadlockThreads, "ProducerA"));
        Thread consumer = new Thread(new Consumer1(deadlockThreads, "ConsumerA"));

        Thread producer1 = new Thread(new Producer1(deadlockThreads, "ProducerB"));

        producer.start();
        producer1.start();
        consumer.start();

        System.out.println(deadlockThreads.getQueue());

    }
}