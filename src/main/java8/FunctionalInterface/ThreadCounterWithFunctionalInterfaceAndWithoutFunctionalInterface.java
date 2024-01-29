package FunctionalInterface;



class Pojo{
    int v;

    public Pojo(int v){
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public synchronized void setV(int v) {
        this.v = v;
    }
}

class RunnableImpl implements Runnable{
    Pojo p;
    public RunnableImpl(Pojo p) {
        this.p = p;
    }

    @Override
    public void run(){
        for(int i =0; i < 5; i++){
            p.setV(p.getV()+1);
            System.out.println(p.getV()+" "+Thread.currentThread().getName());
        }
    }
}
public class ThreadCounterWithFunctionalInterfaceAndWithoutFunctionalInterface {
    public static void main(String[] args) throws InterruptedException {
        // sample Example to create a thread with lambda and functional interface and implement counter

        Pojo p = new Pojo(0);
        Thread t1 = new Thread(() -> {
            for(int i =0; i < 5; i++){
                p.setV(p.getV()+1);
                System.out.println(p.getV()+" t1");
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i =0; i < 5; i++){
                p.setV(p.getV()+1);
                System.out.println(p.getV()+" t2");
            }
        });

        t1.start();
        t2.start();

        RunnableImpl r = new RunnableImpl(p);
        Thread t8 = new Thread(r, "t8");

        t8.start();

    }
}
