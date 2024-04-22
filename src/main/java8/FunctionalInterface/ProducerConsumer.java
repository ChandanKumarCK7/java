package FunctionalInterface;




import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;




class SharedBuffer{
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 5;


    public synchronized void produce(int i) throws InterruptedException{
        while(buffer.size() == capacity){
            wait();
        }

        buffer.offer(i);
        System.out.println("added "+i+" by "+Thread.currentThread().getName());
        if (buffer.size() >= capacity)
            notify();
    }

    public synchronized void consume() throws InterruptedException{
        while(buffer.size() == 0){
            wait();
            System.out.println(Thread.currentThread().getState());
        }

        int i = buffer.poll();
        System.out.println("consumed "+i+" by "+Thread.currentThread().getName());
//        if(buffer.size() >= 0)
//            notify();
    }
}

class Producer extends Thread{
    private SharedBuffer buffer;
    Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }


    @Override
    public void run(){
        for(int i =0; i < 17; i++){
            try {
                buffer.produce(i);
                Thread.sleep(100); // Simulate some production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

class Consumer extends Thread{
    private SharedBuffer buffer;
    Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i <17;  i++) {
            try {
                buffer.consume();
                Thread.sleep(100); // Simulate some production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer implements Serializable {

    public static void main(String[] args){
        SharedBuffer buffer = new SharedBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
