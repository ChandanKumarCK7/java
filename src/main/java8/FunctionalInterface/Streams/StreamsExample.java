package FunctionalInterface.Streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class StreamsExample {
    public static void main(String[] args){
        // streams program to just find maximum element in list

        List<Integer> l = Arrays.asList(1,2,8,9,5,0,7);
        Comparator<Integer> co = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(l.stream().max(co).get());
    }







}
