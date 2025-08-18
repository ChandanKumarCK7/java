package Leetcode.LCmedium;






import java.util.Arrays;

public class MaximumPossibleScoreFromNJumps {
    public static int getMaxScore(int[] nums, int index, int[] dp) {
        if (index == nums.length - 1)
            return 0;
        int result = 0;
        if (dp[index] != 0) return dp[index];
        for (int i = index + 1; i < nums.length; i++) {
            // At each iteration we decide to land + sub problem.
            result = Math.max(result, (i - index) * nums[i] + getMaxScore(nums, i, dp));
        }
        dp[index] = result;
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3, 12, 9, 10};
        int[] dp = new int[nums.length];
        System.out.println(getMaxScore(nums, 0, dp));
        System.out.println(Arrays.toString(dp));
    }
}

