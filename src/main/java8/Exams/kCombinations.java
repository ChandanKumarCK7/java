package Exams;






import java.util.ArrayList;


public class kCombinations {



    public static void main(String[] args){
        int a[] = new int[]{1, 6, 5, 4, 3};
        int k = 3;


        findCombinations(a, 0, a.length, k, new ArrayList<>());
    }

    public static void findCombinations(int[] a, int index, int n, int k, ArrayList<Integer> ar){
        if (ar.size() == k){
            System.out.println(ar);
            return;
        }

        if (index == n )
            return;

        ar.add(a[index]);
        findCombinations(a, index + 1, n,  k, ar);

        ar.remove(ar.size() - 1);
        findCombinations(a, index + 1, n, k, ar);
    }

}
