package mapReduce;



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

        List<String> l2 = Arrays.asList("alph", "beta", "uuuuuu", "sooooooo","so");
        System.out.println(l2.stream().filter(l9 -> l9.startsWith("so")).collect(Collectors.toList()));

    }

}
