package com.eileenvivian.preps.permutation;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */

class StringPermutation2 {
    public static List<String> permute(String str) {
        List<String> ans = new ArrayList<>();
        backtrack(0, ans, new StringBuilder(), str);
        return ans;
    }

    private static void backtrack(int start, List<String> ans, StringBuilder buf, String str) {
        if (buf.length() == str.length()) {
            ans.add(buf.toString());
            return;
        }

        for (int i=0; i<str.length(); i++) {
                // add and check
                buf.append(str.charAt(i));
                backtrack(i+1, ans, buf, str);
                // backout
                buf.deleteCharAt(buf.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> list = permute("abc");
        list.stream().forEach(System.out::println);
    }
}
