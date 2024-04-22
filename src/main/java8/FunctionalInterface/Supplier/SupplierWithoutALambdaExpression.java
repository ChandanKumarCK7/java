package FunctionalInterface.Supplier;






import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.Supplier;

class SupplierHelper implements Supplier<Integer>{
    private final Random random = new Random();

    public Integer get(){
        return random.nextInt(10000);
    }
}

public class SupplierWithoutALambdaExpression {

    public static void main(String[] args){
        Supplier<Integer> supplier = new SupplierHelper();
        int v = supplier.get();



        System.out.println(v);


    }




}
