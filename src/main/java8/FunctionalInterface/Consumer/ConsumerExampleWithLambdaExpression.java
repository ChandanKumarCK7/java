package FunctionalInterface.Consumer;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExampleWithLambdaExpression {


        public static void main(String[] args){
            List<Integer> l = Arrays.asList(1,2,8,7);

            Consumer<Integer> c = new Consumer<>(){
                public void accept(Integer i){
                    System.out.println(i);
                }
            };

            l.forEach(c);

            // type2
            Consumer<Integer> c1 = (i) -> {
                System.out.println(i);
            };

            l.forEach(c1);

        }

}
