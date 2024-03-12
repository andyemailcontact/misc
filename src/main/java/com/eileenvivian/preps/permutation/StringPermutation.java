package com.eileenvivian.preps.permutation;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */

class StringPermutation {
    public static List<String> permute(String str) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), str, new boolean[str.length()]);
        return ans;
    }

    private static void backtrack(List<String> ans, StringBuilder buf, String str, boolean[] used) {
        if (buf.length() == str.length()) {
            ans.add(buf.toString());
            return;
        }

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (!used[i]) {
                // add and check
                buf.append(c);
                used[i] = true;
                backtrack(ans, buf, str, used);
                // backout
                buf.deleteCharAt(buf.length()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = permute("abc");
        list.stream().forEach(System.out::println);
    }
}
