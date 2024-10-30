package com.ifocus.preps.dynamicprogramming;

/*
 * Given the weights and profits of 'N' items, we are asked to put these items in a knapsack that has a capacity 'C'.
 * The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we
 * don't have multiple quantities of any item.
 */
public class MaxProfit {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if( weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);
        }
        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{ 1,6,10,16 };
        int[] profits = new int[]{ 1,2,3,5 };
        int profit = new MaxProfit().solveKnapsack(profits, weights, 7);
        System.out.println("max profit = " + profit);
    }
}

