package com.eileenvivian.preps.dynamicprogramming;

import java.util.Arrays;

public class LongestAA {
    public static int solve(int aa, int bb, int ab, StringBuilder buf) {
        int res = 0;

        if (aa > 0 && (buf.length() == 0 || buf.charAt(buf.length() - 1) != 'A')) {
            buf.append("AA");
            res = Math.max(res, 2 + solve(aa - 1, bb, ab, buf));
        }
        if (bb > 0 && (buf.length() == 0 || buf.charAt(buf.length() - 1) != 'B')) {
            buf.append("BB");
            res = Math.max(res, 2 + solve(aa, bb - 1, ab, buf));
        }

        if (ab > 0 && (buf.length() == 0 || buf.substring(buf.length() - 2).equals("AA"))) {
            buf.append("BB");
            res = Math.max(res, 2 + solve(aa, bb - 1, ab, buf));
        }
        return res;
    }


    public static void main(String[] args) {
        StringBuilder buf = new StringBuilder();
        int max = solve(5, 0, 2, buf);
        System.out.println("buf=" + buf.toString() + "|" + buf.length() + "|max=" + max);

//        int[][] mem = new int[5][10];
//        Arrays.stream(mem).forEach(a -> Arrays.fill(a, 1));
//        System.out.println(mem);

    }
}

