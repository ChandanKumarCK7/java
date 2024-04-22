

//import Streams.ComparatorImpl;

//import Streams.ComparatorImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;




//class ComparatorImpl implements Comparator{
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        return 0;
//    }
//}




public class File {


    // Driver Code
    public static void main(String[] args) {
        String s = "01, karan, arya | 02, sumit, aryan | 03, lalith, kiran | 01, karan, suraj";
        // output = karan - 2, sumit - 1, lalith - 1 (sort descending) if complexity will be high to sort then leave unsorted.

        findDependents(s);


    }

    public static void findDependents(String s){
        HashMap<String, Integer> h = new HashMap<>();



        String[] entries = s.split("\\|");
        System.out.println(Arrays.toString(entries));
        for(String employeeEntry : entries){
            String[] family = employeeEntry.split(",");

            h.put(family[1], h.getOrDefault(family[1], 0) +1);
        }

//        ComparatorImpl c = new ComparatorImpl();
//        Collections.sort(h, new ComparatorImpl());

//        for(int i =0; i<h.size(); i++){
//            for(int j = i+1; j< h.size(); j++){
//                if (h.get(i). )
//            }
//        }
        System.out.println(h);


    }



}
