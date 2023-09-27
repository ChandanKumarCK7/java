package FunctionalInterface.Consumer;


import java.util.HashMap;
import java.util.function.BiConsumer;

class BiConsu implements BiConsumer<Integer, Integer>{
    @Override
    public void accept(Integer a, Integer b){
        System.out.println(a+b);
    }


}
public class BiConsumerExampleWithoutLambda {

    public static void main(String[] args){
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(1, 1);
        h.put(5, 5);

        BiConsumer c = new BiConsu();
        h.forEach(c);
    }





}
