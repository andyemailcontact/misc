package com.eileenvivian.preps.dynamicprogramming;

// Java program for the above approach

public class EggDrop {

    /* Function to get minimum number of
    trials needed in worst case with eggNum
    eggs and floors floors */
    static int eggDrop(int eggNum, int floors) {
        // If there are no floors, then
        // no trials needed. OR if there
        // is one floor, one trial needed.
        if (floors == 1 || floors == 0 || eggNum == 1)
            return floors;

        int min = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from
        // 1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (x = 1; x <= floors; x++) {
            res = Math.max(eggDrop(eggNum - 1, x - 1),
                    eggDrop(eggNum, floors - x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }

    // Driver code
    public static void main(String args[]) {
        int n = 2, k = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with " + n
                + " eggs and " + k + " floors is "
                + eggDrop(n, k));
    }
    // This code is contributed by Ryuga.
}

