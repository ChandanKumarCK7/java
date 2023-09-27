package FunctionalInterface.Function;


import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;



public class FunctionExampleWithLambda {
    public static void main(String[] args){
        List<String> l = new ArrayList<>(Arrays.asList("alpha", "utyr"));
        ArrayList<String> copyL = new ArrayList<>(l);

        Function<String, String> f = (String s) -> s.toUpperCase();
        l= l.stream().map(f).collect(Collectors.toList());

        System.out.println("Filtered list: " + l+" normal list "+copyL);


        // program to sort elements in list based on length of string
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        list.add("Date");
        ArrayList<String> copyLi = new ArrayList<>(list);
        Function<String,Integer> f1 = (String s) -> s.length();
        list = list.stream().sorted(Comparator.comparing(f1)).collect(Collectors.toList());

        System.out.println("Filtered list: " + list+" normal list "+copyLi);

    }


}
