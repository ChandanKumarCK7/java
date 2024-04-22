package FunctionalInterface.ConsumerExample;


import java.util.Comparator;
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

        Comparator c1 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }

}
