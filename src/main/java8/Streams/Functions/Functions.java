package Streams.Functions;


import java.util.Arrays;
import java.util.List;

public class Functions  {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2);
        List<String> strings = Arrays.asList("alph", "beta", "uuuuuu", "sooooooo","so");

        numbers.stream().peek(n -> System.out.println("processing")).forEach(e -> System.out.println(e));
    }
}
