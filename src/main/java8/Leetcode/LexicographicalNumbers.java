package Leetcode;




import java.util.List;
import java.util.ArrayList;





public class LexicographicalNumbers {

    public static void main(String[] args){
        List<Integer> a = lexicalOrder(19);
        System.out.println(a.toString());
    }
    static public List<Integer> lexicalOrder(int n) {
        List<Integer> al = new  ArrayList<>();
        int curr = 1;
        for(int i=1; i<=n; i++)
        {
            al.add(curr);
            int i1 = curr * 10;
            if(i1 <=n)
                curr = i1;
            else
            {
                while(curr%10==9 || curr>=n)
                {
                    curr = curr/10;
                }
                curr += 1;
            }
        }
        return al;

    }


}





// problem to just print numbers lexicographically