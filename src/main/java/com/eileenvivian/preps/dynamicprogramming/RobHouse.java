package com.eileenvivian.preps.dynamicprogramming;

import java.util.Arrays;

class RobHouse {

    private int[] memo;

    public int rob(int[] nums) {

        this.memo = new int[nums.length];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);

        return this.robFrom(0, nums);
    }

    private int robFrom(int i, int[] nums) {

        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }

        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }

        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);

        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(new RobHouse().rob(new int[]{2,7,9,3,1}));
        StringBuilder buf = new StringBuilder("Nam Mo Quan The Am Bo Tat");
        for(int i=0; i<100; i++) {
            System.out.println(buf.toString());
        }
    }
}
