import java.util.*;







public class CompareTo {
    public static void main(String[] args){

        PriorityQueue<String> pq = new PriorityQueue<String>((a,b) -> a.compareTo(b));
        pq.add("apple");
        pq.add("banana");
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        System.out.println("=====");

        PriorityQueue<String> pq1 = new PriorityQueue<String>((a,b) -> b.compareTo(a));
        pq1.add("apple");
        pq1.add("banana");
        System.out.println(pq1.poll());
        System.out.println(pq1.poll());


    }
}

//Case 1: `x.compareTo(y)`
//
//        ```
//        "banana".compareTo("apple") = positive (b > a)
//```
//
//Positive → **y ("apple") gets popped first** (smaller one)
//
//        ---
//
//        ### Case 2: `y.compareTo(x)`
//
//        ```
//        "apple".compareTo("banana") = negative (a < b)
//```
//
//Negative → **x ("banana") gets popped first** (larger one)
