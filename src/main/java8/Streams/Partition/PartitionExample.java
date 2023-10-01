package Streams.Partition;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PartitionExample {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,8,6,5,0,7);
        List<Integer> numbers1 = Arrays.asList(1,2,8,6,5,0,7);

        // •	Partition a list of numbers into even and odd numbers using partitioningBy.
        System.out.println(numbers.stream().collect(Collectors.partitioningBy(n -> n%2 == 0)));

    }






}
