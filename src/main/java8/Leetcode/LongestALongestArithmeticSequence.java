package Leetcode;


public class LongestALongestArithmeticSequence {

    static final int MIN_DIFF = -500;
    static final int DIFF_RANGE = 1001;

    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n == 2)  return 2;
        int maxSeqLen = 0;
        int[][] dp = new int[n][DIFF_RANGE];
        for (int right = 0; right < nums.length; ++right) {
            for (int left = 0; left < right; ++left) {
                int diff = nums[left] - nums[right] - MIN_DIFF;
                int ij = dp[left][diff];
                maxSeqLen = Math.max(maxSeqLen, (dp[right][diff] = ij + 1));
            }
        }
        return maxSeqLen + 1;
    }
    public static void main(String[] args){
        System.out.println(longestArithSeqLength(new int[]{1, 2,3, 4}));
    }
}
