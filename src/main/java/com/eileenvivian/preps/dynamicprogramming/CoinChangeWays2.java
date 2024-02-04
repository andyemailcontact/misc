package com.eileenvivian.preps.dynamicprogramming;

/*
 * Calculate all number of ways to total up amount with coins type
 */
public class CoinChangeWays2 {
    static int count(int coins[], int i, int sum)
    {

        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0)
            return 1;

        // If sum is less than 0 then no
        // solution exists
        if (sum < 0)
            return 0;

        // If there are no coins and sum
        // is greater than 0, then no
        // solution exist
//        if (i >= coins.length)
//            return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        int res = 0;
        for(int j=i; j<coins.length; j++) {
            if (coins[j] <= sum) {
                res = count(coins, i + 1, sum)
                        + count(coins, i, sum - coins[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        System.out.println(count(coins, 0, 15));
    }
}
