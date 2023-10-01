package Streams.FlatMap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapOfExample {
    public static void main(String [] args){
        // •	Given a list of lists, flatten it into a single list using flatMap.
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 2);
        l.add(new ArrayList<>(numbers));
        l.add(new ArrayList<>(numbers1));

        System.out.println(l.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        // or

        System.out.println(l.stream().flatMap(list -> list.stream()).collect(Collectors.toList()));

    }
}
