package FunctionalInterface;



class Pojo{
    int v;

    public Pojo(int v){
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
public class ThreadCounterWithFunctionalInterface {
    public static void main(String[] args){
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

    }
}
