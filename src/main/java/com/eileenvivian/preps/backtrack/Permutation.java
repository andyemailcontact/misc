package com.eileenvivian.preps.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */

class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    private static void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num: nums) {
            if (!curr.contains(num)) {
                // add and check
                curr.add(num);
                backtrack(curr, ans, nums);
                // backout
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        lists.stream().forEach(System.out::println);
    }
}
