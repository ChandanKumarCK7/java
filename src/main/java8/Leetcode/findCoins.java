





package Leetcode;


import java.util.ArrayList;

public class findCoins {


    public static boolean isPrime(int n) {
        // Edge case: numbers less than or equal to 1 are not prime
        if (n <= 1) return false;

        // 2 and 3 are prime numbers
        if (n <= 3) return true;

        // Eliminate even numbers and multiples of 3
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Check divisors starting from 5, incrementing by 6 (skip multiples of 2 and 3)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        // If no divisors found, the number is prime
        return true;
    }

    public static boolean findIfPossibleToCreateCustomCoin(ArrayList<Integer> coins, int i, int t, int n, boolean[][] localDp){
        if (i == n){
            if (t == 0)
                return true;
            return false;
        }

        if (localDp[i][t])
            return localDp[i][t];

        boolean take = false;
        if (t - coins.get(i) >= 0 ){
            take = findIfPossibleToCreateCustomCoin(coins, i, t-coins.get(i), n, localDp);
        }
        boolean not_take = findIfPossibleToCreateCustomCoin(coins, i+1, t, n, localDp);

        return localDp[i][t] = take || not_take;

    }

    public static void main(String[] args){
        int target = 10;
        int n = 3;
        int[] dp = new int[]{ 1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3};
        ArrayList<Integer> answerCoins = new ArrayList<>();

        for(int i = 0 ; i < dp.length; i++){
        // find the very primes that have dp[i] == 1
            if (i > 0 &&  dp[i] == 1 &&  isPrime(i) && answerCoins.size() < n-1){
                // add them to answerCoins
                answerCoins.add(i);
            }
            // now find remaining coins
            else {
                // use minCoins algorithm to check if possible to find a remaining coin with current answerCoins
                boolean v = findIfPossibleToCreateCustomCoin(answerCoins, 0, i, answerCoins.size(), new boolean[answerCoins.size()][i+1]);
                // if u can then check if dp[i] > 1 because u can have it in answerCoins only if
                if (v && dp[i] > 1 && answerCoins.size() < n){
                    // that is a real coin used to make dp and  if u can make that coin using existing coins.
                    answerCoins.add(i);
                }
            }
        }


        if (answerCoins.size() == n){
            System.out.println(answerCoins);
        }
        else{
            System.out.println("impossible");
        }
    }

}
