package Exams;






import java.util.Arrays;

public class MaximumPossibleOfRatings {

    static int m;

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 5, 4, 5, 5 , 5, 5 , 2, 1};

        m = Integer.MIN_VALUE;
        findPossibilities1(a, 0, 0);
        System.out.println("output: " + m);
    }

    public static void findPossibilities1(int[] a, int index, int c){
        Arrays.sort(a);
        for(int i =0; i < a.length -1 ; i++){
            if (a[i] < a[i+1]){
                c+=1;
            }
        }
        System.out.println(c);
    }
    public static void findPossibilities(int[] a, int index, int c) {
        if (index == a.length) {
            m = Math.max(m, c);
            System.out.println(Arrays.toString(a) + " " + c);
            return;
        }

        for (int i = index; i < a.length; i++) {
            swap(a, i, index);

            int newC = c;
            if (index < a.length - 1 && a[index] < a[index + 1]) {
                findPossibilities(a, index + 1, newC+1);
            }
            else{
                findPossibilities(a, index + 1, newC);
            }

            swap(a, i, index);  // Backtrack
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
