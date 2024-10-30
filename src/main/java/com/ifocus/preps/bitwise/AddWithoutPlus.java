package com.ifocus.preps.bitwise;

/*
 * If x and y don’t have set bits at same position(s), then bitwise XOR (^) of x and y gives the sum of x and y.
 * To incorporate common set bits also, bitwise AND (&) is used. Bitwise AND of x and y gives all carry bits.
 * We calculate (x & y) << 1 and add it to x ^ y to get the required result.
 */

public class AddWithoutPlus {
    static int iterative_add(int x, int y) {
        while(y != 0){
            int carry = x & y;
            x = x ^ y; // XOR
            y = carry << 1;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(iterative_add(1, -5));
    }
}
