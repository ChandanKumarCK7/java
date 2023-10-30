package Streams;






import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class ComparatorImpl implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
public class StringOperations {
    public static void main(String[] args){
        String s = "abujyvh";
        List<String> strings = Arrays.asList("alph", "beta", "uuuuuu", "sooooooo","so","listne", "level", "listen", "silent", "ooooooos");


        // palindrome list of strings
        System.out.println(strings.stream()
                .filter(st -> new StringBuilder(st).reverse().toString().equalsIgnoreCase(st.toString())).collect(Collectors.toSet()));

        // Group a list of words into sets of anagrams using Java Streams. Two words are considered anagrams if they have the same letters in a different order.
        System.out.println(strings.stream().collect(Collectors.groupingBy(st -> {
            char[] c = st.toCharArray();
            Arrays.sort(c);
            return new String(c);
        })).entrySet().stream().filter(e -> e.getValue().size() > 1).collect(Collectors.toSet()));

        // Generate all permutations of a given string and collect them into a list using Streams.


        // sort list of multiple strings with length
        Comparator co = new ComparatorImpl();
        System.out.println(strings.stream().sorted(co).collect(Collectors.toList()));
        System.out.println(strings.stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length())).collect(Collectors.toList()));


        // or

        System.out.println(strings.stream().sorted((o1, o2) -> o1.length() - o2.length()).collect(Collectors.toList()));

        // find the first non repetitive character using streams
        String st = "chandan";
        LinkedHashMap<Character, Integer> h = new LinkedHashMap<>();
        for(Character c : st.toCharArray()){
            h.put(c, h.getOrDefault(c, 1));
        }

        System.out.println(h.entrySet().stream().filter(h1 -> h1.getValue() == 1).limit(1)
                .collect(Collectors.toList()).get(0).getKey());

        // or
        System.out.println(st.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum, LinkedHashMap::new)).entrySet()
                .stream().filter(e -> e.getValue() == 1).limit(1).collect(Collectors.toList()).get(0).getKey());

        // Joining Strings: Given a List of strings, join them into a single comma-separated string using streams.

        StringBuilder s1 = new StringBuilder("");
        strings.stream().forEach(st1 -> {
            s1.append(st1).append(",");
        });
        System.out.println(s1.substring(0, s1.length() - 2));

        // or

        System.out.println(strings.stream().collect(Collectors.joining(",")));

        // remove duplicate character of a string
        String string = "alpha";

        LinkedHashSet<Character> uniqueChars = string.chars().mapToObj(c-> (char) c).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(uniqueChars);

        System.out.println(string.chars().mapToObj(c-> (char) c).collect(Collectors.toMap(c-> c, c->1, Integer::sum, LinkedHashMap::new))
                .entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList ()));



    }
}
