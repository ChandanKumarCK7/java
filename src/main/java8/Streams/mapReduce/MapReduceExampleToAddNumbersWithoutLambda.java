package Streams.mapReduce;



import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

class FunctionImpl implements Function<Integer, Integer>{
    public Integer apply(Integer i){
        return i*2;
    }
}
public class MapReduceExampleToAddNumbersWithoutLambda {
    public static void main(String[] args){
        List<Integer> a = Arrays.asList(1,2,8,6,0,7,8);




        Function<Integer, Integer> f = new FunctionImpl();

        // below is the program to create anonymous class to implement apply method.
        BinaryOperator<Integer> b = new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer i, Integer j) {
                return i + j;
            }
        };

        System.out.println(a.stream().map(f).reduce(0, b));

        // below is the program to find first non repetitive character using streams
        String s = "chandan";
        Map<Character, Integer> l = new LinkedHashMap<>();
        for(Character c : s.toCharArray()){
            l.put(c, l.getOrDefault(c,1));
        }
        System.out.println(l.entrySet().stream().filter(l1 -> l1.getValue() == 1).findAny().get().getKey());


        //

        // Given a list of integers, find the square of each even number and return them as a list.

        List<Integer> l1 = Arrays.asList(1,2,8,6,5,0,7);
        System.out.println(l1.stream().filter(l8 -> l8 %2 == 0).map(l8 -> l8 * 2).collect(Collectors.toList()));


        // Given a list of strings, filter out strings that start with a specific prefix.

        List<String> l2 = Arrays.asList("alph", "beta", "uuuuuu", "sooooooo","so", "so");
        System.out.println(l2.stream().filter(l9 -> l9.startsWith("so")).collect(Collectors.toList()));








        // Calculate the sum, product, or average of a list of numbers using reduce. program



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().reduce(0, (a1, b1) -> a1+b1));

        // calculate average


        System.out.println(numbers.stream().reduce(0, (a1, b1) -> a1+b1)/numbers.size());
        System.out.println(numbers.stream().mapToDouble(a1 -> a1.doubleValue()).average());

        // Find the maximum and minimum values in a list using reduce.

        System.out.println(numbers.stream().reduce(Integer.MAX_VALUE, (a1, b1) ->  a1 > b1  ? b1 : a1));

        System.out.println(numbers.stream().reduce(Integer.MIN_VALUE, (a1, b1) -> a1 < b1 ? b1 : a1));


        // Given a list of integers, use Java Streams to calculate the sum of the squares of all even numbers in the list.

        System.out.println(numbers.stream().filter(n -> n%2 == 0).map(n->n*n).reduce(0, (prevS, su) -> prevS + su));

        // or

        System.out.println(numbers.stream().filter(n -> n%2 == 0).map(n->n*n).reduce(0, Integer::sum));

        // Find the most or maximum length of a string from an arraylist

        System.out.println(l2.stream().collect(Collectors.toSet()).
                stream().collect(Collectors.toMap(st -> st, st ->st.length())).entrySet()
                .stream().max(((Entry1, Entry2) -> Entry1.getValue().compareTo(Entry2.getValue()))));

        // most common word of a list
        System.out.println(l2.stream().collect(Collectors.groupingBy(s1 -> s1, Collectors.counting())).entrySet()
                .stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).map(o1 -> o1.getKey()));




    }

}
