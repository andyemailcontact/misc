package com.eileenvivian.preps.backtrack;

public class CoinChange {
    // size is the length of coins array
    public static int makeChange(int coins[], int index, int amount)
    {
        if (index >= coins.length - 1) {
            return 1; // last coin type, success
        }
        int coinAmount = coins[index];
        int ways = 0;
        for(int i=0; i * coinAmount <= amount; i++) {
            int amountRemaining = amount - i * coinAmount;
            ways += makeChange(coins, index + 1, amountRemaining);
        }
        return ways;
    }

    public static void main(String[] args) {
        int coins[] = { 1, 5, 10, 25 };
        System.out.println(makeChange(coins, 0, 6));
    }
}
