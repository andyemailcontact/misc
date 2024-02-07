package com.eileenvivian.preps.bitwise;

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
