package FunctionalInterface.ConsumerExample;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsumerImpl implements Consumer<Integer> {
    public void accept(Integer i){
        System.out.println(i);
    }
}


public class ConsumerExample{
    public static void main(String[] args){
        List<Integer> l = Arrays.asList(1,2,8,7);

        Consumer<Integer> c = new ConsumerImpl();
        l.forEach(c);
    }
}