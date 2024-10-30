package com.ifocus.preps.permutation;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */

class Subset {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), ans, nums);
        return ans;
    }

    private static void backtrack(int start, List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        ans.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, ans, nums);
            // backout
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        lists.stream().forEach(System.out::println);
    }
}
