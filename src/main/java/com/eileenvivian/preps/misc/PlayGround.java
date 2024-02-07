package com.eileenvivian.preps.misc;

public class PlayGround {
    public static void main(String[] args) {
        int num = 20;
        for(int i=20; i>0; i--) {
            System.out.println(Integer.toBinaryString(num));
            System.out.println("right bit: " + (num & 1));
            num = num >> 1;
        }

        System.out.println("exp=" + Integer.toBinaryString((int) (Math.pow(2, 5) - 1)));
    }
}
