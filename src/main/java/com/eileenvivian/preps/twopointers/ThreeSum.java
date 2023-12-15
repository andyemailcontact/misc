package com.eileenvivian.preps.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    private static List<Integer[]> findThreeSum(int[] nums, int target) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result.add(new Integer[] { nums[i], nums[left], nums[right] });
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
