//import java.util.*;
//
//
//
//
//
//class PersonX{
//    String name;
//    ArrayList<String> cities;
//
//    public PersonX(String name, ArrayList<String> cities){
//        this.name = name;
//        this.cities = cities;
//    }
//
//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//
//        if ((o instanceof PersonX) == false) return false;
//
//        PersonX x = (PersonX) o;
//
//        return this.name.equals(x.name);
//    }
//
//    @Override
//    public int hashCode(){
//        return Objects.hash(this.name);
//    }
//}
//public class File {
//    public static void main(String[] args){
//        PersonX a = new PersonX("Alpha", new ArrayList<>(Arrays.asList("B", "C")));
//        PersonX b = new PersonX("Beta", new ArrayList<>(Arrays.asList("B", "C")));
//
//        System.out.println(a == b);
//    }
//
////    public static int func(String s, int k ){
////
////        HashMap<Character, Integer> freq = new HashMap<>();
////        int answer = 0, count= 0;
////
////        int l = 0, r = 0;
////        int n = s.length();
////
////        while(l <= r && r < n){
////            char c = s.charAt(r);
////            freq.put(c, freq.getOrDefault(c, 0) +1);
////
////            while((int) s.charAt(r) != (int)s.charAt(l)){
//////                System.out.println("here " + s.charAt(r) + s.charAt(l) + answer + " "+ count);
////                l++;
////                if (freq.containsKey(c)){
////                    freq.put(c, freq.get(c) - 1);
////                }
////                else{
////                    freq.remove(c);
////                }
////                count = 0;
////            }
////
////            if ((int) s.charAt(r) == (int)s.charAt(l)){
////                count+=1;
////            }
////
////            if (count >= k)
////                answer = Math.max(answer, count);
////
////            r++;
////        }
////
////        System.out.println(answer);
////
////        return answer;
////
////    }
////
////
////    // grid = 1(island), 0(water)
////    // grid = [[1, 1]
////    //          [0, 1]] // find length of maax connected islands
////
////
////    // ["1","1","0","0","0"],
////    //  ["1","1","0","0","0"],
////    //  ["0","0","1","0","0"],
////    //  ["0","0","0","1","1"]
////
////    public static int func1(int[][] a, int m, int n){
////        Queue<Pair> q = new LinkedList<>();
////        boolean[][] visited = new boolean[m][n];
////
////        for(int i = 0; i < m; i++){
////            for(int j = 0; j < n; j++){
////                if (a[i][j] == 1){
////                    funcRecursion(a, i, j, visited);
////                    visited[i][j] = true;
////                }
////            }
////        }
////
////        int answer = 0;
////
////        int[] aR = new int[]{0, -1, 0, +1};
////        int[] aC = new int[]{-1, 0, +1, 0};
////
////        while(q.size() > 0){
////            Pair p = q.remove();
////            int i = p.i;
////            int j = p.j;
////            int c = p.c;
////
////            System.out.println(i+" "+ j+" "+c);
////            answer = Math.max(answer, c);
////
////            for(int i1 = 0; i1<aR.length; i1++){
////                for(int j1 = 0; j1<aC.length; j1++){
////                    int adjR = aR[i1] + i;
////                    int adjC = aC[j1] + j;
////                    if (adjR >= 0 && adjR < m && adjC >= 0 && adjC < n && visited[adjR][adjC] == false){
////                        q.add(new Pair(adjR, adjC, c+1));
////                        visited[adjR][adjC] = true;
////                    }
////                }
////            }
////        }
////
////        return answer;
////    }
////
////    public static int funcRecursion(int[][] a, int i, int j, boolean visited[][]){
////        int m = a.length, n = a[0].length;
////        if (i< 0 || i>=m || j < 0 || j >= n || visited[i][j] == true || a[i][j] == 0)
////            return 0;
////
//////        int[] aR = new int[]{0, -1, 0, +1};
//////        int[] aC = new int[]{-1, 0, +1, 0};
////
////        int l = funcRecursion(a, i,j-1, visited);
////        int t = funcRecursion(a, i-1,j, visited);
////        int r = funcRecursion(a, i,j+1, visited);
////        int d = funcRecursion(a, i+1,j, visited);
////
////        return l+t+r+d+1;
////        // base
////    }
////
////
////}
////
////
////class Pair{
////    int i;
////    int j;
////    int c;
////
////    public Pair(int i, int j, int c){
////        this.i = i;
////        this.j = j;
////        this.c = c;
////    }
//}