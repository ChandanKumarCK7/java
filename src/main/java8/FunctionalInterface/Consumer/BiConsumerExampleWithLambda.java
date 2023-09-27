package FunctionalInterface.Consumer;


import java.util.HashMap;
import java.util.function.BiConsumer;

public class BiConsumerExampleWithLambda {
    public static void main(String[] args){
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(1, 1);
        h.put(5, 5);
        BiConsumer<Integer, Integer> c = (a, b) -> {
            System.out.println(a+b);
        };
        h.forEach(c);
    }

}
