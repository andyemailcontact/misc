package com.ifocus;

import java.util.HashMap;

public class MaxSubarrayEqualZeroOne {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 1}; // Example input array
        System.out.println("Maximum length of subarray with equal 0s and 1s: " + findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {
        // HashMap to store the first occurrence index of the cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int cumulativeSum = 0;
        // Initialize the map with the base case: cumulative sum of 0 at index -1
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // Update the cumulative sum: treat 0 as -1 to balance the sum
            cumulativeSum += (nums[i] == 1) ? 1 : -1;
            // If cumulativeSum has been seen before, calculate the length of the subarray
            if (map.containsKey(cumulativeSum)) {
                int length = i - map.get(cumulativeSum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Store the first occurrence of the cumulativeSum
                map.put(cumulativeSum, i);
            }
        }
        return maxLength;
    }
}