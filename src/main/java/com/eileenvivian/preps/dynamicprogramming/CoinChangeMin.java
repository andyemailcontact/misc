package com.eileenvivian.preps.dynamicprogramming;

public class CoinChangeMin {
    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        // Initialize result
        int res = Integer.MAX_VALUE;
        // Try every coin that has smaller value than amount
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                res = Math.min(res, minCoins(coins, amount - coins[i]) + 1);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int coins[] = {25, 10, 5, 1};
        int m = coins.length;
        int amount = 31;
        System.out.println("Minimum coins required is " + minCoins(coins, amount));
    }
}
