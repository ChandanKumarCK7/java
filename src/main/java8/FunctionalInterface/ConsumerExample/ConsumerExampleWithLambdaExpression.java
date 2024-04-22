package FunctionalInterface.ConsumerExample;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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

            LinkedHashSet<Integer> li = new LinkedHashSet<>();
            li.add(8);
            li.add(8);
            System.out.println(li);

        }

}
