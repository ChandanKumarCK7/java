package Leetcode;




import java.util.*;



// https://leetcode.com/problems/contiguous-array/?envType=problem-list-v2&envId=o52jwf3v
// Logic is derived based on prefix Sum
public class arrayContiguous {




        public static int findMaxLength(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> mp = new HashMap<>();
            int sum = 0;
            int subArrayLength = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i] == 0 ? -1 : 1;
                if (sum == 0) {
                    subArrayLength = i + 1;
                } else if (mp.containsKey(sum)) {
                    subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
                } else {
                    mp.put(sum, i);
                }
            }
            return subArrayLength;
        }


        public static void main(String[] args){
            int[] a = new int[]{1, 0, 0, 1,0, 1, 0, 1};
            System.out.println( findMaxLength(a));
        }
}
