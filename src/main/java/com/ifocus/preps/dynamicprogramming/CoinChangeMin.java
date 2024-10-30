package com.ifocus.preps.dynamicprogramming;

public class CoinChangeMin {
    // m is size of coins array (number of different coins)
    public static int coinChange(int[] denominations, int total) {
        int result = countChangeRecursive(denominations, total, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int countChangeRecursive(int[] denominations, int total, int startIndex) {
        // base check
        if (total == 0)
            return 0;

        if(startIndex >= denominations.length)
            return Integer.MAX_VALUE;

        // recursive call after selecting the coin at the startIndex
        // if the coin at startIndex exceeds the total, we shouldn't process this
        int count1 = Integer.MAX_VALUE;
        if( denominations[startIndex] <= total ) {
            int res = countChangeRecursive(denominations, total - denominations[startIndex], startIndex);
            if(res != Integer.MAX_VALUE){
                count1 = res + 1;
            }
        }

        // recursive call after excluding the coin at the startIndex
        int count2 = countChangeRecursive(denominations, total, startIndex + 1);

        return Math.min(count1, count2);
    }

    public static void main(String args[]) {
        int coins[] = {25, 10, 5, 1};
        int m = coins.length;
        int amount = 36;
        System.out.println("Minimum coins required is " + coinChange(coins, amount));
    }
}
