package FunctionalInterface.Predicate;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Predicate;

class PredicateSub implements Predicate<String>{
    public boolean test(String s){
        return s.startsWith("u");
    }
}

class PredicateInt implements Predicate<Integer>{
    public boolean test(Integer i){
        return (i % 2) == 0;
    }
}



public class PredicateWithoutALambdaExpression {

    public static void main(String[] args){
        List<String> l = new ArrayList<>(Arrays.asList("alpha", "utyr"));
        ArrayList<String> copyL = new ArrayList<>(l);

        Predicate<String> p = new PredicateSub();
        l.removeIf(p);

        System.out.println("Filtered list: " + l+" normal list "+copyL);

        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,8,7));
        ArrayList<Integer> copyL1 = new ArrayList<>(l1);

        Predicate<Integer> p1 = new PredicateInt();

        l1.removeIf(p1);
        System.out.println("Filtered list: " + l1 + " normal list "+copyL1);



    }
}
