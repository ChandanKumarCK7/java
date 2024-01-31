package Threads;




// Implementation of ReadWriteLock in Java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
class Locks<O> {

    private final ReadWriteLock readWriteLock
            = new ReentrantReadWriteLock();
    private final Lock writeLock
            = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();
    private final List<O> list = new ArrayList<>();

    // setElement function sets
    // i.e., write the element to the thread
    public void setElement(O o)
    {
        // acquire the thread for writing
        writeLock.lock();
        try {
            list.add(o);
            System.out.println(
                    "Element by thread "
                            + Thread.currentThread().getName()
                            + " is added");
        }
        finally {
            // To unlock the acquired write thread
            writeLock.unlock();
        }
    }

    // getElement function prints
    // i.e., read the element from the thread
    public O getElement(int i)
    {
        // acquire the thread for reading
        readLock.lock();
        try {
            System.out.println(
                    "Elements by thread "
                            + Thread.currentThread().getName()
                            + " is printed");
            return list.get(i);
        }
        finally {
            // To unlock the acquired read thread
            readLock.unlock();
        }
    }
    public static void main(String[] args)
    {
        Locks<String> gfg = new Locks<>();

        new Thread(() ->{
            gfg.setElement("Hi");
            gfg.setElement("Hey");
            gfg.setElement("Hello");
            System.out.println("Printing the last element : "
                    + gfg.getElement(2));

        }).start();

        new Thread(new Runnable(){
            public void run(){
                System.out.println("Printing the last element : "
                        + gfg.getElement(2));
            }
        }).start();

    }
}
