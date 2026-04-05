package Streams;


import java.util.HashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args){

        // sort map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"zero");
        map.put(1, "one");

        TreeMap<Integer, String > treeMap = map.
                entrySet()
                .stream()
                .collect(Collectors.toMap(e-> e.getKey(), e->e.getValue(), (v1, v2) -> v1, TreeMap::new));
        System.out.println(treeMap);

    }
}
