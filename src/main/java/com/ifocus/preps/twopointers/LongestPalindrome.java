package com.ifocus.preps.twopointers;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int beginIndex = 0, endIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            if (oddLength > endIndex - beginIndex + 1) {
                int dist = oddLength / 2;
                beginIndex = i - dist;
                endIndex = i + dist;
            }

            int evenLength = expand(i, i + 1, s);
            if (evenLength > endIndex - beginIndex + 1) {
                int dist = (evenLength / 2) - 1;
                beginIndex = i - dist;
                endIndex = i + dist + 1;
            }
        }

        return s.substring(beginIndex, endIndex + 1);
    }

    // Return max palindrome substring from the middle
    private static int expand(int i, int j, String s) {
        int left = i;
        int right = j;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "iamaracecaryes";
        System.out.println("Longest palindrome for " + str + " is " + longestPalindrome(str));
    }
}
