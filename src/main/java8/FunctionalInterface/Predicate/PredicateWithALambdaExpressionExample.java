package FunctionalInterface.Predicate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateWithALambdaExpressionExample {



    public static void main(String[] args){
        List<String> l = new ArrayList<>(Arrays.asList("alpha", "utyr"));
        ArrayList<String> copyL = new ArrayList<>(l);

        Predicate<String> p = (String s) -> s.startsWith("l");
        l.removeIf(p);

        System.out.println("Filtered list: " + l+" normal list "+copyL);

        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,8,7));
        ArrayList<Integer> copyL1 = new ArrayList<>(l1);

        Predicate<Integer> p1 = (Integer i) -> i%2 ==0;

        l1.removeIf(p1);
        System.out.println("Filtered list: " + l1 + " normal list "+copyL1);


    }
}
