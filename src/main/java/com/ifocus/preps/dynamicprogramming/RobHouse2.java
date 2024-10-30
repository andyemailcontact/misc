package com.ifocus.preps.dynamicprogramming;

import java.util.Arrays;

class RobHouse2 {

    private int[] memo;

    public int rob(int[] nums) {

        this.memo = new int[100];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);

        return this.robFrom(0, nums);
    }

    private int robFrom(int start, int[] nums) {

        // No more houses left to examine.
//        if (i >= nums.length) {
//            return 0;
//        }

        // Return cached value.
        if (this.memo[start] > -1) {
            return this.memo[start];
        }
        int ans = 0;
        for(int i=start; i<nums.length; i++) {
            // Recursive relation evaluation to get the optimal answer.
            ans = Math.max(ans, Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]));
        }
        // Cache for future use.
        this.memo[start] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new RobHouse2().rob(new int[]{2,7,9,3,1}));
    }
}
